package lk.ijse.global_flavour.bo.custom.impl;


import lk.ijse.global_flavour.bo.custom.FogotYourPasswordBO;
import lk.ijse.global_flavour.dao.custom.FogotYourPasswordDAO;
import lk.ijse.global_flavour.dao.custom.impl.FogotYourPasswordDAOImpl;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.dto.FogotYourPasswordDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FogotYourPasswordBOImpl implements FogotYourPasswordBO {

    FogotYourPasswordDAO fogotYourPasswordDAO = new FogotYourPasswordDAOImpl();

    public FogotYourPasswordDTO FogotYourPasswordsearchUser(String email) throws SQLException {
        return fogotYourPasswordDAO.searchUser(email);
    }
}
