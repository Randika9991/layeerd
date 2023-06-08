package lk.ijse.global_flavour.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeModel {

    /*public static int getTotCustomers() throws SQLException, ClassNotFoundException {
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

    public static int getTotalSales() throws SQLException, ClassNotFoundException {
        String sql="SELECT count(orderId) FROM orders ";
        ResultSet resultSet= SQLUtil.execute(sql);
        int count=0;
        while (resultSet.next()){
            count=resultSet.getInt(1);
        }
        return count;
    }

    public static ObservableList<PieChart.Data> getDataToPieChart() throws SQLException, ClassNotFoundException {
        String sql="SELECT item.itemName,COUNT(orderdetail.orderId) FROM orderDetail INNER JOIN item ON item.itemCode = orderdetail.itemCode INNER JOIN orders\n" +
                " ON orderdetail.orderId=orders.orderId WHERE MONTH(orders.date) = MONTH(CURRENT_DATE()) GROUP BY item.itemName LIMIT 5;\n";
        ObservableList<PieChart.Data> datalist = FXCollections.observableArrayList();
        ResultSet resultSet = SQLUtil.execute(sql);

        while(resultSet.next()){
            datalist.add(
                    new PieChart.Data(
                            resultSet.getString(1),
                            resultSet.getInt(2)
                    )
            );
        }
        return datalist;
    }*/

}
