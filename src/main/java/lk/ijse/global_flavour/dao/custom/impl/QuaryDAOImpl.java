package lk.ijse.global_flavour.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import lk.ijse.global_flavour.dao.custom.QuaryDAO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuaryDAOImpl implements QuaryDAO {

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
