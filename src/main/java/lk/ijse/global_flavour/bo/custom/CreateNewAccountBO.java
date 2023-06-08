package lk.ijse.global_flavour.bo.custom;

import lk.ijse.global_flavour.dto.UserDTO;

import java.sql.SQLException;

public interface CreateNewAccountBO {
     boolean saveNewUser(UserDTO newAccountDTO) throws SQLException ;

     UserDTO searchUserName(String userName) throws SQLException ;

     UserDTO searchUserEmail(String userEmail) throws SQLException ;
}
