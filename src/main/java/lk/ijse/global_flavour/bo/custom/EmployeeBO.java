package lk.ijse.global_flavour.bo.custom;

import lk.ijse.global_flavour.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO {
    public boolean saveEmployee(EmployeeDTO employeeDTO) throws SQLException ;

    public ArrayList<EmployeeDTO> getAllEmployee() throws SQLException ;

    public boolean updateEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException ;

    public ArrayList<EmployeeDTO> searchEmployee(String salId) throws SQLException ;

    public boolean deleteEmployee(String id) throws SQLException ;
}
