package lk.ijse.global_flavour.dao.custom.impl;

import lk.ijse.global_flavour.dao.custom.UserDAO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.dto.UserDTO;
import lk.ijse.global_flavour.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean save(User user) throws SQLException {
        String sql = "INSERT INTO user(userName,empId,password, email,jobTitle) VALUES (?,?, ?, ?, ?)";
        return SQLUtil.execute(sql, user.getUserName(), null, user.getPassword(), user.getEmail(), user.getJobTitle());

    }

    @Override
    public ArrayList<User> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean update(User user) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE user SET empId = ?, password = ?, email = ?, jobTitle = ? WHERE userName = ?";
        return SQLUtil.execute(sql, user.getEmpId(), user.getPassword(), user.getEmail(), user.getJobTitle(), user.getUserName());
    }

    @Override
    public ArrayList<User> search(String salId) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    public UserDTO searchUserName(String userName) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM user WHERE userName = ?", userName);
        if (rst.next()) {
            return new UserDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));
        }
        return null;
    }

    public UserDTO searchUserEmail(String userEmail) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM user WHERE email = ?", userEmail);
        if (rst.next()) {
            return new UserDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));
        }
        return null;
    }
}
