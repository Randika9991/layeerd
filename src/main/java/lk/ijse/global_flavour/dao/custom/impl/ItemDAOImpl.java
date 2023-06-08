package lk.ijse.global_flavour.dao.custom.impl;

import lk.ijse.global_flavour.dao.custom.ItemDAO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.CashierCustomerDTO;
import lk.ijse.global_flavour.dto.ItemDTO;
import lk.ijse.global_flavour.dto.OrderCartDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(ItemDTO itemDTO) throws SQLException {
        return SQLUtil.execute("INSERT INTO item(itemCode, ItemName, unitPrice, category ,QtyONHand) " +
                "VALUES(?, ?, ?, ? ,?)", itemDTO.getItemCode(),itemDTO.getItemName(),itemDTO.getUnitPrice(),itemDTO.getCategory(),itemDTO.getQty());

    }

    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM item");
        ArrayList<ItemDTO> arrayList = new ArrayList<>();
        while (rst.next()) {
            arrayList.add(new ItemDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),rst.getString(5)));
        }
        return arrayList;
    }

    @Override
    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE item SET ItemName = ?, unitPrice = ?, category = ?, QtyONHand = ? WHERE itemCode = ?", itemDTO.getItemName(), itemDTO.getUnitPrice(), itemDTO.getCategory(), itemDTO.getQty(), itemDTO.getItemCode());

    }

    @Override
    public ArrayList<ItemDTO> search(String salId) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM item WHERE itemCode = ?", salId);

        ArrayList<ItemDTO> arrayList = new ArrayList<>();
        if (resultSet.next()) {
            arrayList.add(new ItemDTO(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4), resultSet.getString(5)));
        }

        return arrayList;

    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.execute("DELETE FROM item WHERE itemCode = ?", id);

    }


     public boolean updateQty(List<OrderCartDTO> orderDTOList) throws SQLException {
        for(OrderCartDTO dto : orderDTOList){
            if(!updateQty(dto)){
                return false;
            }

        }
        return true;
    }

    private static boolean updateQty(OrderCartDTO dto) throws SQLException {
        String sql = "UPDATE item SET qtyOnHand = (qtyOnHand - ?) WHERE itemCode = ?";
        return SQLUtil.execute(
                sql,
                dto.getQty(),
                dto.getCode()
        );
    }
}
