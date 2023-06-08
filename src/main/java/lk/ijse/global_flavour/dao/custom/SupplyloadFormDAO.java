package lk.ijse.global_flavour.dao.custom;

import lk.ijse.global_flavour.dao.CrudDAO;
import lk.ijse.global_flavour.dto.PlaceSupplyLoadDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface SupplyloadFormDAO extends CrudDAO<PlaceSupplyLoadDTO,String> {
    String getNextSupplyLoadId() throws SQLException;
    boolean saveloadDetail(String loadid, String suppid, String totalprice, LocalDate now, LocalTime now1, List<PlaceSupplyLoadDTO> placeSupplyLoadDTOList) throws SQLException;
}
