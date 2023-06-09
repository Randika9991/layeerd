package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.SuppliersBO;
import lk.ijse.global_flavour.dao.DAOFactory;
import lk.ijse.global_flavour.dao.custom.SuppliersDAO;
import lk.ijse.global_flavour.dao.custom.impl.SuppliersDAOImpl;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.dto.SuppliersDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SuppliersBOImpl implements SuppliersBO {

    SuppliersDAO suppliersDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);

    public boolean saveSuppliers(SuppliersDTO suppliersDTO) throws SQLException {
        return suppliersDAO.save(suppliersDTO);
    }

    public ArrayList<SuppliersDTO> getAllSuppliers() throws SQLException {
        return suppliersDAO.getAll();
    }

    public boolean updateSuppliers(SuppliersDTO suppliersDTO) throws SQLException, ClassNotFoundException {
        return suppliersDAO.update(suppliersDTO);
    }

    public ArrayList<SuppliersDTO> searchSuppliers(String salId) throws SQLException {
        return suppliersDAO.search(salId);
    }

    public boolean deleteSuppliers(String id) throws SQLException {
        return suppliersDAO.delete(id);
    }
}
