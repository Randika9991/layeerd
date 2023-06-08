package lk.ijse.global_flavour.dao.custom.impl;

import lk.ijse.global_flavour.dao.custom.DeliveryFormDAO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.dto.DeliverFormDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class DeliveryFormDAOImpl implements DeliveryFormDAO {
    @Override
    public boolean save(DeliverFormDTO SalaryAdd) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<DeliverFormDTO> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean update(DeliverFormDTO adminSalary) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<DeliverFormDTO> search(String salId) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.execute("DELETE FROM delivery WHERE deliveryId = ?", id);
        /*String sql = "DELETE FROM delivery WHERE deliveryId = ?";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            pstm.setString(1, id);
            return pstm.executeUpdate() > 0;
        }*/
    }
}
