package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.ChangePasswordBO;
import lk.ijse.global_flavour.dao.custom.CashierVehicleDAO;
import lk.ijse.global_flavour.dao.custom.ChangePasswordDAO;
import lk.ijse.global_flavour.dao.custom.impl.ChangePasswordDAOImpl;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.dto.ChangePasswordDTO;

import java.sql.SQLException;

public class ChangePasswordBOImpl implements ChangePasswordBO {

    ChangePasswordDAO changePasswordDAO = new ChangePasswordDAOImpl();

    public boolean updatePassword(ChangePasswordDTO changePasDTO) throws SQLException, ClassNotFoundException {
        return changePasswordDAO.update(changePasDTO);
    }
}
