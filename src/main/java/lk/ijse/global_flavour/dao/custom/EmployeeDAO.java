package lk.ijse.global_flavour.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.global_flavour.dao.CrudDAO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.dto.EmployeeDTO;
import lk.ijse.global_flavour.entity.Employee;
import lk.ijse.global_flavour.view.tdm.AdminSalaryTM;
import lk.ijse.global_flavour.view.tdm.EmployeeTM;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EmployeeDAO extends CrudDAO<Employee,String> {

    public int getTotEmployee() throws SQLException, ClassNotFoundException ;


}
