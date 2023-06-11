package lk.ijse.global_flavour.bo.custom;

import javafx.scene.chart.XYChart;
import lk.ijse.global_flavour.bo.SuperBO;

import java.sql.SQLException;

public interface HomeBO extends SuperBO {
    public int getTotCustomersfgf() throws SQLException, ClassNotFoundException;

    public int getTotEmployeeHome() throws SQLException, ClassNotFoundException;

    public XYChart.Series lineChartData() throws SQLException, ClassNotFoundException;

    public int getTotalSales() throws SQLException, ClassNotFoundException;
}
