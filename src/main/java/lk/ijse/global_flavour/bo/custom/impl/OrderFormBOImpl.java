package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.dao.custom.*;
import lk.ijse.global_flavour.dao.custom.impl.*;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.CashierCustomerDTO;
import lk.ijse.global_flavour.dto.DeliveryDTO;
import lk.ijse.global_flavour.dto.ItemDTO;
import lk.ijse.global_flavour.dto.OrderCartDTO;
import lk.ijse.global_flavour.model.*;
import lk.ijse.global_flavour.view.tdm.OrderTM;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OrderFormBOImpl {

    OrderFormDAO orderFormDAO = new OrderFormDAOImpl();
    CashierCustomerDAO customerDAO = new CashierCustomerDAOImpl();
    ItemDAO itemDAO = new ItemDAOImpl();
    DeliveryDAO deliveryDAO = new DeliveryDAOImpl();
    OrderDetailDAO detailDAO = new OrderDetailDAOImpl();

    public String getNextOrderId() throws SQLException{
        return orderFormDAO.getNextOrderId();
    }
    public ArrayList<CashierCustomerDTO> getAllCustomer() throws SQLException{
        return customerDAO.getAll();
    }

    public ArrayList<CashierCustomerDTO> searchCustomer(String salId) throws SQLException{
        return customerDAO.search(salId);
    }
    public ArrayList<ItemDTO> getAllItem() throws SQLException{
        return itemDAO.getAll();
    }

    public ArrayList<ItemDTO> searchItem(String id) throws SQLException {
        return itemDAO.search(id);
    }


    private  static DeliveryDTO delivery;

    public boolean placeOrder(String oId, String cId, double payment, List<OrderCartDTO> orderDTOList, OrderTM orderTM, boolean delivery) throws SQLException{

        Connection con = null;
        try {

            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);

            boolean isSaved = orderFormDAO.saveOrder(oId, cId, payment, LocalDate.now(), LocalTime.now(), orderDTOList,delivery);
            if (isSaved) {
                boolean isUpdate = itemDAO.updateQty(orderDTOList);
                if (isUpdate) {
                    boolean isOrdered = detailDAO.save(oId, orderDTOList);
                    if (isOrdered) {
                        if(delivery){
                            boolean isDelivered = deliveryDAO.save(OrderFormBOImpl.delivery);
                            if(isDelivered){
                                con.commit();
                                return true;
                            }
                        }else {
                            con.commit();
                            return true;
                        }
                    }
                }
            }

            return false;
        } catch (SQLException er) {
            System.out.println(er);
            con.rollback();
            return false;
        } finally {
            con.setAutoCommit(true);
        }
    }

    public static void saveDelivery(DeliveryDTO cus) {
        delivery = cus;

    }

}
