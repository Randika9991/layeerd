package lk.ijse.global_flavour.bo.custom;

import lk.ijse.global_flavour.bo.SuperBO;
import lk.ijse.global_flavour.dto.AdminSalaryDTO;
import lk.ijse.global_flavour.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AdminSalaryBO extends SuperBO {
    public boolean AdminSalarySave(AdminSalaryDTO adminSalaryDTO) throws SQLException ;

    public ArrayList<AdminSalaryDTO> AdminSalaryGetAll() throws SQLException ;

    public boolean AdminSalaryUpdate(AdminSalaryDTO adminSalaryDTO) throws SQLException, ClassNotFoundException ;

    public ArrayList<AdminSalaryDTO> AdminSalarySearch(String salId) throws SQLException ;

    public boolean AdminSalaryDelete(String id) throws SQLException ;

    public ArrayList<EmployeeDTO> GetAllEmployee() throws SQLException ;

}
