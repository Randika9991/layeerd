package lk.ijse.global_flavour.dao.custom.impl;

import lk.ijse.global_flavour.dao.custom.CreateNewAccountDAO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.dto.UserDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CreateNewAccountDAOImpl implements CreateNewAccountDAO {
    @Override
    public boolean save(UserDTO newAccountDTO) throws SQLException {
        String sql = "INSERT INTO user(userName,empId,password, email,jobTitle) VALUES (?,?, ?, ?, ?)";
        return SQLUtil.execute(sql, newAccountDTO.getUsrname(), null, newAccountDTO.getPassword(), newAccountDTO.getEmail(), newAccountDTO.getJobtitel());
    }

    @Override
    public ArrayList<UserDTO> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean update(UserDTO adminSalary) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<UserDTO> search(String salId) throws SQLException {
        return null;

    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public UserDTO searchUserName(String userName) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM user WHERE userName = ?", userName);
        if (rst.next()) {
           return new UserDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));
        }
        return null;
    }

    @Override
    public UserDTO searchUserEmail(String userEmail) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM user WHERE email = ?", userEmail);
        if (rst.next()) {
           return new UserDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));
        }
        return null;
    }
}
