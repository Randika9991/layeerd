package lk.ijse.global_flavour.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.DeliverFormDTO;
import lk.ijse.global_flavour.dto.DeliveryDTO;
import lk.ijse.global_flavour.view.tdm.DeliverFormTM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DeliveryModel {
    public static boolean save(DeliveryDTO deliveryDTO) throws SQLException {  //data baes ekata dana set eka
        String sql = "INSERT INTO delivery(deliveryId,empId,orderId,vehiId,location,deliveryDate,dueDate) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            pstm.setString(1, deliveryDTO.getDeliverId());
            pstm.setString(2, deliveryDTO.getEmpId());
            pstm.setString(3, deliveryDTO.getOrderId());
            pstm.setString(4, deliveryDTO.getVehicalId());
            pstm.setString(5, deliveryDTO.getLocation());
            pstm.setString(6, String.valueOf(LocalDate.now()));
            pstm.setString(7, String.valueOf(deliveryDTO.getDueDate()));

            return pstm.executeUpdate() > 0;
        }
    }
//    public static String getNextDeliverId() throws SQLException {
//        Connection con = DBConnection.getInstance().getConnection();
//
//        String sql = "SELECT deliveryId FROM delivery ORDER BY deliveryId DESC LIMIT 1";
//
//        ResultSet resultSet = con.createStatement().executeQuery(sql);
//
//        if (resultSet.next()) {
//            return splitOrderId(resultSet.getString(1));
//        }
//        return splitOrderId(null);
//    }
//    private static String splitOrderId(String currentId) {
//        if(currentId != null) {
//            String[] strings = currentId.split("DEL-");
//            int id = Integer.parseInt(strings[1]);
//            id++;
//            return "DEL-" + id;
//        }
//        return "DEL-001";
//    }

//    public static ObservableList<String> getAllVeId() throws SQLException {
//        String sql = "SELECT vehiId from vehicle";
//
//        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {
//            ResultSet resultSet = pstm.executeQuery();
//            ObservableList<String> dataList = FXCollections.observableArrayList();
//
//            while (resultSet.next()) {
//                dataList.add(new String(
//                        resultSet.getString(1)
//                ));
//
//            }
//            return dataList;
//        }
//    }

    /*public static ObservableList<String> getAllDelivery() throws SQLException {
        String sql = "SELECT deliveryStatus from delivery";

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
    }*/

   /* public static ObservableList<DeliverFormTM> getAllDeliveryFromController() throws SQLException {
        String sql = "SELECT * FROM delivery";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            ResultSet resultSet = pstm.executeQuery();

            ObservableList<DeliverFormTM> dataList = FXCollections.observableArrayList();

            while (resultSet.next()) {
                dataList.add(new DeliverFormTM(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8)
                ));
            }
            return dataList;
        }
    }
*/
    /*public static boolean change(DeliverFormDTO deliverFormDTO) throws SQLException {

        String sql = "UPDATE delivery SET empId = ?,orderId = ?, vehiId = ?,location = ?, deliveryDate = ?,dueDate = ?,deliveryStatus = ? WHERE deliveryId = ?";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            pstm.setString(1, deliverFormDTO.getEmpId());
            pstm.setString(2, deliverFormDTO.getOrderId());
            pstm.setString(3, deliverFormDTO.getVehicalId());
            pstm.setString(4, deliverFormDTO.getLocation());
            pstm.setString(5, String.valueOf(deliverFormDTO.getDeliverDate()));
            pstm.setString(6, String.valueOf(deliverFormDTO.getDueDate()));
            pstm.setString(7, String.valueOf(deliverFormDTO.getDeliverStatus()));
            pstm.setString(8, deliverFormDTO.getDeliverId());

            return pstm.executeUpdate() > 0;
        }
    }

    public static ObservableList<String> getAllVehicalId() throws SQLException {
        String sql = "SELECT vehiId from vehicle";

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
    }

    public static boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM delivery WHERE deliveryId = ?";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            pstm.setString(1, id);
            return pstm.executeUpdate() > 0;
        }
    }*/
}
