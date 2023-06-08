package lk.ijse.global_flavour.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.EmployeeDTO;
import lk.ijse.global_flavour.view.tdm.EmployeeTM;

import java.sql.*;

public class EmployeeSetAndGetModel {
//    public static boolean save(EmployeeDTO EmployeeAdd) throws SQLException {  //data baes ekata dana set eka
//
//        String sql = "INSERT INTO employee(empId, empName, addrsss, dob, contactNo, email, nic, jobTitle) " +
//                "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
//
//        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {
//
//            pstm.setString(1, EmployeeAdd.getEmployeeId());
//            pstm.setString(2, EmployeeAdd.getEmployeeName());
//            pstm.setString(3, EmployeeAdd.getAddress());
//            pstm.setString(4, EmployeeAdd.getDOB());
//            pstm.setString(5, EmployeeAdd.getCotactNo());
//            pstm.setString(6, EmployeeAdd.getEmail());
//            pstm.setString(7, EmployeeAdd.getNic());
//            pstm.setString(8, EmployeeAdd.getJobTittle());
//
//            return pstm.executeUpdate() > 0;
//        }
//    }

    /*public static EmployeeDTO search(String id) throws SQLException {
        String sql = "SELECT * FROM employee WHERE empId = ?";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {
            pstm.setString(1, id);
            ResultSet resultSet = pstm.executeQuery();

            if(resultSet.next()) {
                return new EmployeeDTO(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8)
                );
            }
            return null;
        }
    }
*/
   /* public static ObservableList<EmployeeTM> getAll() throws SQLException {
        String sql = "SELECT * FROM employee";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {
            ResultSet resultSet = pstm.executeQuery();
            ObservableList<EmployeeTM> dataList = FXCollections.observableArrayList();

            while (resultSet.next()) {
                dataList.add(new EmployeeTM(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                         resultSet.getString(7),
                        resultSet.getString(8)
                ));
            }
            return dataList;
        }
    }*/
/*
    public static boolean change(EmployeeDTO employeeDTO) throws SQLException {

        String sql = "UPDATE employee SET empName = ?,addrsss = ?, dob = ?,contactNo = ?, email = ?,nic = ?,jobTitle = ? WHERE empId = ?";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            pstm.setString(1, employeeDTO.getEmployeeName());
            pstm.setString(2, employeeDTO.getAddress());
            pstm.setString(3, employeeDTO.getDOB());
            pstm.setString(4, employeeDTO.getCotactNo());
            pstm.setString(5, employeeDTO.getEmail());
            pstm.setString(6, employeeDTO.getNic());
            pstm.setString(7, employeeDTO.getJobTittle());
            pstm.setString(8, employeeDTO.getEmployeeId());

            return pstm.executeUpdate() > 0;
        }
    }*/

    /*public static boolean delete(String empid) throws SQLException {

        String sql = "DELETE FROM employee WHERE empId = ?";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            pstm.setString(1, empid);
            return pstm.executeUpdate() > 0;
        }
    }*/
}
