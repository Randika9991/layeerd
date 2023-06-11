package lk.ijse.global_flavour.dao.custom;

import lk.ijse.global_flavour.dao.CrudDAO;
import lk.ijse.global_flavour.dto.PlaceSupplyLoadDTO;
import lk.ijse.global_flavour.entity.SupplyLoadDetail;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface SupplyloadFormDAO extends CrudDAO<SupplyLoadDetail,String> {
    String getNextSupplyLoadId() throws SQLException;
}
