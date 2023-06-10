package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.ChangePasswordBO;
import lk.ijse.global_flavour.dao.DAOFactory;
import lk.ijse.global_flavour.dao.custom.UserDAO;
import lk.ijse.global_flavour.dao.custom.impl.UserDAOImpl;
import lk.ijse.global_flavour.dto.UserDTO;
import lk.ijse.global_flavour.entity.User;

import java.sql.SQLException;

public class ChangePasswordBOImpl implements ChangePasswordBO {

    UserDAO changePasswordDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.USER);

    public boolean updatePassword(UserDTO changePasDTO) throws SQLException, ClassNotFoundException {
        return changePasswordDAO.update(new User(changePasDTO.getUsrname(),changePasDTO.getEmpid(),changePasDTO.getPassword(),changePasDTO.getEmail(),changePasDTO.getJobtitel()));
    }
}
