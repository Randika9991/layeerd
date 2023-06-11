package lk.ijse.global_flavour.bo.custom;

import lk.ijse.global_flavour.bo.SuperBO;
import lk.ijse.global_flavour.dto.CashierVehicleDTO;
//import lk.ijse.global_flavour.dto.DeliverFormDTO;
import lk.ijse.global_flavour.dto.DeliveryDTO;
import lk.ijse.global_flavour.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DeliveryFormBO extends SuperBO {
    public ArrayList<EmployeeDTO> getAllEmployeeId() throws SQLException ;

    public ArrayList<CashierVehicleDTO> getAllVehicleId() throws SQLException;

    public boolean deleteDelivery(String id) throws SQLException ;

    public ArrayList<DeliveryDTO> getAllDeliveryId() throws SQLException;

    public boolean changelDelivery(DeliveryDTO deliverFormDTO) throws SQLException, ClassNotFoundException;
}
