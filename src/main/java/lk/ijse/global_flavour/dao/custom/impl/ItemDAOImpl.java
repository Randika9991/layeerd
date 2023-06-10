package lk.ijse.global_flavour.dao.custom.impl;

import lk.ijse.global_flavour.dao.custom.ItemDAO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.CashierCustomerDTO;
import lk.ijse.global_flavour.dto.ItemDTO;
import lk.ijse.global_flavour.dto.OrderCartDTO;
import lk.ijse.global_flavour.dto.PlaceSupplyLoadDTO;
import lk.ijse.global_flavour.entity.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(Item item) throws SQLException {
        return SQLUtil.execute("INSERT INTO item(itemCode, ItemName, unitPrice, category ,QtyONHand) " +
                "VALUES(?, ?, ?, ? ,?)", item.getItemCode(),item.getItemName(),item.getUnitPrice(),item.getCategory(),item.getQtyOnHand());

    }

    @Override
    public ArrayList<Item> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM item");
        ArrayList<Item> arrayList = new ArrayList<>();
        while (rst.next()) {
            arrayList.add(new Item(rst.getString(1), rst.getString(2), rst.getDouble(3), rst.getString(4),rst.getInt(5)));
        }
        return arrayList;
    }

    @Override
    public boolean update(Item item) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE item SET ItemName = ?, unitPrice = ?, category = ?, QtyONHand = ? WHERE itemCode = ?", item.getItemName(), item.getUnitPrice(), item.getCategory(), item.getQtyOnHand(), item.getItemCode());

    }

    @Override
    public ArrayList<Item> search(String salId) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM item WHERE itemCode = ?", salId);

        ArrayList<Item> arrayList = new ArrayList<>();
        if (rst.next()) {
            arrayList.add(new Item(rst.getString(1), rst.getString(2), rst.getDouble(3), rst.getString(4),rst.getInt(5)));
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

    public boolean addQty(List<PlaceSupplyLoadDTO> placeSupplyLoadDTOList) throws SQLException {
        for(PlaceSupplyLoadDTO placeSupplyLoadDTO : placeSupplyLoadDTOList) {
            if(!addQty(placeSupplyLoadDTO)) {
                return false;
            }
        }
        return true;
    }
    private static boolean addQty(PlaceSupplyLoadDTO placeSupplyLoadDTO) throws SQLException {
        String sql = "UPDATE item SET qtyOnHand = (qtyOnHand + ?) WHERE itemCode = ?";

        return SQLUtil.execute(
                sql,
                placeSupplyLoadDTO.getSuppqty(),
                placeSupplyLoadDTO.getItemcode()
        );
    }


}
