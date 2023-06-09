package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.LoginPageBO;
import lk.ijse.global_flavour.dao.DAOFactory;
import lk.ijse.global_flavour.dao.custom.UserDAO;
import lk.ijse.global_flavour.dao.custom.impl.UserDAOImpl;
import lk.ijse.global_flavour.dto.UserDTO;
import java.sql.SQLException;

public class LoginPageBOImpl implements LoginPageBO {
    UserDAO loginPageDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.USER);

    public UserDTO searchUser(String userName) throws SQLException{
        return loginPageDAO.searchUserName(userName);
    }
}
