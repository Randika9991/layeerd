package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.CashierCustomerBO;
import lk.ijse.global_flavour.dao.DAOFactory;
import lk.ijse.global_flavour.dao.custom.CashierCustomerDAO;
import lk.ijse.global_flavour.dao.custom.impl.CashierCustomerDAOImpl;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.dto.CashierCustomerDTO;
import lk.ijse.global_flavour.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CashierCustomerBOImpl implements CashierCustomerBO {
    CashierCustomerDAO customerDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CASHIERCUSTOMER);


    public boolean saveCustomer(CashierCustomerDTO customerDTO) throws SQLException {
        return customerDAO.save(new Customer(customerDTO.getCustomerId(),customerDTO.getCustomerName(),
                customerDTO.getContactNo(),customerDTO.getAddress(),customerDTO.getEmail()));
    }

    public ArrayList<CashierCustomerDTO> getAllCustomer() throws SQLException {
        ArrayList<Customer> arrayList = customerDAO.getAll();
        ArrayList<CashierCustomerDTO> dtoArrayList = new ArrayList<>();
        for (Customer c: arrayList) {
            dtoArrayList.add(new CashierCustomerDTO(c.getCustId(), c.getCustName(), c.getContactNo(), c.getAddress(), c.getEmail()));
        }
        return dtoArrayList;
    }

    public boolean updateCustomer(CashierCustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(customerDTO.getCustomerId(),customerDTO.getCustomerName(),
                customerDTO.getContactNo(),customerDTO.getAddress(),customerDTO.getEmail()));
    }

    public ArrayList<CashierCustomerDTO> searchCustomer(String salId) throws SQLException {
        ArrayList<Customer> arrayList = customerDAO.search(salId);

        ArrayList<CashierCustomerDTO> customerArrayList = new ArrayList<>();
        for (Customer c : arrayList) {
            customerArrayList.add(new CashierCustomerDTO(c.getCustId(), c.getCustName(), c.getContactNo(),
                    c.getAddress(), c.getEmail()));
        }
        return customerArrayList;
    }

    public boolean deleteCustomer(String id) throws SQLException {
        return customerDAO.delete(id);
    }

}
