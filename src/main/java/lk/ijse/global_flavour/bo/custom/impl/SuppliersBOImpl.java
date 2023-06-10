package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.SuppliersBO;
import lk.ijse.global_flavour.dao.DAOFactory;
import lk.ijse.global_flavour.dao.custom.SuppliersDAO;
import lk.ijse.global_flavour.dao.custom.impl.SuppliersDAOImpl;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.dto.AdminSalaryDTO;
import lk.ijse.global_flavour.dto.SuppliersDTO;
import lk.ijse.global_flavour.entity.Salary;
import lk.ijse.global_flavour.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SuppliersBOImpl implements SuppliersBO {

    SuppliersDAO suppliersDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);

    public boolean saveSuppliers(SuppliersDTO suppliersDTO) throws SQLException {

        return suppliersDAO.save(new Supplier(suppliersDTO.getSupplierId(),suppliersDTO.getSupplierName(),suppliersDTO.getSupplierAddress(),suppliersDTO.getSupplierEmail(),suppliersDTO.getSupplierCotact()));
    }

    public ArrayList<SuppliersDTO> getAllSuppliers() throws SQLException {
        ArrayList<Supplier> arrayList = suppliersDAO.getAll();
        ArrayList<SuppliersDTO> dtoArrayList = new ArrayList<>();
        for (Supplier suppliers: arrayList) {
            dtoArrayList.add(new SuppliersDTO(suppliers.getSupId(),suppliers.getSupName(),suppliers.getAddress(),suppliers.getEmail(),suppliers.getContactNo()));
        }
        return dtoArrayList;

    }

    public boolean updateSuppliers(SuppliersDTO suppliersDTO) throws SQLException, ClassNotFoundException {
        return suppliersDAO.update(new Supplier(suppliersDTO.getSupplierId(),suppliersDTO.getSupplierName(),suppliersDTO.getSupplierAddress(),suppliersDTO.getSupplierEmail(),suppliersDTO.getSupplierCotact()));
    }

    public ArrayList<SuppliersDTO> searchSuppliers(String salId) throws SQLException {
        ArrayList<Supplier> arrayList = suppliersDAO.search(salId);
        ArrayList<SuppliersDTO> dtoArrayList = new ArrayList<>();
        for (Supplier suppliers: arrayList) {
            dtoArrayList.add(new SuppliersDTO(suppliers.getSupId(),suppliers.getSupName(),suppliers.getAddress(),suppliers.getEmail(),suppliers.getContactNo()));
        }
        return dtoArrayList;
    }

    public boolean deleteSuppliers(String id) throws SQLException {
        return suppliersDAO.delete(id);
    }
}
