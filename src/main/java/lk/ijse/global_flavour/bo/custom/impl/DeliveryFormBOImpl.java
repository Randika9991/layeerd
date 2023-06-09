package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.DeliveryFormBO;
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


public class DeliveryFormBOImpl implements DeliveryFormBO {
    DeliveryDAO deliveryDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.DELIVERY);
    EmployeeDAO employeeDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    CashierVehicleDAO vehicleDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CASHIERVEHICLE);

    public ArrayList<EmployeeDTO> getAllEmployeeId() throws SQLException{
        return employeeDAO.getAll();
    }
    public ArrayList<CashierVehicleDTO> getAllVehicleId() throws SQLException{
        return vehicleDAO.getAll();
    }
    public boolean deleteDelivery(String id) throws SQLException {
        return deliveryDAO.delete(id);
    }

    public ArrayList<DeliverFormDTO> getAllDeliveryId() throws SQLException{
        return deliveryDAO.getAllDeliveryFromController();
    }

    public boolean changelDelivery(DeliverFormDTO deliverFormDTO) throws SQLException{
        return deliveryDAO.change(deliverFormDTO);
    }
}
