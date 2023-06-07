package lk.ijse.global_flavour.bo.custom;

import lk.ijse.global_flavour.dto.CashierCustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CashierCustomerBO {
    public boolean saveCustomer(CashierCustomerDTO customerDTO) throws SQLException ;

    public ArrayList<CashierCustomerDTO> getAllCustomer() throws SQLException ;

    public boolean updateCustomer(CashierCustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    public ArrayList<CashierCustomerDTO> searchCustomer(String salId) throws SQLException ;

    public boolean deleteCustomer(String id) throws SQLException ;

}
