package lk.ijse.global_flavour.bo.custom;

import lk.ijse.global_flavour.dto.CreateNewAccountDTO;

import java.sql.SQLException;

public interface CreateNewAccountBO {
     boolean saveNewUser(CreateNewAccountDTO newAccountDTO) throws SQLException ;

     CreateNewAccountDTO searchUserName(String userName) throws SQLException ;

     CreateNewAccountDTO searchUserEmail(String userEmail) throws SQLException ;
}
