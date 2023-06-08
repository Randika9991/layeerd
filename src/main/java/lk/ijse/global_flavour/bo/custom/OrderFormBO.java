package lk.ijse.global_flavour.bo.custom;

import lk.ijse.global_flavour.dto.CashierCustomerDTO;
import lk.ijse.global_flavour.dto.DeliveryDTO;
import lk.ijse.global_flavour.dto.ItemDTO;
import lk.ijse.global_flavour.dto.OrderCartDTO;
import lk.ijse.global_flavour.view.tdm.OrderTM;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface OrderFormBO {
    public String getNextOrderId() throws SQLException ;

    public ArrayList<CashierCustomerDTO> getAllCustomer() throws SQLException;

    public ArrayList<CashierCustomerDTO> searchCustomer(String salId) throws SQLException;

    public ArrayList<ItemDTO> getAllItem() throws SQLException;

    public ArrayList<ItemDTO> searchItem(String id) throws SQLException ;

    public boolean placeOrder(String oId, String cId, double payment, List<OrderCartDTO> orderDTOList, OrderTM orderTM, boolean delivery) throws SQLException;

    }
