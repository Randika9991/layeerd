package lk.ijse.global_flavour.dao.custom;

import lk.ijse.global_flavour.dao.CrudDAO;
import lk.ijse.global_flavour.dto.UserDTO;
//import lk.ijse.global_flavour.dto.FogotYourPasswordDTO;

import java.sql.SQLException;

public interface FogotYourPasswordDAO extends CrudDAO<UserDTO,String> {
     UserDTO searchUser(String email) throws SQLException ;
}
