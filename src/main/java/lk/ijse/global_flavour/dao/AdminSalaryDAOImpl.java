package lk.ijse.global_flavour.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.AdminSalaryDTO;
import lk.ijse.global_flavour.dto.EmployeeDTO;
import lk.ijse.global_flavour.util.SQLUtil;
import lk.ijse.global_flavour.view.tdm.AdminSalaryTM;
import lk.ijse.global_flavour.view.tdm.CashierVehicleTM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminSalaryDAOImpl implements AdminSalaryDAO{

    @Override
    public boolean save(AdminSalaryDTO adminSalaryDTO) throws SQLException {
        String sql = "INSERT INTO salary(salaryId,empId,amount,paymentmethod) " +
               "VALUES(?, ?, ?, ?)";
        return SQLUtil.execute(sql, adminSalaryDTO.getSalaryId(), adminSalaryDTO.getEmployId(), adminSalaryDTO.getAmount(), adminSalaryDTO.getPayment());

    }

    @Override
    public ArrayList<AdminSalaryDTO> getAll() throws SQLException {
        String sql = "SELECT * FROM salary";
        ResultSet rst = SQLUtil.execute(sql);
        ArrayList<AdminSalaryDTO> arrayList = new ArrayList<>();
         while (rst.next()) {
             arrayList.add(new AdminSalaryDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4)));
        }
        return arrayList;
    }

    @Override
    public boolean update(AdminSalaryDTO adminSalaryDTO) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE salary SET empId =?, amount =?, paymentmethod =? WHERE salaryId =?";
        return SQLUtil.execute(sql,adminSalaryDTO.getEmployId(), adminSalaryDTO.getAmount(), adminSalaryDTO.getPayment(),adminSalaryDTO.getSalaryId());
    }

    @Override
    public ArrayList<AdminSalaryDTO> search(String salId) throws SQLException {

        ResultSet rst = SQLUtil.execute("SELECT * FROM salary WHERE salaryId = ?");

        ArrayList<AdminSalaryDTO> arrayList = new ArrayList<>();

        if (rst.next()) {
            arrayList.add(new AdminSalaryDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4)));
        }
        return arrayList;

    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.execute("DELETE FROM salary WHERE salaryId = ?", id);
    }

    @Override
    public ObservableList<AdminSalaryTM> getAllSalaryKeyBord() throws SQLException {

        ResultSet rst = SQLUtil.execute("SELECT * FROM salary");
            ObservableList<AdminSalaryTM> dataList = FXCollections.observableArrayList();

            while (rst.next()) {
                dataList.add(new AdminSalaryTM(rst.getString(1), rst.getString(2), rst.getString(3),rst.getString(4)));
            }
            return dataList;
        }

    public ArrayList<EmployeeDTO> getAllEmployee() throws SQLException {

        ResultSet rst = SQLUtil.execute("SELECT empId from employee");
        ArrayList<EmployeeDTO> arrayList = new ArrayList<>();
        while (rst.next()) {
            arrayList.add(new EmployeeDTO(rst.getString(1)));
        }
        return arrayList;
    }

}
