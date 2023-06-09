package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.CreateNewAccountBO;
import lk.ijse.global_flavour.dao.DAOFactory;
import lk.ijse.global_flavour.dao.custom.UserDAO;
import lk.ijse.global_flavour.dto.UserDTO;

import java.sql.SQLException;

public class CreateNewAccountBOImpl implements CreateNewAccountBO {

    /*UserDAO newAccountDAO = new UserDAOImpl();*/
    UserDAO newAccountDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.USER);

    public boolean saveNewUser(UserDTO newAccountDTO) throws SQLException {
        return newAccountDAO.save(newAccountDTO);
    }

    public UserDTO searchUserName(String userName) throws SQLException {
        return newAccountDAO.searchUserName(userName);
    }

    public UserDTO searchUserEmail(String userEmail) throws SQLException {
        return newAccountDAO.searchUserEmail(userEmail);
    }
}
