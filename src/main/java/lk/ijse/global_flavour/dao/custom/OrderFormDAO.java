package lk.ijse.global_flavour.dao.custom;

import lk.ijse.global_flavour.dao.CrudDAO;
import lk.ijse.global_flavour.dto.OrderCartDTO;
import lk.ijse.global_flavour.dto.OrderDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface OrderFormDAO extends CrudDAO <OrderDTO,String>{

    String getNextOrderId() throws SQLException;

     boolean saveOrder(String oId, String cId, double payment, LocalDate date, LocalTime time, List<OrderCartDTO> orderDTOList, boolean delivery) throws SQLException;
}
