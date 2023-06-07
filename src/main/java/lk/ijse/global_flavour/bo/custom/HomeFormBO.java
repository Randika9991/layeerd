package lk.ijse.global_flavour.bo.custom;

import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import java.sql.SQLException;

public interface HomeFormBO {
     int getTotCustomers() throws SQLException, ClassNotFoundException ;

     int getTotEmployee() throws SQLException, ClassNotFoundException ;

     XYChart.Series lineChartData() throws SQLException, ClassNotFoundException ;

     int getTotalSales() throws SQLException, ClassNotFoundException ;

     ObservableList<PieChart.Data> getDataToPieChart() throws SQLException, ClassNotFoundException ;
}
