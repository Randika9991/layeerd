package lk.ijse.global_flavour.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.global_flavour.dao.CrudDAO;
import lk.ijse.global_flavour.dao.custom.EmployeeDAO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.CashierCustomerDTO;
import lk.ijse.global_flavour.dto.EmployeeDTO;
import lk.ijse.global_flavour.view.tdm.CashierVehicleTM;
import lk.ijse.global_flavour.view.tdm.EmployeeTM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean save(EmployeeDTO employeeDTO) throws SQLException {
        String sql = "INSERT INTO employee(empId, empName, addrsss, dob, contactNo, email, nic, jobTitle) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return SQLUtil.execute(sql,  employeeDTO.getEmployeeId(), employeeDTO.getEmployeeName(), employeeDTO.getAddress(), employeeDTO.getDOB(), employeeDTO.getCotactNo(),employeeDTO.getEmail(),employeeDTO.getNic(),employeeDTO.getJobTittle());

    }

    @Override
    public ArrayList<EmployeeDTO> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute( "SELECT * FROM employee");
        ArrayList<EmployeeDTO> arrayList = new ArrayList<>();
        while (rst.next()) {
            arrayList.add(new EmployeeDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8)));
        }
        return arrayList;
    }

    @Override
    public boolean update(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE employee SET empName = ?,addrsss = ?, dob = ?,contactNo = ?, email = ?,nic = ?,jobTitle = ? WHERE empId = ?",employeeDTO.getEmployeeName(), employeeDTO.getAddress(), employeeDTO.getDOB(), employeeDTO.getCotactNo(),employeeDTO.getEmail(),employeeDTO.getNic(),employeeDTO.getJobTittle(),employeeDTO.getEmployeeId() );
    }

    @Override
    public ArrayList<EmployeeDTO> search(String salId) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM employee WHERE empId = ?");

        ArrayList<EmployeeDTO> arrayList = new ArrayList<>();

        if (rst.next()) {
            arrayList.add(new EmployeeDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8)));
        }
        return arrayList;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.execute("DELETE FROM employee WHERE empId = ?",id);
    }

}
