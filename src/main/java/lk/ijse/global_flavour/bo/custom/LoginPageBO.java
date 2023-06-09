package lk.ijse.global_flavour.bo.custom;

//import lk.ijse.global_flavour.dto.LoginSetAndGet;
import lk.ijse.global_flavour.bo.SuperBO;
import lk.ijse.global_flavour.dto.UserDTO;

import java.sql.SQLException;

public interface LoginPageBO extends SuperBO {

    public UserDTO searchUser(String userName) throws SQLException ;
}
