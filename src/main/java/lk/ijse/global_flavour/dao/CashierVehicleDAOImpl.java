package lk.ijse.global_flavour.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.CashierCustomerDTO;
import lk.ijse.global_flavour.dto.CashierVehicleDTO;
import lk.ijse.global_flavour.util.SQLUtil;
import lk.ijse.global_flavour.view.tdm.CashierCustomerTM;
import lk.ijse.global_flavour.view.tdm.CashierVehicleTM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CashierVehicleDAOImpl implements CashierVehicleDAO{
    @Override
    public boolean save(CashierVehicleDTO cashVehiDTO) throws SQLException {

        return SQLUtil.execute("INSERT INTO vehicle(vehiId, vehiNo, vehiType) VALUES(?, ?, ?)", cashVehiDTO.getVehicleId(), cashVehiDTO.getVehicleNo(), cashVehiDTO.getVehicleType());
    }

    @Override
    public ArrayList<CashierVehicleDTO> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM vehicle");
        ArrayList<CashierVehicleDTO> arrayList = new ArrayList<>();
        while (rst.next()) {
            arrayList.add(new CashierVehicleDTO(rst.getString(1), rst.getString(2), rst.getString(3)));
        }
        return arrayList;
    }

    @Override
    public boolean update(CashierVehicleDTO cashVehiDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE vehicle SET vehiNo = ?, vehiType = ? WHERE vehiId = ?",cashVehiDTO.getVehicleNo(),cashVehiDTO.getVehicleType(),cashVehiDTO.getVehicleId());

    }

    @Override
    public ArrayList<CashierVehicleDTO> search(String salId) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM vehicle WHERE vehiId = ?");

        ArrayList<CashierVehicleDTO> arrayList = new ArrayList<>();

        if (rst.next()) {
            arrayList.add(new CashierVehicleDTO(rst.getString(1), rst.getString(2), rst.getString(3)));
        }
        return arrayList;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.execute("DELETE FROM vehicle WHERE vehiId = ?", id);
    }

    public ObservableList<CashierVehicleTM> getAllKeyType() throws SQLException {

        ResultSet rst = SQLUtil.execute("SELECT * FROM vehicle");
        ObservableList<CashierVehicleTM> dataList = FXCollections.observableArrayList();

        while (rst.next()) {
            dataList.add(new CashierVehicleTM(rst.getString(1), rst.getString(2), rst.getString(3)));
        }
        return dataList;

    }


//    public static boolean save(CashierVehicleDTO itmAdd) throws SQLException {  //data baes ekata dana set eka
//        String sql = "INSERT INTO vehicle(vehiId, vehiNo, vehiType) " +
//                "VALUES(?, ?, ?)";
//        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {
//
//            pstm.setString(1, itmAdd.getVehicleId());
//            pstm.setString(2, itmAdd.getVehicleNo());
//            pstm.setString(3, itmAdd.getVehicleType());
//
//            return pstm.executeUpdate() > 0;
//        }
//    }
//
//    public static CashierVehicleDTO search(String id) throws SQLException {
//        String sql = "SELECT * FROM vehicle WHERE vehiId = ?";
//
//        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {
//
//            pstm.setString(1, id);
//
//            ResultSet resultSet = pstm.executeQuery();
//            if(resultSet.next()) {
//                return new CashierVehicleDTO(
//                        resultSet.getString(1),
//                        resultSet.getString(2),
//                        resultSet.getString(3)
//
//                );
//            }
//            return null;
//        }
//    }
//
//    public static boolean update(CashierVehicleDTO vehiAdd) throws SQLException {
//        String sql = "UPDATE vehicle SET vehiNo = ?, vehiType = ? WHERE vehiId = ?";
//        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {
//
//            pstm.setString(1, vehiAdd.getVehicleNo());
//            pstm.setString(2, vehiAdd.getVehicleType());
//            pstm.setString(3, vehiAdd.getVehicleId());
//
//            return pstm.executeUpdate() > 0;
//        }
//    }
//
//    public static boolean delete(String id) throws SQLException {
//        String sql = ;
//        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {
//
//            pstm.setString(1, id);
//
//            return pstm.executeUpdate() > 0;
//        }
//    }
//
//    public static ObservableList<CashierVehicleTM> getAll() throws SQLException {
//        String sql = "SELECT * FROM vehicle";
//
//        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {
//
//            ResultSet resultSet = pstm.executeQuery();
//
//            ObservableList<CashierVehicleTM> dataList = FXCollections.observableArrayList();
//
//            while (resultSet.next()) {
//                dataList.add(new CashierVehicleTM(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)
//                ));
//            }
//            return dataList;
//        }
//    }
}
