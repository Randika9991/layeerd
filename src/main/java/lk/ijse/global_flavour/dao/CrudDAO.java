package lk.ijse.global_flavour.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO <T,t>{
     boolean save(T SalaryAdd) throws SQLException ;

     ArrayList<T> getAll() throws SQLException ;

      boolean update(T adminSalary) throws SQLException, ClassNotFoundException ;

      ArrayList<T> search(t salId) throws SQLException ;

      boolean delete(t id) throws SQLException ;

}
