package lk.ijse.global_flavour.bo.custom;

import lk.ijse.global_flavour.bo.SuperBO;
import lk.ijse.global_flavour.dto.*;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    public boolean saveItem(ItemDTO itemDTO) throws SQLException ;

    public ArrayList<ItemDTO> getAllItem() throws SQLException ;

    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;

    public ArrayList<ItemDTO> searchItem(String id) throws SQLException ;

    public boolean deleteItem(String id) throws SQLException ;
}
