package lk.ijse.global_flavour.bo.custom;


import lk.ijse.global_flavour.dto.UserDTO;

import java.sql.SQLException;

public interface ChangePasswordBO {
     boolean updatePassword(UserDTO changePasDTO) throws SQLException, ClassNotFoundException;
}
