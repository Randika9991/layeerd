package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.CashierCustomerBO;
import lk.ijse.global_flavour.bo.custom.CashierVehicleBO;
import lk.ijse.global_flavour.dao.DAOFactory;
import lk.ijse.global_flavour.dao.custom.CashierVehicleDAO;
import lk.ijse.global_flavour.dao.custom.impl.CashierVehicleDAOImpl;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.dto.CashierCustomerDTO;
import lk.ijse.global_flavour.dto.CashierVehicleDTO;
import lk.ijse.global_flavour.entity.Customer;
import lk.ijse.global_flavour.entity.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CashierVehicleBOImpl implements CashierVehicleBO {

    CashierVehicleDAO vehicleDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CASHIERVEHICLE);

    public boolean saveVehicle(CashierVehicleDTO cashVehiDTO) throws SQLException {
        return vehicleDAO.save(new Vehicle(cashVehiDTO.getVehicleId(),cashVehiDTO.getVehicleNo(),cashVehiDTO.getVehicleType()));
    }


    public ArrayList<CashierVehicleDTO> getAllVehicle() throws SQLException {
        ArrayList<Vehicle> arrayList = vehicleDAO.getAll();
        ArrayList<CashierVehicleDTO> dtoArrayList = new ArrayList<>();
        for (Vehicle c: arrayList) {
            dtoArrayList.add(new CashierVehicleDTO(c.getVehiId(), c.getVehiNo(), c.getVehiType()));
        }
        return dtoArrayList;
    }


    public boolean updateVehicle(CashierVehicleDTO cashVehiDTO) throws SQLException, ClassNotFoundException {
        return vehicleDAO.update(new Vehicle(cashVehiDTO.getVehicleId(),cashVehiDTO.getVehicleNo(),cashVehiDTO.getVehicleType()));
    }


    public ArrayList<CashierVehicleDTO> searchVehicle(String salId) throws SQLException {
        ArrayList<Vehicle> arrayList =vehicleDAO.search(salId);
        ArrayList<CashierVehicleDTO> dtoArrayList = new ArrayList<>();
        for (Vehicle c: arrayList) {
            dtoArrayList.add(new CashierVehicleDTO(c.getVehiId(), c.getVehiNo(), c.getVehiType()));
        }
        return dtoArrayList;

    }


    public boolean deleteVehicle(String id) throws SQLException {
        return vehicleDAO.delete(id);
    }
}
