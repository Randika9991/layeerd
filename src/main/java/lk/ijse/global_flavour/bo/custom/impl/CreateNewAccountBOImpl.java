package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.CreateNewAccountBO;
import lk.ijse.global_flavour.dao.custom.CreateNewAccountDAO;
import lk.ijse.global_flavour.dao.custom.impl.CreateNewAccountDAOImpl;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.dto.CreateNewAccountDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CreateNewAccountBOImpl implements CreateNewAccountBO {
    CreateNewAccountDAO newAccountDAO = new CreateNewAccountDAOImpl();

    public boolean saveNewUser(CreateNewAccountDTO newAccountDTO) throws SQLException {
        return newAccountDAO.save(newAccountDTO);
    }

    public CreateNewAccountDTO searchUserName(String userName) throws SQLException {
        return newAccountDAO.searchUserName(userName);
    }

    public CreateNewAccountDTO searchUserEmail(String userEmail) throws SQLException {
        return newAccountDAO.searchUserEmail(userEmail);
    }
}
