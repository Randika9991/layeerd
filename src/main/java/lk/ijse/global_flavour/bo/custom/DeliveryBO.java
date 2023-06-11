package lk.ijse.global_flavour.bo.custom;

import lk.ijse.global_flavour.bo.SuperBO;
import lk.ijse.global_flavour.dto.CashierVehicleDTO;
//import lk.ijse.global_flavour.dto.DeliverFormDTO;
import lk.ijse.global_flavour.dto.DeliveryDTO;
import lk.ijse.global_flavour.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DeliveryBO extends SuperBO {
    public String getNextDeliverId() throws SQLException;

    public ArrayList<EmployeeDTO> getAllEmployeeId() throws SQLException;

    public ArrayList<CashierVehicleDTO> getAllVehicleId() throws SQLException;

}
