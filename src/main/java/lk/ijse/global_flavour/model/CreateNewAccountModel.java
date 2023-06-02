package lk.ijse.global_flavour.model;

import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.CreateNewAccountDTO;
import lk.ijse.global_flavour.dto.LoginSetAndGet;
import lk.ijse.global_flavour.dto.UserCreateAcount;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateNewAccountModel {
    public static CreateNewAccountDTO search(String id) throws SQLException {
        String sql = "SELECT * FROM user WHERE email = ?";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            pstm.setString(1, id);

            ResultSet resultSet = pstm.executeQuery();
            if(resultSet.next()) {
                return new CreateNewAccountDTO(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)

                );
            }
            return null;
        }
    }

    public static LoginSetAndGet searchUserName(String userName) throws SQLException {
        String sql = "SELECT * FROM user WHERE userName = ?";
        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            pstm.setString(1, userName);

            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                return new LoginSetAndGet(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                );
            }
            return null;
        }
    }


    public static boolean save(UserCreateAcount userCreate) throws SQLException {  //data baes ekata dana set eka

        String sql = "INSERT INTO user(userName,empId,password, email,jobTitle) " +
                "VALUES(?,?, ?, ?, ?)";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            pstm.setString(1, userCreate.getName());
            pstm.setString(2,null);
            pstm.setString(3, userCreate.getPassword());
            pstm.setString(4, userCreate.getEmail());
            pstm.setString(5, userCreate.getJobTitle());

            return pstm.executeUpdate() > 0;
        }
    }
}
