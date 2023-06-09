package lk.ijse.global_flavour.bo.custom;

import lk.ijse.global_flavour.bo.SuperBO;
import lk.ijse.global_flavour.dto.SuppliersDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SuppliersBO extends SuperBO {
    boolean saveSuppliers(SuppliersDTO suppliersDTO) throws SQLException;

     ArrayList<SuppliersDTO> getAllSuppliers() throws SQLException;

     boolean updateSuppliers(SuppliersDTO suppliersDTO) throws SQLException, ClassNotFoundException;

     ArrayList<SuppliersDTO> searchSuppliers(String salId) throws SQLException;

     boolean deleteSuppliers(String id) throws SQLException;
}