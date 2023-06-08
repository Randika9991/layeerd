package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.CreateNewAccountBO;
import lk.ijse.global_flavour.dao.custom.CreateNewAccountDAO;
import lk.ijse.global_flavour.dao.custom.impl.CreateNewAccountDAOImpl;
import lk.ijse.global_flavour.dto.UserDTO;

import java.sql.SQLException;

public class CreateNewAccountBOImpl implements CreateNewAccountBO {
    CreateNewAccountDAO newAccountDAO = new CreateNewAccountDAOImpl();

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
