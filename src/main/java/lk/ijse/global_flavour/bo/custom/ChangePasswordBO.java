package lk.ijse.global_flavour.bo.custom;

import lk.ijse.global_flavour.dto.ChangePasswordDTO;

import java.sql.SQLException;

public interface ChangePasswordBO {
     boolean updatePassword(ChangePasswordDTO changePasDTO) throws SQLException, ClassNotFoundException;
}
