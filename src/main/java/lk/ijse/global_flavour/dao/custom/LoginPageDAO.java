package lk.ijse.global_flavour.dao.custom;

import lk.ijse.global_flavour.dao.CrudDAO;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.LoginSetAndGet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface LoginPageDAO extends CrudDAO {
     LoginSetAndGet searchUserName(String userName) throws SQLException ;
}