package lk.ijse.global_flavour.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.global_flavour.db.DBConnection;
import lk.ijse.global_flavour.dto.CashierCustomerDTO;
import lk.ijse.global_flavour.view.tdm.CashierCustomerTM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CashierCustomerModel {
//    public static boolean save(CashierCustomerDTO cashiAdd) throws SQLException {  //data baes ekata dana set eka
//        String sql = "INSERT INTO customer(custId, custName, contactNo ,Address ,email) " +
//                "VALUES(?, ?, ?, ? ,?)";
//
//        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {
//
//            pstm.setString(1, cashiAdd.getCustomerId());
//            pstm.setString(2, cashiAdd.getCustomerName());
//            pstm.setString(3, cashiAdd.getContactNo());
//            pstm.setString(4, cashiAdd.getAddress());
//            pstm.setString(5, cashiAdd.getEmail());
//
//            return pstm.executeUpdate() > 0;
//        }
//    }
//
//    public static boolean update(CashierCustomerDTO cashiAdd) throws SQLException {
//        String sql = "UPDATE customer SET custName = ?, contactNo = ?, Address = ?, email = ? WHERE custId = ?";
//
//        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {
//
//            pstm.setString(1, cashiAdd.getCustomerName());
//            pstm.setString(2, cashiAdd.getContactNo());
//            pstm.setString(3, cashiAdd.getAddress());
//            pstm.setString(4, cashiAdd.getEmail());
//            pstm.setString(5, cashiAdd.getCustomerId());
//
//            return pstm.executeUpdate() > 0;
//        }
//    }
//
//    public static boolean delete(String id) throws SQLException {
//        String sql = "DELETE FROM customer WHERE custId = ?";
//
//        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {
//
//            pstm.setString(1, id);
//            return pstm.executeUpdate() > 0;
//        }
//    }

    public static CashierCustomerDTO search(String id) throws SQLException {
        String sql = "SELECT * FROM customer WHERE custId = ?";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {
            pstm.setString(1, id);
            ResultSet resultSet = pstm.executeQuery();

            if(resultSet.next()) {
                return new CashierCustomerDTO(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)

                );
            }
            return null;
        }
    }

    public static ObservableList<CashierCustomerTM> getAll() throws SQLException {
        String sql = "SELECT * FROM customer";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {
            ResultSet resultSet = pstm.executeQuery();
            ObservableList<CashierCustomerTM> dataList = FXCollections.observableArrayList();

            while (resultSet.next()) {
                dataList.add(new CashierCustomerTM(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)

                ));
            }
            return dataList;
        }
    }

}
