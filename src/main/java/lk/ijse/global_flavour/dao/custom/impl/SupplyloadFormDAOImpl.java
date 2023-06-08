package lk.ijse.global_flavour.dao.custom.impl;

import lk.ijse.global_flavour.dao.custom.SupplyloadFormDAO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.dto.PlaceSupplyLoadDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SupplyloadFormDAOImpl implements SupplyloadFormDAO {
    @Override
    public boolean save(PlaceSupplyLoadDTO SalaryAdd) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<PlaceSupplyLoadDTO> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean update(PlaceSupplyLoadDTO adminSalary) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<PlaceSupplyLoadDTO> search(String salId) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    public String getNextSupplyLoadId() throws SQLException {
        ResultSet resultSet = SQLUtil.execute( "SELECT loadId FROM SupplyLoadDetail ORDER BY loadId DESC LIMIT 1");

        if (resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);

    }

    private static String splitOrderId(String currentId) {
        if(currentId != null) {
            String[] strings = currentId.split("LOAD-");
            int id = Integer.parseInt(strings[1]);
            ++id;
            String digit=String.format("%03d", id);
            return "LOAD-" + digit;
        }
        return "LOAD-001";
    }

    public  boolean saveloadDetail(String loadid, String suppid, String totalprice, LocalDate now, LocalTime now1, List<PlaceSupplyLoadDTO> placeSupplyLoadDTOList) throws SQLException {
        for(PlaceSupplyLoadDTO placeSupplyLoadDTO : placeSupplyLoadDTOList) {
            if(!savesupplyloaddetails(loadid,suppid,totalprice,now,now1, placeSupplyLoadDTO)) {
                return false;
            }
        }
        return true;
    }
    private static boolean savesupplyloaddetails(String loadid, String suppid, String totalprice, LocalDate now, LocalTime now1, PlaceSupplyLoadDTO placeSupplyLoadDTO) throws SQLException {
        String sql = "INSERT INTO SupplyLoadDetail(loadId,supId,itemCode,qty,date,time,price)" +
                "VALUES(?,?,?,?,?,?,?)";

        return SQLUtil.execute(
                sql,
                loadid,
                suppid,
                placeSupplyLoadDTO.getItemcode(),
                placeSupplyLoadDTO.getSuppqty(),
                now,
                now1,
                totalprice
        );
    }

}
