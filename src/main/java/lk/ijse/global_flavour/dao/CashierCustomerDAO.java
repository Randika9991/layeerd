package lk.ijse.global_flavour.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.AdminSalaryDTO;
import lk.ijse.global_flavour.dto.CashierCustomerDTO;
import lk.ijse.global_flavour.view.tdm.CashierCustomerTM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface CashierCustomerDAO extends CrudDAO<CashierCustomerDTO,String>{
     ObservableList<CashierCustomerTM> getAllKeyType() throws SQLException ;
}
