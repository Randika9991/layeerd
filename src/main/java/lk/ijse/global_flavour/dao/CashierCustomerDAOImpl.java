package lk.ijse.global_flavour.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.AdminSalaryDTO;
import lk.ijse.global_flavour.dto.CashierCustomerDTO;
import lk.ijse.global_flavour.util.SQLUtil;
import lk.ijse.global_flavour.view.tdm.AdminSalaryTM;
import lk.ijse.global_flavour.view.tdm.CashierCustomerTM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CashierCustomerDAOImpl implements CashierCustomerDAO{

    @Override
    public boolean save(CashierCustomerDTO customerDTO) throws SQLException {
        String sql = "INSERT INTO customer(custId, custName, contactNo ,Address ,email) VALUES (?, ?, ?, ? ,?)";
        return SQLUtil.execute(sql, customerDTO.getCustomerId(), customerDTO.getCustomerName(), customerDTO.getContactNo(), customerDTO.getAddress(), customerDTO.getEmail());
    }

    @Override
    public ArrayList<CashierCustomerDTO> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM customer");
        ArrayList<CashierCustomerDTO> arrayList = new ArrayList<>();
        while (rst.next()) {
            arrayList.add(new CashierCustomerDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),rst.getString(5)));
        }
        return arrayList;
    }

    @Override
    public boolean update(CashierCustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE customer SET custName = ?, contactNo = ?, Address = ?, email = ? WHERE custId = ?",customerDTO.getCustomerName(),customerDTO.getContactNo(),customerDTO.getAddress(),customerDTO.getEmail(),customerDTO.getCustomerId() );

    }

    @Override
    public ArrayList<CashierCustomerDTO> search(String salId) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM customer WHERE custId = ?");

        ArrayList<CashierCustomerDTO> arrayList = new ArrayList<>();

        if (rst.next()) {
            arrayList.add(new CashierCustomerDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),rst.getString(5)));
        }
        return arrayList;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.execute("DELETE FROM customer WHERE custId = ?",id);
    }

     public ObservableList<CashierCustomerTM> getAllKeyType() throws SQLException {

         ResultSet rst = SQLUtil.execute("SELECT * FROM customer");
         ObservableList<CashierCustomerTM> dataList = FXCollections.observableArrayList();

         while (rst.next()) {
             dataList.add(new CashierCustomerTM(rst.getString(1), rst.getString(2), rst.getString(3),rst.getString(4),rst.getString(5)));
         }
         return dataList;

    }
}
