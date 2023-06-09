package lk.ijse.global_flavour.bo.custom;

import lk.ijse.global_flavour.bo.SuperBO;
import lk.ijse.global_flavour.dto.CashierVehicleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CashierVehicleBO extends SuperBO {
    public boolean saveVehicle(CashierVehicleDTO cashVehiDTO) throws SQLException ;

    public ArrayList<CashierVehicleDTO> getAllVehicle() throws SQLException ;


    public boolean updateVehicle(CashierVehicleDTO cashVehiDTO) throws SQLException, ClassNotFoundException ;


    public ArrayList<CashierVehicleDTO> searchVehicle(String salId) throws SQLException ;


    public boolean deleteVehicle(String id) throws SQLException ;
}
