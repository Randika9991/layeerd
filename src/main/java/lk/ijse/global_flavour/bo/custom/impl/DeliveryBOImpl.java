package lk.ijse.global_flavour.bo.custom.impl;

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

public class DeliveryBOImpl {
    DeliveryDAO deliveryDAO = new DeliveryDAOImpl();
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    CashierVehicleDAO vehicleDAO = new CashierVehicleDAOImpl();

    public boolean saveDeliver(DeliveryDTO deliveryDTO) throws SQLException {
        return deliveryDAO.save(deliveryDTO);
    }
    public String getNextDeliverId() throws SQLException{
        return deliveryDAO.getNextDeliverId();
    }
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
