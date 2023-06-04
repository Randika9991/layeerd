package lk.ijse.global_flavour.dao.custom;

import lk.ijse.global_flavour.dao.CrudDAO;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.FogotYourPasswordDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface FogotYourPasswordDAO extends CrudDAO<FogotYourPasswordDTO,String> {
     FogotYourPasswordDTO searchUser(String email) throws SQLException ;
}
