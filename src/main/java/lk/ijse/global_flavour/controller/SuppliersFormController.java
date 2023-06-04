//all added
package lk.ijse.global_flavour.controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.global_flavour.dao.custom.SuppliersDAO;
import lk.ijse.global_flavour.dao.custom.impl.SuppliersDAOImpl;
import lk.ijse.global_flavour.dto.SuppliersDTO;
import lk.ijse.global_flavour.view.tdm.CashierCustomerTM;
import lk.ijse.global_flavour.view.tdm.SuppliersTM;
import lk.ijse.global_flavour.model.SuppliersModel;
import lk.ijse.global_flavour.util.AlertController;
import lk.ijse.global_flavour.util.ValidateField;

public class SuppliersFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane adminAncPane;

    @FXML
    private TextField txtsearchSupplier;

    @FXML
    private JFXTextField txtsupId;

    @FXML
    private JFXTextField txtsupName;

    @FXML
    private JFXTextField txtsupAddress;

    @FXML
    private JFXTextField txtsupContact;

    @FXML
    private JFXTextField txtsupEmail;

    @FXML
    private TableView<SuppliersTM> mainCOMSupliar;

    @FXML
    private TableColumn<?, ?> COMSupId;

    @FXML
    private TableColumn<?, ?> COMSupName;

    @FXML
    private TableColumn<?, ?> COMSupAddress;

    @FXML
    private TableColumn<?, ?> COMSupContact;

    @FXML
    private TableColumn<?, ?> COMSupEmail;

    @FXML
    private Label lblInvalidEmail;

    @FXML
    private Label lblInvalidContactNo;

    @FXML
    private Label lblInvalidSupplier;

    //all added
    //used SuppliersDAO object create SuppliersDAOImpl

    SuppliersDAO suppliersDAO = new SuppliersDAOImpl();

    @FXML
    void buttonSaveOnACT(ActionEvent event) {
        if(txtsupName.getText().isEmpty()||txtsupAddress.getText().isEmpty()){
            AlertController.animationMesseagewrong("Error","Supplier details not saved. \nPlease make sure to fill the request fields.");
        }else {
            if(ValidateField.SupplierCheck(txtsupId.getText()) ||ValidateField.contactCheck(txtsupContact.getText()) ||ValidateField.emailCheck(txtsupEmail.getText())){
                if(ValidateField.emailCheck(txtsupEmail.getText())){
                    if(ValidateField.contactCheck(txtsupContact.getText())){
                        if(ValidateField.SupplierCheck(txtsupId.getText()) ){
                            lblInvalidSupplier.setVisible(false);
                            String SupId = txtsupId.getText();
                            String SupName = txtsupName.getText();
                            String SupAddress = txtsupAddress.getText();
                            String supContact = txtsupContact.getText();
                            String supEmail = txtsupEmail.getText();

                            try {
//            boolean isSaved = ItemModel.save(code, description, unitPrice, qtyOnHand);
                                boolean isSaved = suppliersDAO.save(new SuppliersDTO(SupId, SupName, SupAddress,supEmail,supContact));
                                if (isSaved) {
                                    AlertController.animationMesseageCorect("CONFIRMATION","Supplier Save Success!");
                                    onActionGetAllSuppliers();
                                }
                            } catch (SQLException e) {
                                System.out.println(e);
                                AlertController.animationMesseagewrong("Error","something went wrong!");
                            }
                        }else {
                            lblInvalidSupplier.setVisible(true);
                        }

                    }else {
                        lblInvalidContactNo.setVisible(true);
                    }

                }else {
                    lblInvalidEmail.setVisible(true);
                }

            }else {
                lblInvalidContactNo.setVisible(true);
                lblInvalidEmail.setVisible(true);
                lblInvalidSupplier.setVisible(true);
            }
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if(txtsupId.getText().isEmpty()||txtsupName.getText().isEmpty()||txtsupAddress.getText().isEmpty()){
            AlertController.animationMesseagewrong("Error","Supplier details not updated. \nPlease make sure to fill the request fields.");
        }else {
            if(ValidateField.contactCheck(txtsupContact.getText()) ||ValidateField.emailCheck(txtsupEmail.getText())){
                if(ValidateField.emailCheck(txtsupEmail.getText())){
                    if(ValidateField.contactCheck(txtsupContact.getText())){

                        String SupId = txtsupId.getText();
                        String SupName = txtsupName.getText();
                        String SupAddress = txtsupAddress.getText();
                        String supContact = txtsupContact.getText();
                        String supEmail = txtsupEmail.getText();

                       // SuppliersDTO itemSup = new SuppliersDTO(SupId, SupName, SupAddress, supEmail, supContact);

                        try {
                            boolean isUpdated = suppliersDAO.update( new SuppliersDTO(SupId, SupName, SupAddress, supEmail, supContact));
                            if (isUpdated) {
                                AlertController.animationMesseageCorect("CONFIRMATION","Supplier updated!");
                                onActionGetAllSuppliers();
                            }
                        } catch (SQLException | ClassNotFoundException e) {
                            e.printStackTrace();
                            AlertController.animationMesseagewrong("Error","something went wrong!");
                        }

                    }else {
                        lblInvalidContactNo.setVisible(true);
                    }

                }else {
                    lblInvalidEmail.setVisible(true);
                }

            }else {
                lblInvalidContactNo.setVisible(true);
                lblInvalidEmail.setVisible(true);
            }
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        if(txtsupId.getText().isEmpty()){

        }else {
            boolean ok = AlertController.okconfirmmessage("Are you Sure. Do you wont Delete item");

            if(ok) {
                String code = txtsupId.getText();
                try {
                    boolean isDeleted = suppliersDAO.delete(code);
                    if (isDeleted) {
                        AlertController.animationMesseageCorect("CONFIRMATION","Delete Success!");
                        onActionGetAllSuppliers();
                    }
                } catch (SQLException e) {
                    AlertController.animationMesseagewrong("Error","something went wrong!");
                }
            }
        }
    }

    @FXML
    void supIdOnAction(ActionEvent event) {
        String id = txtsupId.getText();

        try {
            ArrayList<SuppliersDTO> arrayList = suppliersDAO.search(id);
            for (SuppliersDTO cust : arrayList) {
                txtsupId.setText(cust.getSupplierId());
                txtsupName.setText(cust.getSupplierName());
                txtsupAddress.setText(cust.getSupplierAddress());
                txtsupContact.setText(cust.getSupplierCotact());
                txtsupEmail.setText(cust.getSupplierEmail());
            }

//            if (cust != null) {
//                txtsupId.setText(cust.getSupplierId());
//                txtsupName.setText(cust.getSupplierName());
//                txtsupAddress.setText(cust.getSupplierAddress());
//                txtsupContact.setText(cust.getSupplierCotact());
//                txtsupEmail.setText(cust.getSupplierEmail());
//            }
        } catch (SQLException e) {
            AlertController.animationMesseagewrong("Error","something went wrong!");
        }
    }

    @FXML
    void supplierOnMouse(MouseEvent event) {
        TablePosition pos=mainCOMSupliar.getSelectionModel().getSelectedCells().get(0);
        int row=pos.getRow();

        ObservableList<TableColumn<SuppliersTM,?>> columns=mainCOMSupliar.getColumns();

        txtsupId.setText(columns.get(0).getCellData(row).toString());
        txtsupName.setText(columns.get(1).getCellData(row).toString());
        txtsupAddress.setText(columns.get(2).getCellData(row).toString());
        txtsupContact.setText(columns.get(3).getCellData(row).toString());
        txtsupEmail.setText(columns.get(4).getCellData(row).toString());

    }

    @FXML
    public void searchSupOnKey(KeyEvent keyEvent) throws SQLException {

        String searchValue=txtsearchSupplier.getText().trim();
        ArrayList<SuppliersDTO> obList= suppliersDAO.getAll();
        ObservableList<SuppliersTM> observableList = FXCollections.observableArrayList();
        for (SuppliersDTO s : obList ) {
            observableList.add(new SuppliersTM(s.getSupplierId(), s.getSupplierName(), s.getSupplierAddress(), s.getSupplierEmail(), s.getSupplierCotact()));
        }

        if (!searchValue.isEmpty()) {
            ObservableList<SuppliersTM> filteredData = observableList.filtered(new Predicate<SuppliersTM>(){
                @Override
                public boolean test(SuppliersTM suppliersTM) {
                    return String.valueOf(suppliersTM.getSupplierId()).toLowerCase().contains(searchValue.toLowerCase());        }
            });
            mainCOMSupliar.setItems(filteredData);} else {
            mainCOMSupliar.setItems(observableList);
        }
    }

    public void supIdOnActionSerch(ActionEvent actionEvent) {
        String id = txtsearchSupplier.getText();

        try {
            ArrayList<SuppliersDTO> arrayList = suppliersDAO.search(id);
            for (SuppliersDTO cust : arrayList) {
                txtsupId.setText(cust.getSupplierId());
                txtsupName.setText(cust.getSupplierName());
                txtsupAddress.setText(cust.getSupplierAddress());
                txtsupContact.setText(cust.getSupplierCotact());
                txtsupEmail.setText(cust.getSupplierEmail());
            }

        } catch (SQLException e) {
            AlertController.animationMesseagewrong("Error","something went wrong!");
        }
    }
    @FXML
    void txtContactNumberOnMouseClick(MouseEvent event) {
        lblInvalidContactNo.setVisible(false);
    }

    @FXML
    void txtemailOnMouseClick(MouseEvent event) {
        lblInvalidEmail.setVisible(false);
    }

    @FXML
    void initialize() {
        onActionGetAllSuppliers();
        setCellValuefactory();
        lblInvalidContactNo.setVisible(false);
        lblInvalidEmail.setVisible(false);
        lblInvalidSupplier.setVisible(false);

    }

    void onActionGetAllSuppliers() {
        mainCOMSupliar.getItems().clear();
        try {
            ArrayList<SuppliersDTO> supList = suppliersDAO.getAll();
            for (SuppliersDTO s : supList) {
                mainCOMSupliar.getItems().add(new SuppliersTM(s.getSupplierId(), s.getSupplierName(), s.getSupplierAddress(), s.getSupplierEmail(), s.getSupplierCotact()));
            }

        } catch (SQLException e) {
            AlertController.animationMesseagewrong("Error","something went wrong!");
        }
    }

    void setCellValuefactory(){
        COMSupId.setCellValueFactory(new PropertyValueFactory<>("SupplierId"));
        COMSupName.setCellValueFactory(new PropertyValueFactory<>("SupplierName"));
        COMSupAddress.setCellValueFactory(new PropertyValueFactory<>("SupplierAddress"));
        COMSupContact.setCellValueFactory(new PropertyValueFactory<>("SupplierCotact"));
        COMSupEmail.setCellValueFactory(new PropertyValueFactory<>("SupplierEmail"));

    }

    public void lblClearAllOnAction(ActionEvent mouseEvent) {
        txtsupId.setText("");
        txtsupName.setText("");
        txtsupAddress.setText("");
        txtsupContact.setText("");
        txtsupEmail.setText("");
    }
}
