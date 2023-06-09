package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.CashierCustomerBO;
import lk.ijse.global_flavour.dao.DAOFactory;
import lk.ijse.global_flavour.dao.custom.CashierCustomerDAO;
import lk.ijse.global_flavour.dao.custom.impl.CashierCustomerDAOImpl;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.dto.CashierCustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CashierCustomerBOImpl implements CashierCustomerBO {
    CashierCustomerDAO customerDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CASHIERCUSTOMER);


    public boolean saveCustomer(CashierCustomerDTO customerDTO) throws SQLException {
        return customerDAO.save(customerDTO);
    }

    public ArrayList<CashierCustomerDTO> getAllCustomer() throws SQLException {
        return customerDAO.getAll();
    }

    public boolean updateCustomer(CashierCustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.update(customerDTO);
    }

    public ArrayList<CashierCustomerDTO> searchCustomer(String salId) throws SQLException {
        return customerDAO.search(salId);
    }

    public boolean deleteCustomer(String id) throws SQLException {
        return customerDAO.delete(id);
    }

}
