package lk.ijse.global_flavour.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.global_flavour.dao.custom.CashierVehicleDAO;
import lk.ijse.global_flavour.dto.CashierVehicleDTO;
import lk.ijse.global_flavour.dao.custom.impl.util.SQLUtil;
import lk.ijse.global_flavour.view.tdm.CashierVehicleTM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CashierVehicleDAOImpl implements CashierVehicleDAO {
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

}
