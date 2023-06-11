package lk.ijse.global_flavour.dao.custom.impl;

import javafx.scene.chart.XYChart;
import lk.ijse.global_flavour.dao.custom.OrderFormDAO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.OrderCartDTO;
import lk.ijse.global_flavour.dto.OrderDTO;
import lk.ijse.global_flavour.entity.Orders;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OrderFormDAOImpl implements OrderFormDAO {
    @Override
    public boolean save(Orders orders) throws SQLException {
        String sql = "INSERT INTO orders(orderId, custId, payment,time,date,deliveryStatus) VALUES(?, ?, ?, ?, ?,?)";

        return SQLUtil.execute(
                sql,
                orders.getOrderId(),
                orders.getCustId(),
                orders.getPayment(),
                orders.getTime(),
                orders.getDate(),
                orders.getDeliveryStatus()

        );
    }

    @Override
    public ArrayList<Orders> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean update(Orders adminSalary) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<Orders> search(String salId) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    public String getNextOrderId() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();

        String sql = "SELECT orderId FROM orders ORDER BY orderId DESC LIMIT 1";

        ResultSet resultSet = con.createStatement().executeQuery(sql);

        if (resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);
    }

    private static String splitOrderId(String currentId) {
        if(currentId != null) {
            String[] strings = currentId.split("ORD-");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "ORD-00" + id;
        }
        return "ORD-001";
    }


    public XYChart.Series lineChartData() throws SQLException, ClassNotFoundException {

        ResultSet resultSet= SQLUtil.execute("SELECT MONTHNAME(date),sum(payment) from orders group by MONTHNAME(date)");
        XYChart.Series series=new XYChart.Series();
        while (resultSet.next()){
            series.getData().add(new XYChart.Data(resultSet.getString(1),resultSet.getInt(2)));
        }
        return series;
    }

    public int getTotalSales() throws SQLException, ClassNotFoundException {
        String sql="SELECT count(orderId) FROM orders ";
        ResultSet resultSet= SQLUtil.execute(sql);
        int count=0;
        while (resultSet.next()){
            count=resultSet.getInt(1);
        }
        return count;
    }

    /*public boolean saveOrder(String oId, String cId, double payment, LocalDate date, LocalTime time, List<OrderCartDTO> orderDTOList, boolean delivery) throws SQLException {
        for(OrderCartDTO dto : orderDTOList) {
            if(!saveOrder(oId,cId,payment,date,time,dto,delivery)) {
                return false;
            }
            break;
        }
        return true;
    }
    private boolean saveOrder(String oId, String cId, double payment, LocalDate date, LocalTime time, OrderCartDTO dto, boolean delivery) throws SQLException {

        String sql = "INSERT INTO orders(orderId, custId, payment,time,date,deliveryStatus) VALUES(?, ?, ?, ?, ?,?)";

        return SQLUtil.execute(
                sql,
                oId,
                cId,
                payment,
                time,
                date,
                delivery

        );
    }*/

}
