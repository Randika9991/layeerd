package lk.ijse.global_flavour.bo.custom;

import lk.ijse.global_flavour.bo.SuperBO;
import lk.ijse.global_flavour.dto.ItemDTO;
import lk.ijse.global_flavour.dto.PlaceSupplyLoadDTO;
import lk.ijse.global_flavour.dto.SuppliersDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface SupplyloadFormBO extends SuperBO {
    public ArrayList<SuppliersDTO> getAllSuppliers() throws SQLException;

    public String getSupplierName(String supp_id) throws SQLException;

    public ArrayList<ItemDTO> getAllItem() throws SQLException;

    public ArrayList<ItemDTO> searchItem(String salId) throws SQLException;

    public String getNextSupplyLoadId() throws SQLException;

    public boolean placeLoad(String loadid, String suppid, String totalprice, List<PlaceSupplyLoadDTO> placeSupplyLoadDTOList) throws SQLException;
}
