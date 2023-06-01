package lk.ijse.global_flavour.dao;

import javafx.collections.ObservableList;
import lk.ijse.global_flavour.dto.CashierVehicleDTO;
import lk.ijse.global_flavour.view.tdm.CashierCustomerTM;
import lk.ijse.global_flavour.view.tdm.CashierVehicleTM;

import java.sql.SQLException;

public interface CashierVehicleDAO extends CrudDAO<CashierVehicleDTO,String>{

     ObservableList<CashierVehicleTM> getAllKeyType() throws SQLException;
}
