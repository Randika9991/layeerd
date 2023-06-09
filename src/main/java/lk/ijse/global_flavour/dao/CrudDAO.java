package lk.ijse.global_flavour.dao;

import javafx.collections.ObservableList;
import lk.ijse.global_flavour.view.tdm.AdminSalaryTM;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO <T,t> extends SuperDAO{
     boolean save(T SalaryAdd) throws SQLException ;

     ArrayList<T> getAll() throws SQLException ;

      boolean update(T adminSalary) throws SQLException, ClassNotFoundException ;

      ArrayList<T> search(t salId) throws SQLException ;

      boolean delete(t id) throws SQLException ;

     // ObservableList<T> getAllKeyType() throws SQLException;

}
