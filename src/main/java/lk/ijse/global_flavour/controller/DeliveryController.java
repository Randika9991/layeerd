package lk.ijse.global_flavour.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.global_flavour.bo.custom.impl.DeliveryBOImpl;
import lk.ijse.global_flavour.bo.custom.impl.OrderFormBOImpl;
import lk.ijse.global_flavour.dto.CashierVehicleDTO;
import lk.ijse.global_flavour.dto.DeliveryDTO;
import lk.ijse.global_flavour.dto.EmployeeDTO;
import lk.ijse.global_flavour.model.PlaceOrderModel;
import lk.ijse.global_flavour.util.AlertController;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class DeliveryController {

    OrderFormController orderFormController = new OrderFormController();

    @FXML
    private Label lblOrderId;

    @FXML
    private Label lblDeliverId;

    @FXML
    private JFXComboBox cmbEmpId;

    @FXML
    private JFXComboBox cmbVehiId;

    @FXML
    private JFXTextField txtLocation;

    @FXML
    private DatePicker DPDueDate;

    @FXML
    private AnchorPane deliveryAncPane;

    DeliveryBOImpl deliveryBO = new DeliveryBOImpl();

    @FXML
    void initialize() {
        generateNextDeliveryId();
        onActionGetAllEmployeeaddToSalary();
        GetAllVehicalId();
        lblOrderId.setText(orderFormController.getGenerateNextOrderIdShireDeliveryController());
    }

    String idShireSave;
    private void generateNextDeliveryId() {

        //createdDAO
        try {
            String id = deliveryBO.getNextDeliverId();

            lblDeliverId.setText(id);
            idShireSave=id;

        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }

    void onActionGetAllEmployeeaddToSalary() {

        try {
            ArrayList<EmployeeDTO> EmpList = deliveryBO.getAllEmployeeId();
            for(EmployeeDTO e : EmpList) {
                cmbEmpId.getItems().addAll(e.getEmployeeId());
            }

        } catch (SQLException e) {
            AlertController.animationMesseagewrong("Error","something went wrong!");
        }
    }

    void GetAllVehicalId() {

        try {
            ArrayList<CashierVehicleDTO> EmpList = deliveryBO.getAllVehicleId();

            for (CashierVehicleDTO c : EmpList) {
                cmbVehiId.getItems().addAll(c.getVehicleId());
            }


        } catch (SQLException e) {
            AlertController.animationMesseagewrong("Error","something went wrong!");
        }
    }

    @FXML
    void buttonSaveOnACT(ActionEvent event) {

        //createdDAO
        if(txtLocation.getText().isEmpty()){
            AlertController.animationMesseagewrong("Error","Delivery details not saved. \nPlease make sure to fill the request fields.");
        }else {
            String orderId = String.valueOf(OrderFormController.getGenerateNextOrderIdShireDeliveryController());
            String deliverId = String.valueOf(idShireSave);
            String location = txtLocation.getText();
            String employeId = String.valueOf(cmbEmpId.getValue());
            LocalDate dueDate = DPDueDate.getValue();
          //  String localD = String.valueOf(LocalDate.now());
            String vehiId = String.valueOf(cmbVehiId.getValue());
            //boolean status = true;

            DeliveryDTO cus = new DeliveryDTO(deliverId,employeId,orderId,vehiId,location,dueDate);
            //System.out.println(deliverId+" "+employeId+" "+orderId+" "+vehiId+" "+location+" "+localTime+" "+dueDate+" "+true);

            try {
                OrderFormBOImpl.saveDelivery(cus);
                AlertController.animationMesseageCorect("CONFIRMATION","Delivery Save Success!");
                deliveryAncPane.getScene().getWindow().hide();

            }catch (Exception e) {
//            System.out.println(e);
                AlertController.animationMesseagewrong("Error","something went wrong!");
            }
        }
    }

    @FXML
    void cmbEmpIdOnAction(ActionEvent event) {

    }

    @FXML
    void cmbVehiIdOnAction(ActionEvent event) {

    }

}
