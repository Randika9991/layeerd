package lk.ijse.global_flavour.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.global_flavour.dto.Delivery;
import lk.ijse.global_flavour.model.DeliveryModel;
import lk.ijse.global_flavour.model.PlaceOrderModel;
import lk.ijse.global_flavour.util.AlertController;

import java.sql.SQLException;
import java.time.LocalDate;

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

    @FXML
    void initialize() {
        generateNextDeliveryId();
        onActionGetAllEmployeeaddToSalary();
        GetAllVehicalId();
        lblOrderId.setText(orderFormController.getGenerateNextOrderIdShireDeliveryController());
    }

    String idShireSave;
    private void generateNextDeliveryId() {

        try {
            String id = DeliveryModel.getNextDeliverId();

            lblDeliverId.setText(id);
            idShireSave=id;

        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }

    void onActionGetAllEmployeeaddToSalary() {

        try {
            ObservableList<String> EmpList = DeliveryModel.getAll();

            cmbEmpId.getItems().addAll(EmpList);

        } catch (SQLException e) {
            AlertController.animationMesseagewrong("Error","something went wrong!");
        }
    }

    void GetAllVehicalId() {

        try {
            ObservableList<String> EmpList = DeliveryModel.getAllVeId();

            cmbVehiId.getItems().addAll(EmpList);

        } catch (SQLException e) {
            AlertController.animationMesseagewrong("Error","something went wrong!");
        }
    }

    @FXML
    void buttonSaveOnACT(ActionEvent event) {

        if(txtLocation.getText().isEmpty()){
            AlertController.animationMesseagewrong("Error","Delivery details not saved. \nPlease make sure to fill the request fields.");
        }else {
            String orderId = String.valueOf(OrderFormController.getGenerateNextOrderIdShireDeliveryController());
            String deliverId = String.valueOf(idShireSave);
            String location = txtLocation.getText();
            String employeId = String.valueOf(cmbEmpId.getValue());
            LocalDate dueDate = DPDueDate.getValue();
            String localTime = String.valueOf(LocalDate.now());
            String vehiId = String.valueOf(cmbVehiId.getValue());
            //boolean status = true;

            Delivery cus = new Delivery(deliverId,employeId,orderId,vehiId,location,localTime,dueDate, true);
            System.out.println(deliverId+" "+employeId+" "+orderId+" "+vehiId+" "+location+" "+localTime+" "+dueDate+" "+true);

            try {
                PlaceOrderModel.saveDelivery(cus);
                AlertController.animationMesseageCorect("CONFIRMATION","Delivery Save Success!");
                deliveryAncPane.getScene().getWindow().hide();

            } catch (Exception e) {
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
