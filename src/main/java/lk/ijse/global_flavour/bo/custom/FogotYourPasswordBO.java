package lk.ijse.global_flavour.bo.custom;

import lk.ijse.global_flavour.bo.SuperBO;
import lk.ijse.global_flavour.dto.UserDTO;
//import lk.ijse.global_flavour.dto.FogotYourPasswordDTO;

import java.sql.SQLException;

public interface FogotYourPasswordBO extends SuperBO {
    public UserDTO FogotYourPasswordsearchUser(String email) throws SQLException ;
}
