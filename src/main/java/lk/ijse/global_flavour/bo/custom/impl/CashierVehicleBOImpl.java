package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.CashierCustomerBO;
import lk.ijse.global_flavour.bo.custom.CashierVehicleBO;
import lk.ijse.global_flavour.dao.DAOFactory;
import lk.ijse.global_flavour.dao.custom.CashierVehicleDAO;
import lk.ijse.global_flavour.dao.custom.impl.CashierVehicleDAOImpl;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.dto.CashierVehicleDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CashierVehicleBOImpl implements CashierVehicleBO {

    CashierVehicleDAO vehicleDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CASHIERVEHICLE);

    public boolean saveVehicle(CashierVehicleDTO cashVehiDTO) throws SQLException {
        return vehicleDAO.save(cashVehiDTO);
    }


    public ArrayList<CashierVehicleDTO> getAllVehicle() throws SQLException {
        return vehicleDAO.getAll();
    }


    public boolean updateVehicle(CashierVehicleDTO cashVehiDTO) throws SQLException, ClassNotFoundException {
        return vehicleDAO.update(cashVehiDTO);
    }


    public ArrayList<CashierVehicleDTO> searchVehicle(String salId) throws SQLException {
        return vehicleDAO.search(salId);
    }


    public boolean deleteVehicle(String id) throws SQLException {
        return vehicleDAO.delete(id);
    }
}
