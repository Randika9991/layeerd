package lk.ijse.global_flavour.dao.custom.impl;

import lk.ijse.global_flavour.dao.custom.FogotYourPasswordDAO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.FogotYourPasswordDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FogotYourPasswordDAOImpl implements FogotYourPasswordDAO {
    @Override
    public boolean save(FogotYourPasswordDTO SalaryAdd) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<FogotYourPasswordDTO> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean update(FogotYourPasswordDTO adminSalary) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<FogotYourPasswordDTO> search(String salId) throws SQLException {
        return null;
    }


    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public FogotYourPasswordDTO searchUser(String email) throws SQLException {

        ResultSet rst =  SQLUtil.execute("SELECT * FROM user WHERE email = ?", email);
        if (rst.next()) {
            return new FogotYourPasswordDTO(rst.getString(1),rst.getString(2),rst.getString(3), rst.getString(4), rst.getString(5));
        }
        return null;
    }

}
