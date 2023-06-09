package lk.ijse.global_flavour.bo.custom.impl;

import lk.ijse.global_flavour.bo.custom.ItemBO;
import lk.ijse.global_flavour.dao.DAOFactory;
import lk.ijse.global_flavour.dao.custom.ItemDAO;
import lk.ijse.global_flavour.dao.custom.impl.ItemDAOImpl;
import lk.ijse.global_flavour.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    public boolean saveItem(ItemDTO itemDTO) throws SQLException {
        return itemDAO.save(itemDTO);
    }

    public ArrayList<ItemDTO> getAllItem() throws SQLException {
        return itemDAO.getAll();
    }

    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.update(itemDTO);
    }

    public ArrayList<ItemDTO> searchItem(String id) throws SQLException {
        return itemDAO.search(id);
    }

    public boolean deleteItem(String id) throws SQLException {
        return itemDAO.delete(id);
    }
}
