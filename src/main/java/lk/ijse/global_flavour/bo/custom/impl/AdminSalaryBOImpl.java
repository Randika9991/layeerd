package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.AdminSalaryBO;
import lk.ijse.global_flavour.dao.DAOFactory;
import lk.ijse.global_flavour.dao.custom.AdminSalaryDAO;
import lk.ijse.global_flavour.dao.custom.EmployeeDAO;
import lk.ijse.global_flavour.dao.custom.impl.AdminSalaryDAOImpl;
import lk.ijse.global_flavour.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.global_flavour.dto.AdminSalaryDTO;
import lk.ijse.global_flavour.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdminSalaryBOImpl implements AdminSalaryBO {
    AdminSalaryDAO salaryDAO =  DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ADMINSALARY);
    EmployeeDAO employeeDAO =  DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    public boolean AdminSalarySave(AdminSalaryDTO adminSalaryDTO) throws SQLException {
        return salaryDAO.save(adminSalaryDTO);
    }

    public ArrayList<AdminSalaryDTO> AdminSalaryGetAll() throws SQLException {
        return salaryDAO.getAll();
    }

    public boolean AdminSalaryUpdate(AdminSalaryDTO adminSalaryDTO) throws SQLException, ClassNotFoundException {
        return salaryDAO.update(adminSalaryDTO);

    }

    public ArrayList<AdminSalaryDTO> AdminSalarySearch(String salId) throws SQLException {
        return salaryDAO.search(salId);
    }

    public boolean AdminSalaryDelete(String id) throws SQLException {
        return salaryDAO.delete(id);
    }

    public ArrayList<EmployeeDTO> GetAllEmployee() throws SQLException {
        return employeeDAO.getAll();
    }



}
