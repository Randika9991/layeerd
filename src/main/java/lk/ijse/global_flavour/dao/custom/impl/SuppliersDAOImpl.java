package lk.ijse.global_flavour.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.global_flavour.dao.custom.SuppliersDAO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.CashierCustomerDTO;
import lk.ijse.global_flavour.dto.SuppliersDTO;
import lk.ijse.global_flavour.entity.Supplier;
import lk.ijse.global_flavour.view.tdm.SuppliersTM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SuppliersDAOImpl implements SuppliersDAO {
    @Override
    public boolean save(Supplier suppliers) throws SQLException {
        String sql = "INSERT INTO supplier(supId, SupName, Address, email ,contactNo) VALUES(?, ?, ?, ? ,?)";
        return SQLUtil.execute(sql, suppliers.getSupId(), suppliers.getSupName(),suppliers.getAddress(), suppliers.getEmail(), suppliers.getContactNo());

    }

    @Override
    public ArrayList<Supplier> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM supplier");
        ArrayList<Supplier> arrayList = new ArrayList<>();
        while (rst.next()) {
            arrayList.add(new Supplier(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),rst.getString(5)));
        }
        return arrayList;
    }

    @Override
    public boolean update(Supplier suppliers) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE supplier SET supName = ?, address = ?, email = ?, contactNo = ? WHERE supId = ?",
                suppliers.getSupName(), suppliers.getAddress(), suppliers.getEmail(), suppliers.getContactNo(), suppliers.getSupId());
    }

    @Override
    public ArrayList<Supplier> search(String salId) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM supplier WHERE supId = ?",salId);

        ArrayList<Supplier> arrayList = new ArrayList<>();

        if (rst.next()) {
            arrayList.add(new Supplier(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),rst.getString(5)));
        }
        return arrayList;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.execute("DELETE FROM supplier WHERE supId = ?",id);
    }

    @Override
    public String getSupplierName(String supp_id) throws SQLException {

        ResultSet resultSet = SQLUtil.execute("SELECT supName FROM supplier WHERE supId=?",supp_id);

        if(resultSet.next()){
            return (new String(resultSet.getString(1)));
        }
        return null;
    }
}
