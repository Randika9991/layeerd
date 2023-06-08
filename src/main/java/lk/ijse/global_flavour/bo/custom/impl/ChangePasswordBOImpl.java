package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.ChangePasswordBO;
import lk.ijse.global_flavour.dao.custom.ChangePasswordDAO;
import lk.ijse.global_flavour.dao.custom.impl.ChangePasswordDAOImpl;

import lk.ijse.global_flavour.dto.UserDTO;

import java.sql.SQLException;

public class ChangePasswordBOImpl implements ChangePasswordBO {

    ChangePasswordDAO changePasswordDAO = new ChangePasswordDAOImpl();

    public boolean updatePassword(UserDTO changePasDTO) throws SQLException, ClassNotFoundException {
        return changePasswordDAO.update(changePasDTO);
    }
}
