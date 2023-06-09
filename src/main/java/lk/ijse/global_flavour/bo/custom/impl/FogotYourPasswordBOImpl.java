package lk.ijse.global_flavour.bo.custom.impl;


import lk.ijse.global_flavour.bo.custom.FogotYourPasswordBO;
import lk.ijse.global_flavour.dao.DAOFactory;
import lk.ijse.global_flavour.dao.custom.UserDAO;
import lk.ijse.global_flavour.dao.custom.impl.UserDAOImpl;
import lk.ijse.global_flavour.dto.UserDTO;

import java.sql.SQLException;

public class FogotYourPasswordBOImpl implements FogotYourPasswordBO {

    UserDAO fogotYourPasswordDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.USER);

    public UserDTO FogotYourPasswordsearchUser(String email) throws SQLException {
        return fogotYourPasswordDAO.searchUserEmail(email);
    }
}
