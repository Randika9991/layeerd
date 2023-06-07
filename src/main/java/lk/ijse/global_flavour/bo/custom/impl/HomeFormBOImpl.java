package lk.ijse.global_flavour.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import lk.ijse.global_flavour.bo.custom.HomeFormBO;
import lk.ijse.global_flavour.dao.custom.HomeFormDAO;
import lk.ijse.global_flavour.dao.custom.impl.HomeFormDAOImpl;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeFormBOImpl implements HomeFormBO{
    HomeFormDAO homeFormBO = new HomeFormDAOImpl();

    public int getTotCustomers() throws SQLException, ClassNotFoundException {
        return homeFormBO.getTotCustomers();
    }

    public int getTotEmployee() throws SQLException, ClassNotFoundException {
        return homeFormBO.getTotEmployee();
    }

    public XYChart.Series lineChartData() throws SQLException, ClassNotFoundException {
        return homeFormBO.lineChartData();
    }

    public int getTotalSales() throws SQLException, ClassNotFoundException {
        return homeFormBO.getTotalSales();
    }

    public ObservableList<PieChart.Data> getDataToPieChart() throws SQLException, ClassNotFoundException {
        return homeFormBO.getDataToPieChart();
    }
}
