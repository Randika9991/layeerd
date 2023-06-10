package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.ItemBO;
import lk.ijse.global_flavour.dao.DAOFactory;
import lk.ijse.global_flavour.dao.custom.ItemDAO;
import lk.ijse.global_flavour.dao.custom.impl.ItemDAOImpl;
import lk.ijse.global_flavour.dto.EmployeeDTO;
import lk.ijse.global_flavour.dto.ItemDTO;
import lk.ijse.global_flavour.entity.Employee;
import lk.ijse.global_flavour.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    public boolean saveItem(ItemDTO itemDTO) throws SQLException {
        return itemDAO.save(new Item(itemDTO.getItemCode(),itemDTO.getItemName(),itemDTO.getUnitPrice(),itemDTO.getCategory(),itemDTO.getQty()));
    }

    public ArrayList<ItemDTO> getAllItem() throws SQLException {
        ArrayList<Item> arrayList = itemDAO.getAll();
        ArrayList<ItemDTO> dtoArrayList = new ArrayList<>();

        for (Item item : arrayList) {
            dtoArrayList.add(new ItemDTO(item.getItemCode(),item.getItemName(),
                    item.getUnitPrice(),item.getCategory(),item.getQtyOnHand()));
        }
        return dtoArrayList;

    }

    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new Item(itemDTO.getItemCode(),itemDTO.getItemName(),itemDTO.getUnitPrice(),itemDTO.getCategory(),itemDTO.getQty()));
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

    public boolean deleteItem(String id) throws SQLException {
        return itemDAO.delete(id);
    }
}
