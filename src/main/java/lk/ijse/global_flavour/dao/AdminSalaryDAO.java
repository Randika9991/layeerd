package lk.ijse.global_flavour.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.AdminSalaryDTO;
import lk.ijse.global_flavour.dto.EmployeeDTO;
import lk.ijse.global_flavour.view.tdm.AdminSalaryTM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public interface AdminSalaryDAO extends CrudDAO<AdminSalaryDTO,String> {

    ObservableList<AdminSalaryTM> getAllKeyType() throws SQLException;

    ArrayList<EmployeeDTO> getAllEmployee() throws SQLException ;

}
