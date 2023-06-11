package lk.ijse.global_flavour.bo.custom.impl;

import javafx.scene.chart.XYChart;
import lk.ijse.global_flavour.bo.custom.HomeBO;
import lk.ijse.global_flavour.dao.DAOFactory;
import lk.ijse.global_flavour.dao.custom.CashierCustomerDAO;
import lk.ijse.global_flavour.dao.custom.EmployeeDAO;
import lk.ijse.global_flavour.dao.custom.OrderFormDAO;

import java.sql.SQLException;

public class HomeBOImpl implements HomeBO {
    CashierCustomerDAO customertot = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CASHIERCUSTOMER);
    EmployeeDAO employeeDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    OrderFormDAO orderFormDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER);

    public int getTotCustomersfgf() throws SQLException, ClassNotFoundException{
        return customertot.getTotCustomers();
    }
    public int getTotEmployeeHome() throws SQLException, ClassNotFoundException{
        return employeeDAO.getTotEmployee();
    }
    public XYChart.Series lineChartData() throws SQLException, ClassNotFoundException{
        return orderFormDAO.lineChartData();
    }
    public int getTotalSales() throws SQLException, ClassNotFoundException {
        return orderFormDAO.getTotalSales();
    }
}
