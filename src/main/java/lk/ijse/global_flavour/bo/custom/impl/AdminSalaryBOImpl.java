package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.AdminSalaryBO;
import lk.ijse.global_flavour.dao.DAOFactory;
import lk.ijse.global_flavour.dao.custom.AdminSalaryDAO;
import lk.ijse.global_flavour.dao.custom.EmployeeDAO;
import lk.ijse.global_flavour.dao.custom.impl.AdminSalaryDAOImpl;
import lk.ijse.global_flavour.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.global_flavour.dto.AdminSalaryDTO;
import lk.ijse.global_flavour.dto.CashierCustomerDTO;
import lk.ijse.global_flavour.dto.EmployeeDTO;
import lk.ijse.global_flavour.entity.Customer;
import lk.ijse.global_flavour.entity.Employee;
import lk.ijse.global_flavour.entity.Salary;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdminSalaryBOImpl implements AdminSalaryBO {
    AdminSalaryDAO salaryDAO =  DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ADMINSALARY);
    EmployeeDAO employeeDAO =  DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    public boolean AdminSalarySave(AdminSalaryDTO adminSalaryDTO) throws SQLException {
        return salaryDAO.save(new Salary(adminSalaryDTO.getSalaryId(),adminSalaryDTO.getEmployId(),adminSalaryDTO.getAmount(),adminSalaryDTO.getPayment()));
    }

    public ArrayList<AdminSalaryDTO> AdminSalaryGetAll() throws SQLException {
        ArrayList<Salary> arrayList = salaryDAO.getAll();
        ArrayList<AdminSalaryDTO> dtoArrayList = new ArrayList<>();
        for (Salary c: arrayList) {
            dtoArrayList.add(new AdminSalaryDTO(c.getSalaryId(), c.getEmpId(), c.getAmount(), c.getPaymentmethod()));
        }
        return dtoArrayList;
    }

    public boolean AdminSalaryUpdate(AdminSalaryDTO adminSalaryDTO) throws SQLException, ClassNotFoundException {
        return salaryDAO.update(new Salary(adminSalaryDTO.getSalaryId(),adminSalaryDTO.getEmployId(),adminSalaryDTO.getAmount(),adminSalaryDTO.getPayment()));

    }

    public ArrayList<AdminSalaryDTO> AdminSalarySearch(String salId) throws SQLException {
        ArrayList<Salary> arrayList = salaryDAO.search(salId);
        ArrayList<AdminSalaryDTO> dtoArrayList = new ArrayList<>();
        for (Salary c: arrayList) {
            dtoArrayList.add(new AdminSalaryDTO(c.getSalaryId(), c.getEmpId(), c.getAmount(), c.getPaymentmethod()));
        }
        return dtoArrayList;
    }

    public boolean AdminSalaryDelete(String id) throws SQLException {
        return salaryDAO.delete(id);
    }

    public ArrayList<EmployeeDTO> GetAllEmployee() throws SQLException {
        ArrayList<Employee> arrayList = employeeDAO.getAll();
        ArrayList<EmployeeDTO> dtoArrayList = new ArrayList<>();

        for (Employee employeeDTO : arrayList) {
            dtoArrayList.add(new EmployeeDTO(employeeDTO.getEmpId(),employeeDTO.getEmpName(),employeeDTO.getAddress(),employeeDTO.getDob(),employeeDTO.getContactNo(),employeeDTO.getEmail(),employeeDTO.getNic(),
                    employeeDTO.getJobTitle()));
        }
        return dtoArrayList;
    }



}
