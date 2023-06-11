package lk.ijse.global_flavour.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.global_flavour.bo.BOFactory;
import lk.ijse.global_flavour.bo.custom.DeliveryBO;
import lk.ijse.global_flavour.bo.custom.DeliveryFormBO;
import lk.ijse.global_flavour.bo.custom.impl.DeliveryBOImpl;
//import lk.ijse.global_flavour.dao.custom.DeliveryFormDAO;
import lk.ijse.global_flavour.bo.custom.impl.DeliveryFormBOImpl;
import lk.ijse.global_flavour.dao.custom.DeliveryDAO;
import lk.ijse.global_flavour.dao.custom.impl.DeliveryDAOImpl;
import lk.ijse.global_flavour.dto.CashierVehicleDTO;
//import lk.ijse.global_flavour.dto.DeliverFormDTO;
import lk.ijse.global_flavour.dto.DeliveryDTO;
import lk.ijse.global_flavour.dto.EmployeeDTO;
import lk.ijse.global_flavour.view.tdm.DeliverFormTM;
//import lk.ijse.global_flavour.model.*;
import lk.ijse.global_flavour.util.AlertController;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

public class DeliverFormController {

    @FXML
    public TextField txtsearchOrderId;

    @FXML
    public TextField txtsearchDelliverId;

    @FXML
    public TextField txtsearchVehical;

    @FXML
    private AnchorPane adminAncPane;

    @FXML
    private Label lblOrderId;

    @FXML
    private Label lblDeliverId;

    @FXML
    private DatePicker txtEmpDOBBox;

    @FXML
    private DatePicker txtDeliverdDate;

    @FXML
    private TableView<DeliverFormTM> tablOrder;

    @FXML
    private TableColumn<?, ?> CLMOrderID;

    @FXML
    private TableColumn<?, ?> CLMDeliveryID;

    @FXML
    private TableColumn<?, ?> CLMVehicaID;

    @FXML
    private TableColumn<?, ?> CLMDeliveryStatus;

    @FXML
    private TableColumn<?, ?> CLMDueDate;

    @FXML
    private TableColumn<?, ?> CLMDeliveredDate;

    @FXML
    private TableColumn<?, ?> CLMLocation;

    @FXML
    private TableColumn<?, ?> CLMEmployee;

    @FXML
    private JFXTextField txtLocation;

    @FXML
    private JFXComboBox cmbEmpId;

    @FXML
    private JFXComboBox cmbDeliveryStatus;

    @FXML
    private JFXComboBox cmbVehicalId;

    DeliveryFormBO deliveryFormBO = BOFactory.getBOFactory().getBO(BOFactory.BOType.DELIVERY_FORM);

    @FXML
    void searchOrderIdOnKey(KeyEvent event) throws SQLException {

        String searchValue=txtsearchOrderId.getText().trim();
        ArrayList<DeliveryDTO> obList= deliveryFormBO.getAllDeliveryId();

        ObservableList<DeliverFormTM> observableList = FXCollections.observableArrayList();

        for(DeliveryDTO d : obList){
            observableList.add(new DeliverFormTM(d.getDeliverId(),d.getEmpId(),d.getOrderId(),d.getVehicalId(),d.getLocation(),d.getDeliverDate(),d.getDueDate(),d.getDeliverStatus()));
        }

        if (!searchValue.isEmpty()) {
            ObservableList<DeliverFormTM> filteredData = observableList.filtered(new Predicate<DeliverFormTM>(){
                @Override
                public boolean test(DeliverFormTM deliverFormTM) {
                    return String.valueOf(deliverFormTM.getOrderId()).toLowerCase().contains(searchValue.toLowerCase());        }
            });
            tablOrder.setItems(filteredData);} else {
            tablOrder.setItems(observableList);
        }
    }

