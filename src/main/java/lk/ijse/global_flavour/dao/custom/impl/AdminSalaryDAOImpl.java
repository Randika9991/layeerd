package lk.ijse.global_flavour.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.global_flavour.dao.custom.AdminSalaryDAO;
import lk.ijse.global_flavour.dto.AdminSalaryDTO;
import lk.ijse.global_flavour.dto.EmployeeDTO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.entity.Salary;
import lk.ijse.global_flavour.view.tdm.AdminSalaryTM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminSalaryDAOImpl implements AdminSalaryDAO {

    @Override
    public boolean save(Salary salary) throws SQLException {
        String sql = "INSERT INTO salary(salaryId,empId,amount,paymentmethod) " +
               "VALUES(?, ?, ?, ?)";
        return SQLUtil.execute(sql, salary.getSalaryId(), salary.getEmpId(), salary.getAmount(), salary.getPaymentmethod());

    }

    @Override
    public ArrayList<Salary> getAll() throws SQLException {
        String sql = "SELECT * FROM salary";
        ResultSet rst = SQLUtil.execute(sql);
        ArrayList<Salary> arrayList = new ArrayList<>();
         while (rst.next()) {
             arrayList.add(new Salary(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4)));
        }
        return arrayList;
    }

    @Override
    public boolean update(Salary salary) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE salary SET empId =?, amount =?, paymentmethod =? WHERE salaryId =?";
        return SQLUtil.execute(sql,salary.getEmpId(), salary.getAmount(), salary.getPaymentmethod(),salary.getSalaryId());
    }

    @Override
    public ArrayList<Salary> search(String salId) throws SQLException {

        ResultSet rst = SQLUtil.execute("SELECT * FROM salary WHERE salaryId = ?");

        ArrayList<Salary> arrayList = new ArrayList<>();

        if (rst.next()) {
            arrayList.add(new Salary(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4)));
        }
        return arrayList;

    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.execute("DELETE FROM salary WHERE salaryId = ?", id);
    }

}
