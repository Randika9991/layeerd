package lk.ijse.global_flavour.dao.custom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.global_flavour.dao.CrudDAO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.AdminSalaryDTO;
import lk.ijse.global_flavour.dto.CashierCustomerDTO;
import lk.ijse.global_flavour.entity.Customer;
import lk.ijse.global_flavour.view.tdm.CashierCustomerTM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface CashierCustomerDAO extends CrudDAO<Customer,String> {

     int getTotCustomers() throws SQLException, ClassNotFoundException ;

}
