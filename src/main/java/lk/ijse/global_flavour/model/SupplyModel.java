/*
package lk.ijse.global_flavour.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.ItemDTO;
import lk.ijse.global_flavour.dto.PlaceSupplyLoadDTO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class SupplyModel {
    */
/*public static ObservableList<String> getAll() throws SQLException {
        String sql = "SELECT supId from supplier";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {
            ResultSet resultSet = pstm.executeQuery();
            ObservableList<String> dataList = FXCollections.observableArrayList();

            while (resultSet.next()) {
                dataList.add(new String(
                        resultSet.getString(1)
                ));

            }
            return dataList;
        }
    }*//*


    */
/*public static ObservableList<String> getAllItemCode() throws SQLException {
        String sql = "SELECT itemCode from item";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {
            ResultSet resultSet = pstm.executeQuery();
            ObservableList<String> dataList = FXCollections.observableArrayList();

            while (resultSet.next()) {
                dataList.add(new String(
                        resultSet.getString(1)
                ));

            }
            return dataList;
        }
    }*//*


    */
/*public static String getSupplierName(String supp_id) throws SQLException {
        String sql = "SELECT supName FROM supplier WHERE supId=?";
        ResultSet resultSet = SQLUtil.execute(sql,supp_id);

        if(resultSet.next()){
            return (new String(
                    resultSet.getString(1)
            ));
        }
        return null;
    }*//*


   */
/* public static String getNextSupplyLoadId() throws SQLException {
        String sql = "SELECT loadId FROM SupplyLoadDetail ORDER BY loadId DESC LIMIT 1";

        ResultSet resultSet = SQLUtil.execute(sql);

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
    }*//*


    */
/*public static boolean placeLoad(String loadid, String suppid, String totalprice, List<PlaceSupplyLoadDTO> placeSupplyLoadDTOList) throws SQLException {

        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);

            boolean isSaved = save(loadid,suppid,totalprice, LocalDate.now(), LocalTime.now(), placeSupplyLoadDTOList);
            if(isSaved) {
                boolean isUpdated = ItemModel.addQty(placeSupplyLoadDTOList);
                if(isUpdated) {
                    con.commit();                                                                                                                                                 //database ekata save eka
                    return true;
                }
            }
            return false;
        } catch (SQLException er) {
            System.out.println(er);
            con.rollback();
            return false;
        } finally {
            System.out.println("finally");
            con.setAutoCommit(true);
        }
    }*//*


    */
/*private static boolean save(String loadid, String suppid, String totalprice, LocalDate now, LocalTime now1, List<PlaceSupplyLoadDTO> placeSupplyLoadDTOList) throws SQLException {
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
    }*//*

    */
/*public static ItemDTO findById(String itemcode) throws SQLException {
        String sql = "SELECT * FROM item WHERE itemCode=?";

        ResultSet resultSet = SQLUtil.execute(sql,itemcode);
        if(resultSet.next()){
            return (new ItemDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));
        }
        return null;
    }*//*

}
*/
