package lk.ijse.global_flavour.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.global_flavour.bo.BOFactory;
import lk.ijse.global_flavour.dao.DAOFactory;
import lk.ijse.global_flavour.dao.custom.QuaryDAO;
import lk.ijse.global_flavour.dao.custom.impl.QuaryDAOImpl;

import java.sql.SQLException;

public class HomeFormController {

    @FXML
    private AnchorPane adminAncPane;

    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private PieChart pieChart;

    @FXML
    private Label lblTotalCustomer;

    @FXML
    private Label lblTotalSales;

    @FXML
    private Label lblTotalEmployee;

    QuaryDAO homeFormBO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.QUARY);

    private void countTotalCust(){
        try {
            int count = homeFormBO.getTotCustomers();
            lblTotalCustomer.setText(String.valueOf(count));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void countTotalEmp(){
        try {
            int count = homeFormBO.getTotEmployee();
            lblTotalEmployee.setText(String.valueOf(count));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void countTotalSales(){
        try {
            int count = homeFormBO.getTotalSales();
            lblTotalSales.setText(String.valueOf(count));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        countTotalCust();
        countTotalEmp();
        countTotalSales();

        setDataToPieChart();
        lineChart();
    }

    public void setDataToPieChart() {
        ObservableList<PieChart.Data> pieChartData = null;
        try {
            pieChartData = homeFormBO.getDataToPieChart();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        pieChart.setData(pieChartData);
    }

    void lineChart() {
        lineChart.setTitle("Income Chart 2023");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");


        try {
            XYChart.Series series = homeFormBO.lineChartData();
            series.setName("Income Chart");
            lineChart.getData().add(series);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
