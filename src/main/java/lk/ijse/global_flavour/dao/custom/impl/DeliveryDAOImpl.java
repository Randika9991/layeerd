package lk.ijse.global_flavour.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.global_flavour.dao.custom.DeliveryDAO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.db.DBConnection;
//import lk.ijse.global_flavour.dto.DeliverFormDTO;
import lk.ijse.global_flavour.dto.DeliveryDTO;
import lk.ijse.global_flavour.entity.Delivery;
import lk.ijse.global_flavour.view.tdm.DeliverFormTM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class DeliveryDAOImpl implements DeliveryDAO {

    @Override
    public boolean save(Delivery deliveryDTO) throws SQLException {
        return SQLUtil.execute("INSERT INTO delivery(deliveryId,empId,orderId,vehiId,location,deliveryDate,dueDate) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?)", deliveryDTO.getDeliveryId(), deliveryDTO.getEmpId(), deliveryDTO.getOrderId(),
                deliveryDTO.getVehiId(), deliveryDTO.getLocation(), LocalDate.now(),String.valueOf(deliveryDTO.getDueDate()));
    }

    @Override
    public ArrayList<Delivery> getAll() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM delivery");
        ArrayList<Delivery> arrayList = new ArrayList<>();

        while (resultSet.next()) {
            arrayList.add(new Delivery(resultSet.getString(1),resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getDate(6).toLocalDate(), resultSet.getDate(7).toLocalDate(), resultSet.getString(8)));
        }
        return arrayList;
    }

    @Override
    public boolean update(Delivery deliverFormDTO) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE delivery SET empId = ?,orderId = ?, vehiId = ?,location = ?, deliveryDate = ?,dueDate = ?,deliveryStatus = ? WHERE deliveryId = ?";

        return SQLUtil.execute(sql, deliverFormDTO.getEmpId(), deliverFormDTO.getOrderId(), deliverFormDTO.getVehiId(),
                deliverFormDTO.getLocation(), deliverFormDTO.getDeliveryDate(), deliverFormDTO.getDueDate(), deliverFormDTO.getDeliveryStatus(), deliverFormDTO.getDeliveryId());

    }

    @Override
    public ArrayList<Delivery> search(String salId) throws SQLException {
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




}
