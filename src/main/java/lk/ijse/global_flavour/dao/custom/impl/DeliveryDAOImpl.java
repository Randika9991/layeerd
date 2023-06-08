package lk.ijse.global_flavour.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.global_flavour.dao.custom.DeliveryDAO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.DeliverFormDTO;
import lk.ijse.global_flavour.dto.DeliveryDTO;
import lk.ijse.global_flavour.view.tdm.DeliverFormTM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class DeliveryDAOImpl implements DeliveryDAO {

    @Override
    public boolean save(DeliveryDTO deliveryDTO) throws SQLException {
        return SQLUtil.execute("INSERT INTO delivery(deliveryId,empId,orderId,vehiId,location,deliveryDate,dueDate) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?)", deliveryDTO.getDeliverId(), deliveryDTO.getEmpId(), deliveryDTO.getOrderId(), deliveryDTO.getVehicalId(), deliveryDTO.getLocation(), LocalDate.now(),String.valueOf(deliveryDTO.getDueDate()));
//        String sql = ;
//
//        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {
//
//            pstm.setString(1, delivery.getDeliverId());
//            pstm.setString(2, delivery.getEmpId());
//            pstm.setString(3, delivery.getOrderId());
//            pstm.setString(4, delivery.getVehicalId());
//            pstm.setString(5, delivery.getLocation());
//            pstm.setString(6, delivery.getDeliverDate());
//            pstm.setString(7, String.valueOf(delivery.getDueDate()));
//
//            return pstm.executeUpdate() > 0;
//        }
    }

    @Override
    public ArrayList<DeliveryDTO> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean update(DeliveryDTO deliveryDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<DeliveryDTO> search(String salId) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.execute("DELETE FROM delivery WHERE deliveryId = ?", id);
    }

    @Override
    public String getNextDeliverId() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();

        String sql = "SELECT deliveryId FROM delivery ORDER BY deliveryId DESC LIMIT 1";

        ResultSet resultSet = con.createStatement().executeQuery(sql);

        if (resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);
    }

    private static String splitOrderId(String currentId) {
        if(currentId != null) {
            String[] strings = currentId.split("DEL-");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "DEL-" + id;
        }
        return "DEL-001";
    }

    @Override
    public boolean change(DeliverFormDTO deliverFormDTO) throws SQLException {

        String sql = "UPDATE delivery SET empId = ?,orderId = ?, vehiId = ?,location = ?, deliveryDate = ?,dueDate = ?,deliveryStatus = ? WHERE deliveryId = ?";

        return SQLUtil.execute(sql, deliverFormDTO.getEmpId(), deliverFormDTO.getOrderId(), deliverFormDTO.getVehicalId(), deliverFormDTO.getLocation(), deliverFormDTO.getDeliverDate(), deliverFormDTO.getDueDate(), deliverFormDTO.getDeliverStatus(), deliverFormDTO.getDeliverId());

//            try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {
//
//                pstm.setString(1, deliverForm.getEmpId());
//                pstm.setString(2, deliverForm.getOrderId());
//                pstm.setString(3, deliverForm.getVehicalId());
//                pstm.setString(4, );
//                pstm.setString(5, String.valueOf());
//                pstm.setString(6, String.valueOf(deliverForm.getDueDate()));
//                pstm.setString(7, String.valueOf());
//                pstm.setString(8, );
//
//                return pstm.executeUpdate() > 0;
    }

    @Override
    public ArrayList<DeliverFormDTO> getAllDeliveryFromController() throws SQLException {
        /*ResultSet rst = SQLUtil.execute("SELECT * FROM vehicle");
        ArrayList<CashierVehicleDTO> arrayList = new ArrayList<>();
        while (rst.next()) {
            arrayList.add(new CashierVehicleDTO(rst.getString(1), rst.getString(2), rst.getString(3)));
        }
        return arrayList;*/



        ResultSet resultSet = SQLUtil.execute("SELECT * FROM delivery");
        ArrayList<DeliverFormDTO> arrayList = new ArrayList<>();

        while (resultSet.next()) {
            arrayList.add(new DeliverFormDTO(resultSet.getString(1),resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getDate(6).toLocalDate(), resultSet.getDate(7).toLocalDate(), resultSet.getString(8)));
        }
        return arrayList;
//        String sql =;
//
//        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {
//
//            ResultSet resultSet = pstm.executeQuery();
//
//            ObservableList<DeliverFormTM> dataList = FXCollections.observableArrayList();
//
//            while (resultSet.next()) {
//                dataList.add(new DeliverFormTM(
                        /*resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8)*/
//                ));
//            }
//            return dataList;
//        }
    }
}
