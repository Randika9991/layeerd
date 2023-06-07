package lk.ijse.global_flavour.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import lk.ijse.global_flavour.dao.custom.HomeFormDAO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HomeFormDAOImpl implements HomeFormDAO {
    @Override
    public boolean save(Object SalaryAdd) throws SQLException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public ArrayList getAll() throws SQLException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public boolean update(Object adminSalary) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public ArrayList search(Object salId) throws SQLException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public boolean delete(Object id) throws SQLException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public int getTotCustomers() throws SQLException, ClassNotFoundException {
        ResultSet resultSet= SQLUtil.execute("SELECT COUNT(custId) FROM Customer");
        int count=0;
        while (resultSet.next()){count=resultSet.getInt(1);
        }
        return count;
    }

    @Override
    public int getTotEmployee() throws SQLException, ClassNotFoundException {
        ResultSet resultSet= SQLUtil.execute("SELECT COUNT(empId) FROM employee");
        int count=0;
        while (resultSet.next()){
            count=resultSet.getInt(1);
        }
        return count;
    }

    @Override
    public XYChart.Series lineChartData() throws SQLException, ClassNotFoundException {

        ResultSet resultSet= SQLUtil.execute("SELECT MONTHNAME(date),sum(payment) from orders group by MONTHNAME(date)");
        XYChart.Series series=new XYChart.Series();
        while (resultSet.next()){
            series.getData().add(new XYChart.Data(resultSet.getString(1),resultSet.getInt(2)));
        }
        return series;
    }

    @Override
    public int getTotalSales() throws SQLException, ClassNotFoundException {
        String sql="SELECT count(orderId) FROM orders ";
        ResultSet resultSet= SQLUtil.execute(sql);
        int count=0;
        while (resultSet.next()){
            count=resultSet.getInt(1);
        }
        return count;
    }

    @Override
    public ObservableList<PieChart.Data> getDataToPieChart() throws SQLException, ClassNotFoundException {
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
    }
}
