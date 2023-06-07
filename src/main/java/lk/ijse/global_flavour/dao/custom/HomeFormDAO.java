package lk.ijse.global_flavour.dao.custom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import lk.ijse.global_flavour.dao.CrudDAO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface HomeFormDAO extends CrudDAO {

     int getTotCustomers() throws SQLException, ClassNotFoundException ;

     int getTotEmployee() throws SQLException, ClassNotFoundException ;

     XYChart.Series lineChartData() throws SQLException, ClassNotFoundException ;

     int getTotalSales() throws SQLException, ClassNotFoundException ;

     ObservableList<PieChart.Data> getDataToPieChart() throws SQLException, ClassNotFoundException;

}
