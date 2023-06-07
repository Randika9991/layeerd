package lk.ijse.global_flavour.bo.custom;

import lk.ijse.global_flavour.dto.LoginSetAndGet;

import java.sql.SQLException;

public interface LoginPageBO {

    public LoginSetAndGet searchUser(String userName) throws SQLException ;
}
