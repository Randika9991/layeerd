package lk.ijse.global_flavour.dao.custom.impl;

import lk.ijse.global_flavour.dao.custom.ChangePasswordDAO;
import lk.ijse.global_flavour.dto.ChangePasswordDTO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class ChangePasswordDAOImpl implements ChangePasswordDAO {
    @Override
    public boolean save(ChangePasswordDTO SalaryAdd) throws SQLException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public ArrayList<ChangePasswordDTO> getAll() throws SQLException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public boolean update(ChangePasswordDTO changePasDTO) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE user SET empId = ?, password = ?, email = ?, jobTitle = ? WHERE userName = ?";
        return SQLUtil.execute(sql, changePasDTO.getEmpid(), changePasDTO.getPassword(), changePasDTO.getEmail(), changePasDTO.getJobtitel(), changePasDTO.getUsrname());

    }

    @Override
    public ArrayList<ChangePasswordDTO> search(String salId) throws SQLException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public boolean delete(String id) throws SQLException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

}