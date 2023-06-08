package lk.ijse.global_flavour.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import lk.ijse.global_flavour.dto.OrderCartDTO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailModel {
    /*public static boolean save(String oId, List<OrderCartDTO> orderDTOList) throws SQLException {
        for (OrderCartDTO dto : orderDTOList){
            if(!save(oId,dto)){
                return false;
            }
        }
        return true;
    }

    private static boolean save(String oId, OrderCartDTO dto) throws SQLException {
        String sql = "INSERT INTO orderdetail(orderId, itemCode, qty, unitPrice)" +
                "VALUES(?, ?, ?, ?)";

        return SQLUtil.execute(
                sql,
                oId,
                dto.getCode(),
                dto.getQty(),
                dto.getUnitPrice()
        );
    }*/
}