    @FXML
    void OrderMarkOnMouse(MouseEvent event) {
        TablePosition pos=tablOrder.getSelectionModel().getSelectedCells().get(0);
        int row=pos.getRow();

        ObservableList<TableColumn<DeliverFormTM,?>> columns=tablOrder.getColumns();

        lblOrderId.setText(columns.get(0).getCellData(row).toString());
        lblDeliverId.setText(columns.get(1).getCellData(row).toString());
        cmbVehicalId.setValue(columns.get(2).getCellData(row).toString());

        cmbDeliveryStatus.setValue(columns.get(3).getCellData(row).toString());
        txtEmpDOBBox.setValue(LocalDate.parse(columns.get(4).getCellData(row).toString()));
        txtDeliverdDate.setValue(LocalDate.parse(columns.get(5).getCellData(row).toString()));
        txtLocation.setText(columns.get(6).getCellData(row).toString());
        cmbEmpId.setValue(columns.get(7).getCellData(row).toString());
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        String code = lblDeliverId.getText();
        try {
            boolean isDeleted = deliveryFormBO.deleteDelivery(code);
            if (isDeleted) {
                AlertController.animationMesseageCorect("CONFIRMATION","Delete Success!");
                onActionGetAllDelivery();
            }
        } catch (SQLException e) {
            AlertController.animationMesseagewrong("Error","something went wrong!");
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String orderId = lblOrderId.getText();
        String deliverId = lblDeliverId.getText();
        String VehicalId = String.valueOf(cmbVehicalId.getValue());
        String deliverStatus =(String.valueOf(cmbDeliveryStatus.getValue()));

        LocalDate dueDate = txtEmpDOBBox.getValue();
        LocalDate deliverDate = txtDeliverdDate.getValue();
        String location = txtLocation.getText();
        String employee = String.valueOf(cmbEmpId.getValue());

        try {
            boolean isUpdated = deliveryFormBO.changelDelivery(new DeliveryDTO(deliverId, employee, orderId, VehicalId, location, deliverDate, dueDate, deliverStatus));
            if(isUpdated){
                AlertController.animationMesseageCorect("CONFIRMATION","Employee updated!");
                onActionGetAllDelivery();
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            AlertController.animationMesseagewrong("Error","something went wrong!");
        }
    }

    @FXML
    void cmbDeliveryStatusOnAction(ActionEvent event) {

    }

    @FXML
    void cmbEmpIdOnAction(ActionEvent event) {

    }

    void onActionGetAllEmployeeaddToDelivery() {

        try {
            ArrayList<EmployeeDTO> EmpList = deliveryFormBO.getAllEmployeeId();

            for (EmployeeDTO e : EmpList) {
                cmbEmpId.getItems().addAll(e.getEmployeeId());
            }

        } catch (SQLException e) {
            AlertController.animationMesseagewrong("Error","something went wrong!");
        }
    }

    void onActionGetAllDeliveryStatus() {

        ObservableList<Object> Emplist2 = FXCollections.observableArrayList("Completed", "Not yet Completed");

        cmbDeliveryStatus.getItems().addAll(Emplist2);
    }

    @FXML
    void employeeMarkOnMouse(MouseEvent event) {

    }

    void onActionGetAllVehicalIdaddToDelivery() {

        try {
            ArrayList<CashierVehicleDTO> EmpList = deliveryFormBO.getAllVehicleId();
            for (CashierVehicleDTO c : EmpList) {
                cmbVehicalId.getItems().addAll(c.getVehicleId());
            }

        } catch (SQLException e) {
            AlertController.animationMesseagewrong("Error","something went wrong!");
        }
    }

    @FXML
    void initialize() {
        onActionGetAllEmployeeaddToDelivery();
        onActionGetAllDeliveryStatus();
        onActionGetAllDelivery();
        setCellValuefactory();
        onActionGetAllVehicalIdaddToDelivery();
    }

    void onActionGetAllDelivery() {

        tablOrder.getItems().clear();
        try {
            ArrayList<DeliveryDTO> obList = deliveryFormBO.getAllDeliveryId();

            ObservableList<DeliverFormTM> observableList = FXCollections.observableArrayList();

            for (DeliveryDTO d : obList){
                observableList.add(new DeliverFormTM(d.getDeliverId(), d.getEmpId(), d.getOrderId(), d.getVehicalId(), d.getLocation(), d.getDeliverDate(), d.getDueDate(), d.getDeliverStatus()));

                tablOrder.setItems(observableList);

            }
        } catch (SQLException e) {
            AlertController.animationMesseagewrong("Error","something went wrong!");
        }
//        try {
//         //   ObservableList<DeliverFormTM> supList = DeliveryModel.getAllDeliveryFromController();
//         //   tablOrder.setItems(supList);
//
//        } catch (SQLException e) {
//            AlertController.animationMesseagewrong("Error","something went wrong!");
//        }
    }

    void setCellValuefactory(){
        CLMOrderID.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        CLMDeliveryID.setCellValueFactory(new PropertyValueFactory<>("deliverId"));
        //
        CLMVehicaID.setCellValueFactory(new PropertyValueFactory<>("vehicalId"));
        CLMDeliveryStatus.setCellValueFactory(new PropertyValueFactory<>("deliverStatus"));
        CLMDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        CLMDeliveredDate.setCellValueFactory(new PropertyValueFactory<>("deliverDate"));
        CLMLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        CLMEmployee.setCellValueFactory(new PropertyValueFactory<>("empId"));

    }

    @FXML
    public void lblClearAllOnAction(ActionEvent actionEvent) {

    }

    @FXML
    public void OrderIdOnAction(ActionEvent actionEvent) {

    }

    @FXML
    public void OrderIdOnActionSerch(ActionEvent actionEvent) {

    }

    @FXML
    public void DeliverIdOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void DeliveryOnActionSerch(ActionEvent actionEvent) {
    }

    @FXML
    public void searchDeliverOnKey(KeyEvent keyEvent) throws SQLException{
        String searchValue=txtsearchDelliverId.getText().trim();
        ArrayList<DeliveryDTO> obList= deliveryFormBO.getAllDeliveryId();

        ObservableList<DeliverFormTM> observableList = FXCollections.observableArrayList();

        for(DeliveryDTO d : obList){
            observableList.add(new DeliverFormTM(d.getDeliverId(),d.getEmpId(),d.getOrderId(),d.getVehicalId(),d.getLocation(),d.getDeliverDate(),d.getDueDate(),d.getDeliverStatus()));
        }

        if (!searchValue.isEmpty()) {
            ObservableList<DeliverFormTM> filteredData = observableList.filtered(new Predicate<DeliverFormTM>(){
                @Override
                public boolean test(DeliverFormTM deliverFormTM) {
                    return String.valueOf(deliverFormTM.getDeliverId()).toLowerCase().contains(searchValue.toLowerCase());        }
            });
            tablOrder.setItems(filteredData);} else {
            tablOrder.setItems(observableList);
        }
    }

    @FXML
    public void VehicalOnAction(ActionEvent actionEvent) {

    }

    @FXML
    public void VehicalOnActionSerch(ActionEvent actionEvent) {

    }

    @FXML
    public void searchVehicalOnKey(KeyEvent keyEvent) throws SQLException {
        String searchValue=txtsearchVehical.getText().trim();
        ArrayList<DeliveryDTO> obList= deliveryFormBO.getAllDeliveryId();

        ObservableList<DeliverFormTM> observableList = FXCollections.observableArrayList();

        for(DeliveryDTO d : obList){
            observableList.add(new DeliverFormTM(d.getDeliverId(),d.getEmpId(),d.getOrderId(),d.getVehicalId(),d.getLocation(),d.getDeliverDate(),d.getDueDate(),d.getDeliverStatus()));
        }

        if (!searchValue.isEmpty()) {
            ObservableList<DeliverFormTM> filteredData = observableList.filtered(new Predicate<DeliverFormTM>(){
                @Override
                public boolean test(DeliverFormTM deliverFormTM) {
                    return String.valueOf(deliverFormTM.getVehicalId()).toLowerCase().contains(searchValue.toLowerCase());        }
            });
            tablOrder.setItems(filteredData);} else {
            tablOrder.setItems(observableList);
        }

    }
}
