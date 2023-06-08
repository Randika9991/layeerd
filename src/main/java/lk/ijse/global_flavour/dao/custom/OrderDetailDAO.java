package lk.ijse.global_flavour.dao.custom;

import lk.ijse.global_flavour.dao.CrudDAO;
import lk.ijse.global_flavour.dto.OrderCartDTO;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO extends CrudDAO<OrderCartDTO,String> {
     boolean save(String oId, List<OrderCartDTO> orderDTOList) throws SQLException;
}
