package lk.ijse.global_flavour.dao.custom.impl;

import lk.ijse.global_flavour.dao.custom.OrderDetailDAO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.dto.OrderCartDTO;
import lk.ijse.global_flavour.entity.OrderDetail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean save(OrderDetail orderDetail) throws SQLException {
        String sql = "INSERT INTO orderdetail(orderId, itemCode, qty, unitPrice)" +
                "VALUES(?, ?, ?, ?)";

        return SQLUtil.execute(
                sql,
                orderDetail.getOrderId(),
                orderDetail.getItemCode(),
                orderDetail.getQty(),
                orderDetail.getUnitPrice()
        );
    }

    @Override
    public ArrayList<OrderDetail> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean update(OrderDetail adminSalary) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<OrderDetail> search(String salId) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }


    /*public  boolean save(String oId, List<OrderCartDTO> orderDTOList) throws SQLException {
        for (OrderCartDTO dto : orderDTOList){
            if(!save(oId,dto)){
                return false;
            }
        }
        return true;
    }

    private static boolean save(String oId, OrderCartDTO dto) throws SQLException {
        String sql = "INSERT INTO orderdetail(orderId, itemCode, qty, unitPrice)" +
                "VALUES(?, ?, ?, ?)";

        return SQLUtil.execute(
                sql,
                oId,
                dto.getCode(),
                dto.getQty(),
                dto.getUnitPrice()
        );
    }*/
}
