package lk.ijse.global_flavour.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.global_flavour.dao.custom.SuppliersDAO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.CashierCustomerDTO;
import lk.ijse.global_flavour.dto.SuppliersDTO;
import lk.ijse.global_flavour.view.tdm.SuppliersTM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SuppliersDAOImpl implements SuppliersDAO {
    @Override
    public boolean save(SuppliersDTO suppliersDTO) throws SQLException {
        String sql = "INSERT INTO supplier(supId, SupName, Address, email ,contactNo) VALUES(?, ?, ?, ? ,?)";
        return SQLUtil.execute(sql, suppliersDTO.getSupplierId(), suppliersDTO.getSupplierName(),suppliersDTO.getSupplierAddress(), suppliersDTO.getSupplierEmail(), suppliersDTO.getSupplierCotact());

    }

    @Override
    public ArrayList<SuppliersDTO> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM supplier");
        ArrayList<SuppliersDTO> arrayList = new ArrayList<>();
        while (rst.next()) {
            arrayList.add(new SuppliersDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),rst.getString(5)));
        }
        return arrayList;
    }

    @Override
    public boolean update(SuppliersDTO suppliersDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE supplier SET supName = ?, address = ?, email = ?, contactNo = ? WHERE supId = ?", suppliersDTO.getSupplierName(), suppliersDTO.getSupplierAddress(), suppliersDTO.getSupplierEmail(), suppliersDTO.getSupplierCotact(), suppliersDTO.getSupplierId());
    }

    @Override
    public ArrayList<SuppliersDTO> search(String salId) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM supplier WHERE supId = ?");

        ArrayList<SuppliersDTO> arrayList = new ArrayList<>();

        if (rst.next()) {
            arrayList.add(new SuppliersDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),rst.getString(5)));
        }
        return arrayList;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.execute("DELETE FROM supplier WHERE supId = ?",id);
    }

}
