package lk.ijse.global_flavour.dao.custom;

import lk.ijse.global_flavour.dao.CrudDAO;
import lk.ijse.global_flavour.dto.CreateNewAccountDTO;
import lk.ijse.global_flavour.dto.LoginSetAndGet;

import java.sql.SQLException;

public interface CreateNewAccountDAO extends CrudDAO<CreateNewAccountDTO,String> {
     CreateNewAccountDTO searchUserName(String userName) throws SQLException;

     CreateNewAccountDTO searchUserEmail(String userEmail) throws SQLException;
}
