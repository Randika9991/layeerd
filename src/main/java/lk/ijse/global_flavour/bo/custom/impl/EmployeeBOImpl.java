package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.EmployeeBO;
import lk.ijse.global_flavour.dao.DAOFactory;
import lk.ijse.global_flavour.dao.custom.EmployeeDAO;
import lk.ijse.global_flavour.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.dto.EmployeeDTO;
import lk.ijse.global_flavour.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    public boolean saveEmployee(EmployeeDTO employeeDTO) throws SQLException {
        return employeeDAO.save(new Employee(employeeDTO.getEmployeeId(),employeeDTO.getEmployeeName(),employeeDTO.getAddress(),employeeDTO.getDOB(),employeeDTO.getCotactNo(),employeeDTO.getEmail(),employeeDTO.getNic(),
              employeeDTO.getJobTittle()
        ));
    }

    public ArrayList<EmployeeDTO> getAllEmployee() throws SQLException {
        ArrayList<Employee> arrayList = employeeDAO.getAll();
        ArrayList<EmployeeDTO> dtoArrayList = new ArrayList<>();

        for (Employee employeeDTO : arrayList) {
            dtoArrayList.add(new EmployeeDTO(employeeDTO.getEmpId(),employeeDTO.getEmpName(),employeeDTO.getAddress(),employeeDTO.getDob(),employeeDTO.getContactNo(),employeeDTO.getEmail(),employeeDTO.getNic(),
                    employeeDTO.getJobTitle()));
        }
        return dtoArrayList;
    }

    public boolean updateEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(new Employee(employeeDTO.getEmployeeId(),employeeDTO.getEmployeeName(),employeeDTO.getAddress(),employeeDTO.getDOB(),employeeDTO.getCotactNo(),employeeDTO.getEmail(),employeeDTO.getNic(),
                employeeDTO.getJobTittle()));
    }

    public ArrayList<EmployeeDTO> searchEmployee(String salId) throws SQLException {

        ArrayList<Employee> arrayList = employeeDAO.search(salId);
        ArrayList<EmployeeDTO> dtoArrayList = new ArrayList<>();

        for (Employee employeeDTO : arrayList) {
            dtoArrayList.add(new EmployeeDTO(employeeDTO.getEmpId(),employeeDTO.getEmpName(),employeeDTO.getAddress(),employeeDTO.getDob(),employeeDTO.getContactNo(),employeeDTO.getEmail(),employeeDTO.getNic(),
                    employeeDTO.getJobTitle()));
        }
        return dtoArrayList;
    }

    public boolean deleteEmployee(String id) throws SQLException {
        return employeeDAO.delete(id);
    }
}
