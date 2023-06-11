package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.OrderFormBO;
import lk.ijse.global_flavour.dao.DAOFactory;
import lk.ijse.global_flavour.dao.custom.*;
import lk.ijse.global_flavour.dao.custom.impl.*;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.CashierCustomerDTO;
import lk.ijse.global_flavour.dto.DeliveryDTO;
import lk.ijse.global_flavour.dto.ItemDTO;
import lk.ijse.global_flavour.dto.OrderCartDTO;
//import lk.ijse.global_flavour.model.*;
import lk.ijse.global_flavour.entity.*;
import lk.ijse.global_flavour.view.tdm.OrderTM;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OrderFormBOImpl implements OrderFormBO {

    OrderFormDAO orderFormDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    CashierCustomerDAO customerDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CASHIERCUSTOMER);
    ItemDAO itemDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    DeliveryDAO deliveryDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.DELIVERY);
    OrderDetailDAO OrderdetailDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAIL);

    public String getNextOrderId() throws SQLException{
        return orderFormDAO.getNextOrderId();
    }
    public ArrayList<CashierCustomerDTO> getAllCustomer() throws SQLException{
        ArrayList<Customer> arrayList = customerDAO.getAll();
        ArrayList<CashierCustomerDTO> dtoArrayList = new ArrayList<>();
        for (Customer c: arrayList) {
            dtoArrayList.add(new CashierCustomerDTO(c.getCustId(), c.getCustName(), c.getContactNo(),
                    c.getAddress(), c.getEmail()));
        }
        return dtoArrayList;
    }

    public ArrayList<CashierCustomerDTO> searchCustomer(String salId) throws SQLException{
        ArrayList<Customer> arrayList = customerDAO.search(salId);

        ArrayList<CashierCustomerDTO> customerArrayList = new ArrayList<>();
        for (Customer c : arrayList) {
            customerArrayList.add(new CashierCustomerDTO(c.getCustId(), c.getCustName(), c.getContactNo(),
                    c.getAddress(), c.getEmail()));
        }
        return customerArrayList;
    }
    public ArrayList<ItemDTO> getAllItem() throws SQLException{
        ArrayList<Item> arrayList = itemDAO.getAll();
        ArrayList<ItemDTO> dtoArrayList = new ArrayList<>();

        for (Item item : arrayList) {
            dtoArrayList.add(new ItemDTO(item.getItemCode(),item.getItemName(),
                    item.getUnitPrice(),item.getCategory(),item.getQtyOnHand()));
        }
        return dtoArrayList;
    }

    public ArrayList<ItemDTO> searchItem(String id) throws SQLException {
        ArrayList<Item> arrayList = itemDAO.search(id);
        ArrayList<ItemDTO> dtoArrayList = new ArrayList<>();

        for (Item item : arrayList) {
            dtoArrayList.add(new ItemDTO(item.getItemCode(),item.getItemName(),
                    item.getUnitPrice(),item.getCategory(),item.getQtyOnHand()));
        }
        return dtoArrayList;
    }


    private static DeliveryDTO delivery;

    public boolean placeOrder(String oId, String cId, double payment, List<OrderCartDTO> orderDTOList, OrderTM orderTM, boolean delivery) throws SQLException{

        Connection con = null;
        try {

            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);

            boolean isSaved = orderFormDAO.save(new Orders(oId, cId, payment, LocalTime.now(), LocalDate.now(),delivery));
            if (isSaved) {
                boolean isUpdate = itemDAO.updateQty(orderDTOList);
                if (isUpdate) {

                    for (OrderCartDTO o : orderDTOList) {
                        boolean isOrdered = OrderdetailDAO.save(new OrderDetail(oId,o.getCode(),o.getQty(),o.getUnitPrice()));
                        if (isOrdered) {
                            if(delivery){
                                boolean isDelivered = deliveryDAO.save(new Delivery(OrderFormBOImpl.delivery.getDeliverId(),OrderFormBOImpl.delivery.getEmpId(),OrderFormBOImpl.delivery.getOrderId(),OrderFormBOImpl.delivery.getVehicalId(),OrderFormBOImpl.delivery.getLocation(),OrderFormBOImpl.delivery.getDeliverDate(),OrderFormBOImpl.delivery.getDueDate(),OrderFormBOImpl.delivery.getDeliverStatus()));
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
