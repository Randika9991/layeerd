package lk.ijse.global_flavour.dao.custom;

import javafx.scene.chart.XYChart;
import lk.ijse.global_flavour.dao.CrudDAO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.dto.OrderCartDTO;
import lk.ijse.global_flavour.dto.OrderDTO;
import lk.ijse.global_flavour.entity.Orders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface OrderFormDAO extends CrudDAO <Orders,String>{

    String getNextOrderId() throws SQLException;

    public XYChart.Series lineChartData() throws SQLException, ClassNotFoundException ;

    public int getTotalSales() throws SQLException, ClassNotFoundException ;

}
