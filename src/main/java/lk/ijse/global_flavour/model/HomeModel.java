package lk.ijse.global_flavour.model;

import javafx.scene.chart.XYChart;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.util.SQLUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeModel {

    public static int getTotCustomers() throws SQLException, ClassNotFoundException {
        String sql="SELECT COUNT(custId) FROM Customer";
        ResultSet resultSet= SQLUtil.execute(sql);
        int count=0;
        while (resultSet.next()){
            count=resultSet.getInt(1);
        }
        return count;

    }

    public static int getTotEmployee() throws SQLException, ClassNotFoundException {
        String sql="SELECT COUNT(empId) FROM employee";
        ResultSet resultSet= SQLUtil.execute(sql);
        int count=0;
        while (resultSet.next()){
            count=resultSet.getInt(1);
        }
        return count;

    }
    public static XYChart.Series lineChartData() throws SQLException, ClassNotFoundException {
        String sql="SELECT MONTHNAME(date),sum(payment) from orders group by MONTHNAME(date)";
        ResultSet resultSet= SQLUtil.execute(sql);
        XYChart.Series series=new XYChart.Series();
        while (resultSet.next()){
            series.getData().add(new XYChart.Data(resultSet.getString(1),resultSet.getInt(2)));
        }
        return series;

    }
}
