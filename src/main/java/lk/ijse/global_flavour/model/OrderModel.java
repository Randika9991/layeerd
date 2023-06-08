package lk.ijse.global_flavour.model;

import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.OrderCartDTO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OrderModel {
    public static String getNextOrderId() throws SQLException {
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


        public static boolean save(String oId, String cId, double payment, LocalDate date, LocalTime time, List<OrderCartDTO> orderDTOList, boolean delivery) throws SQLException {
            for(OrderCartDTO dto : orderDTOList) {
                if(!save(oId,cId,payment,date,time,dto,delivery)) {

                    return false;

                }
                break;
            }
            return true;
        }
        private static boolean save(String oId, String cId, double payment, LocalDate date, LocalTime time, OrderCartDTO dto, boolean delivery) throws SQLException {

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
        }

//    public static List<String> loadIds() throws SQLException {
//        Connection con = DBConnection.getInstance().getConnection();
//        ResultSet resultSet = con.createStatement().executeQuery("SELECT custId FROM customer");
//
//        List<String> data = new ArrayList<>();
//
//        while (resultSet.next()) {
//            data.add(resultSet.getString(1));
//        }
//        return data;
//    }

}

