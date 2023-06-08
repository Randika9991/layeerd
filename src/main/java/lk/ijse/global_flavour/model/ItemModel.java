/*
package lk.ijse.global_flavour.model;

import lk.ijse.global_flavour.dto.PlaceSupplyLoadDTO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;

import java.sql.SQLException;
import java.util.List;

public class ItemModel {
    */
/*public static boolean save(ItemDTO itmAdd) throws SQLException {  //data baes ekata dana set eka
        String sql = "INSERT INTO item(itemCode, ItemName, unitPrice, category ,QtyONHand) " +
                "VALUES(?, ?, ?, ? ,?)";
        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            pstm.setString(1, itmAdd.getItemCode());
            pstm.setString(2, itmAdd.getItemName());
            pstm.setString(3, itmAdd.getUnitPrice());
            pstm.setString(4, itmAdd.getCategory());
            pstm.setString(5, itmAdd.getQty());

            return pstm.executeUpdate() > 0;
        }
    }*//*

    */
/*public static boolean update(ItemDTO supAdd) throws SQLException {

        String sql = "UPDATE item SET ItemName = ?, unitPrice = ?, category = ?, QtyONHand = ? WHERE itemCode = ?";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            pstm.setString(1, supAdd.getItemName());
            pstm.setString(2, supAdd.getUnitPrice());
            pstm.setString(3, supAdd.getCategory());
            pstm.setString(4, supAdd.getQty());
            pstm.setString(5, supAdd.getItemCode());

            return pstm.executeUpdate() > 0;
        }
    }*//*


    */
/*public static boolean delete(String id) throws SQLException {

        String sql = "DELETE FROM item WHERE itemCode = ?";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            pstm.setString(1, id);
            return pstm.executeUpdate() > 0;
        }
    }*//*


    */
/*public static ItemDTO search(String id) throws SQLException {
        String sql = "SELECT * FROM item WHERE itemCode = ?";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            pstm.setString(1, id);

            ResultSet resultSet = pstm.executeQuery();
            if(resultSet.next()) {
                return new ItemDTO(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)

                );
            }
            return null;
        }
    }*//*


    */
/*public static ObservableList<ItemTM> getAll() throws SQLException {
        String sql = "SELECT * FROM item";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            ResultSet resultSet = pstm.executeQuery();

            ObservableList<ItemTM> dataList = FXCollections.observableArrayList();

            while (resultSet.next()) {
                dataList.add(new ItemTM(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                ));
            }
            return dataList;
        }
    }*//*


    */
/*public static List<String> loadCodes() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        ResultSet resultSet = con.createStatement().executeQuery("SELECT itemCode FROM item");

        List<String> data =new ArrayList<>();

        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;
    }*//*


//    public static boolean updateQty(List<OrderCartDTO> orderDTOList) throws SQLException {
//        for(OrderCartDTO dto : orderDTOList){
//            if(!updateQty(dto)){
//                return false;
//            }
//
//        }
//        return true;
//    }
//
//    private static boolean updateQty(OrderCartDTO dto) throws SQLException {
//        String sql = "UPDATE item SET qtyOnHand = (qtyOnHand - ?) WHERE itemCode = ?";
//        return SQLUtil.execute(
//                sql,
//                dto.getQty(),
//                dto.getCode()
//        );
//    }

    */
/*public static boolean addQty(List<PlaceSupplyLoadDTO> placeSupplyLoadDTOList) throws SQLException {
        for(PlaceSupplyLoadDTO placeSupplyLoadDTO : placeSupplyLoadDTOList) {
            if(!addQty(placeSupplyLoadDTO)) {
                return false;
            }
        }
        return true;
    }
    private static boolean addQty(PlaceSupplyLoadDTO placeSupplyLoadDTO) throws SQLException {
        String sql = "UPDATE item SET qtyOnHand = (qtyOnHand + ?) WHERE itemCode = ?";

        return SQLUtil.execute(
                sql,
                placeSupplyLoadDTO.getSuppqty(),
                placeSupplyLoadDTO.getItemcode()
        );
    }*//*

}
*/
