package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.LoginPageBO;
import lk.ijse.global_flavour.dao.custom.LoginPageDAO;
import lk.ijse.global_flavour.dao.custom.impl.LoginPageDAOImpl;
//import lk.ijse.global_flavour.dto.LoginSetAndGet;
import lk.ijse.global_flavour.dto.UserDTO;

import java.sql.SQLException;

public class LoginPageBOImpl implements LoginPageBO {
    LoginPageDAO loginPageDAO = new LoginPageDAOImpl();

    public UserDTO searchUser(String userName) throws SQLException{
        return loginPageDAO.searchUserName(userName);
    }
}
