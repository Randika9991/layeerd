package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.DeliveryBO;
import lk.ijse.global_flavour.dao.DAOFactory;
import lk.ijse.global_flavour.dao.custom.CashierVehicleDAO;
import lk.ijse.global_flavour.dao.custom.DeliveryDAO;
import lk.ijse.global_flavour.dao.custom.EmployeeDAO;
import lk.ijse.global_flavour.dao.custom.impl.CashierVehicleDAOImpl;
import lk.ijse.global_flavour.dao.custom.impl.DeliveryDAOImpl;
import lk.ijse.global_flavour.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.global_flavour.dto.CashierVehicleDTO;
import lk.ijse.global_flavour.dto.DeliverFormDTO;
import lk.ijse.global_flavour.dto.DeliveryDTO;
import lk.ijse.global_flavour.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class DeliveryBOImpl implements DeliveryBO{
    DeliveryDAO deliveryDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.DELIVERY);
    EmployeeDAO employeeDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    CashierVehicleDAO vehicleDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CASHIERVEHICLE);

    public String getNextDeliverId() throws SQLException{
        return deliveryDAO.getNextDeliverId();
    }
    public ArrayList<EmployeeDTO> getAllEmployeeId() throws SQLException{
        return employeeDAO.getAll();
    }
    public ArrayList<CashierVehicleDTO> getAllVehicleId() throws SQLException{
        return vehicleDAO.getAll();
    }

}
