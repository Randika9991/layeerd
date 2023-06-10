package lk.ijse.global_flavour.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.global_flavour.dao.custom.CashierCustomerDAO;
import lk.ijse.global_flavour.dto.CashierCustomerDTO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.entity.Customer;
import lk.ijse.global_flavour.view.tdm.CashierCustomerTM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CashierCustomerDAOImpl implements CashierCustomerDAO {

    @Override
    public boolean save(Customer ent) throws SQLException {
        String sql = "INSERT INTO customer(custId, custName, contactNo ,Address ,email) VALUES (?, ?, ?, ? ,?)";
        return SQLUtil.execute(sql, ent.getCustId(), ent.getCustName(), ent.getContactNo(), ent.getAddress(), ent.getEmail());

    }

    @Override
    public ArrayList<Customer> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM customer");
        ArrayList<Customer> arrayList = new ArrayList<>();
        while (rst.next()) {
            arrayList.add(new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),rst.getString(5)));
        }
        return arrayList;
    }

    @Override
    public boolean update(Customer ent) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE customer SET custName = ?, contactNo = ?, Address = ?, email = ? WHERE custId = ?",ent.getCustName(),ent.getContactNo(),ent.getAddress(),ent.getEmail(),ent.getCustId() );

    }

    @Override
    public ArrayList<Customer> search(String salId) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM customer WHERE custId = ?",salId);

        ArrayList<Customer> arrayList = new ArrayList<>();

        if (rst.next()) {
            arrayList.add(new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),rst.getString(5)));
        }
        return arrayList;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.execute("DELETE FROM customer WHERE custId = ?",id);
    }

}
