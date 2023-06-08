package lk.ijse.global_flavour.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.global_flavour.dao.CrudDAO;
import lk.ijse.global_flavour.dto.DeliverFormDTO;
import lk.ijse.global_flavour.dto.DeliveryDTO;
import lk.ijse.global_flavour.view.tdm.DeliverFormTM;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DeliveryDAO extends CrudDAO<DeliveryDTO,String> {
     String getNextDeliverId() throws SQLException;

     boolean change(DeliverFormDTO deliverFormDTO) throws SQLException ;

     ArrayList<DeliverFormDTO> getAllDeliveryFromController() throws SQLException;

}
