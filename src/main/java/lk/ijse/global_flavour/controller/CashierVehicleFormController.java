//all added
package lk.ijse.global_flavour.controller;

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
import lk.ijse.global_flavour.bo.custom.CashierVehicleBO;
import lk.ijse.global_flavour.bo.custom.impl.CashierVehicleBOImpl;
import lk.ijse.global_flavour.dto.CashierVehicleDTO;
import lk.ijse.global_flavour.view.tdm.CashierVehicleTM;
import lk.ijse.global_flavour.util.AlertController;
import lk.ijse.global_flavour.util.ValidateField;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Predicate;

public class CashierVehicleFormController {

    @FXML
    private AnchorPane adminAncPane;

    @FXML
    private JFXTextField txtVehiId;

    @FXML
    private JFXTextField txtVehiNo;

    @FXML
    private JFXTextField txtVehitype;

    @FXML
    private TableView<CashierVehicleTM> mainCOMVehical;

    @FXML
    private TableColumn<?, ?> COMVehiId;

    @FXML
    private TableColumn<?, ?> COMVehiNo;

    @FXML
    private TableColumn<?, ?> COMVehiType;

    @FXML
    private TextField txtsearchVehical;


    @FXML
    private Label lblInvalidVehical;

    // CashierVehicleDAO vehicleDAO = new CashierVehicleDAOImpl();
    //all added
    //used admin CashierVehicleDAO object create CashierCustomerDAOImpl

    //use bo
    //only added CashierVehicleBOImpl

    CashierVehicleBO vehicleBO = new CashierVehicleBOImpl();

    @FXML
    void buttonSaveOnACT(ActionEvent event) {
        if(txtVehiId.getText().isEmpty()||txtVehiNo.getText().isEmpty()||txtVehitype.getText().isEmpty()){
            AlertController.animationMesseagewrong("Error","Vehicle details not saved. \nPlease make sure to fill the request fields.");

        }else {

            if(ValidateField.VehicalIdCheck(txtVehiId.getText())){

                lblInvalidVehical.setVisible(false);
                String vehiId = txtVehiId.getText();
                String vehiNo = txtVehiNo.getText();
                String vehitype = txtVehitype.getText();

                try {
                    boolean isSaved = vehicleBO.saveVehicle(new CashierVehicleDTO(vehiId, vehiNo,vehitype));
                    if (isSaved) {
                        AlertController.animationMesseageCorect("CONFIRMATION","Vehicle Save Success!");
                        onActionGetAllItem();
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                    AlertController.animationMesseagewrong("Error","something went wrong!");
                }

            }else {
                lblInvalidVehical.setVisible(true);
            }

        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        if(txtVehiId.getText().isEmpty()||txtVehiNo.getText().isEmpty()||txtVehitype.getText().isEmpty()){
            AlertController.animationMesseagewrong("Error","Vehicle details not updated. \nPlease make sure to fill the request fields.");

        }else {
            String vehiId = txtVehiId.getText();
            String vehiNo = txtVehiNo.getText();
            String vehitype = txtVehitype.getText();

            try {
                boolean isUpdated = vehicleBO.updateVehicle(new CashierVehicleDTO(vehiId, vehiNo,vehitype));

                if(isUpdated){
                    AlertController.animationMesseageCorect("CONFIRMATION","Vehicle updated!");
                    onActionGetAllItem();
                }

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                AlertController.animationMesseagewrong("Error","something went wrong!");
            }

        }

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        if(txtVehiId.getText().isEmpty()){

        }else {
            boolean ok = AlertController.okconfirmmessage("Are you Sure. Do you wont Delete item");

            if(ok){

                try {
                    boolean isDeleted = vehicleBO.deleteVehicle(txtVehiId.getText());
                    if (isDeleted) {
                        AlertController.animationMesseageCorect("CONFIRMATION","Delete Success!");
                        onActionGetAllItem();
                    }
                } catch (SQLException e) {
                    AlertController.animationMesseagewrong("Error","something went wrong!");
                }
            }
        }
    }

    @FXML
    void CusIdOnActionSerch(ActionEvent event) {
        String id = txtsearchVehical.getText();

        try {
            ArrayList<CashierVehicleDTO> cust = vehicleBO.searchVehicle(id);
            for (CashierVehicleDTO c : cust) {
                txtVehiId.setText(c.getVehicleId());
                txtVehiNo.setText(c.getVehicleNo());
                txtVehitype.setText(c.getVehicleType());

            }

        } catch (SQLException e) {
            AlertController.animationMesseagewrong("Error","something went wrong!");
        }

    }

    @FXML
    void searchCusOnKey(KeyEvent event) throws SQLException {
        String searchValue=txtsearchVehical.getText().trim();
        ArrayList<CashierVehicleDTO> obList = vehicleBO.getAllVehicle();
        ObservableList<CashierVehicleTM> observableList = FXCollections.observableArrayList();

        for (CashierVehicleDTO c : obList) {
            observableList.add(new CashierVehicleTM(c.getVehicleId(), c.getVehicleNo(), c.getVehicleType()));
        }

        if (!searchValue.isEmpty()) {
            ObservableList<CashierVehicleTM> filteredData = observableList.filtered(new Predicate<CashierVehicleTM>(){
                @Override
                public boolean test(CashierVehicleTM itemTM) {
                    return String.valueOf(itemTM.getVehicleId()).toLowerCase().contains(searchValue.toLowerCase());        }
            });
            mainCOMVehical.setItems(filteredData);} else {
            mainCOMVehical.setItems(observableList);
        }
    }

    @FXML
    void supplierOnMouse(MouseEvent event) {
        TablePosition pos=mainCOMVehical.getSelectionModel().getSelectedCells().get(0);
        int row=pos.getRow();

        ObservableList<TableColumn<CashierVehicleTM,?>> columns=mainCOMVehical.getColumns();

        txtVehiId.setText(columns.get(0).getCellData(row).toString());
        txtVehiNo.setText(columns.get(1).getCellData(row).toString());
        txtVehitype.setText(columns.get(2).getCellData(row).toString());
    }

    @FXML
    void vehiIdOnAction(ActionEvent event) {

    }
    @FXML
    void initialize() {
        onActionGetAllItem();
        setCellValuefactory();
        lblInvalidVehical.setVisible(false);

    }

    void onActionGetAllItem() {
        mainCOMVehical.getItems().clear();
        try {
            ArrayList<CashierVehicleDTO> supList = vehicleBO.getAllVehicle();
            for (CashierVehicleDTO c : supList) {
                mainCOMVehical.getItems().add(new CashierVehicleTM(c.getVehicleId(), c.getVehicleNo(), c.getVehicleType()));

            }
        } catch (SQLException e) {
            AlertController.animationMesseagewrong("Error","something went wrong!");
        }

    }

    void setCellValuefactory(){
        COMVehiId.setCellValueFactory(new PropertyValueFactory<>("vehicleId"));
        COMVehiNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        COMVehiType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));

    }

    public void lblClearAllOnAction(ActionEvent actionEvent) {
        txtVehiId.setText("");
        txtVehiNo.setText("");
        txtVehitype.setText("");
    }
}
