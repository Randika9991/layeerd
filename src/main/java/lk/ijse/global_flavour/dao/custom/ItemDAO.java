package lk.ijse.global_flavour.dao.custom;

import lk.ijse.global_flavour.dao.CrudDAO;
import lk.ijse.global_flavour.dto.ItemDTO;
import lk.ijse.global_flavour.dto.OrderCartDTO;
import lk.ijse.global_flavour.dto.PlaceSupplyLoadDTO;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO extends CrudDAO<ItemDTO,String> {
     boolean updateQty(List<OrderCartDTO> orderDTOList) throws SQLException;

     boolean addQty(List<PlaceSupplyLoadDTO> placeSupplyLoadDTOList) throws SQLException;

}
