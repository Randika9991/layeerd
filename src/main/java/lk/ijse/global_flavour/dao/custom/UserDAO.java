package lk.ijse.global_flavour.dao.custom;

import lk.ijse.global_flavour.dao.CrudDAO;
import lk.ijse.global_flavour.dto.UserDTO;

import java.sql.SQLException;

public interface UserDAO extends CrudDAO<UserDTO,String> {
    UserDTO searchUserName(String userName) throws SQLException;

    UserDTO searchUserEmail(String userEmail) throws SQLException;
}
