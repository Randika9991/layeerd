package lk.ijse.global_flavour.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.global_flavour.bo.BOFactory;
import lk.ijse.global_flavour.bo.custom.impl.SupplyloadFormBOImpl;
import lk.ijse.global_flavour.dto.ItemDTO;
import lk.ijse.global_flavour.dto.PlaceSupplyLoadDTO;
import lk.ijse.global_flavour.dto.SuppliersDTO;
import lk.ijse.global_flavour.util.AlertController;
import lk.ijse.global_flavour.util.TimeAndDateController;
import lk.ijse.global_flavour.util.ValidateField;
import lk.ijse.global_flavour.view.tdm.AddSupplyLoadTM;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewSupplyloadFormController {

    @FXML
    private AnchorPane adminAncPane;

    @FXML
    private JFXComboBox cmbitemcode;

    @FXML
    private TableView<AddSupplyLoadTM> colMainTable;

    @FXML
    private TableColumn<?, ?> colitemcode;

    @FXML
    private TableColumn<?, ?> colitemname;

    @FXML
    private TableColumn<?, ?> colcategory;

    @FXML
    private TableColumn<?, ?> colquantity;

    @FXML
    private TableColumn<?, ?> colaction;

    @FXML
    private JFXButton btnAddToLoad;

    @FXML
    private JFXComboBox cmbsuppid;

    @FXML
    private Label lblchangingitmname;

    @FXML
    private Label lblOrderId111;

    @FXML
    private Label lblchangingsuppname;

    @FXML
    private Label lblchangingcategory;

    @FXML
    private Label lblchangingqtyonhands;

    @FXML
    private Label lblloadid;

    @FXML
    private Label lblsupplydate;

    @FXML
    private Label lblsupplytime;

    @FXML
    private JFXTextField supplyqty;

    @FXML
    private JFXTextField supplyqty1;

    @FXML
    private JFXButton btnAddToLoad1;

    @FXML
    private JFXTextField txttotalprice;

    SupplyloadFormBOImpl supplyloadFormBO = BOFactory.getBOFactory().getBO(BOFactory.BOType.SUPPLY_LOAD);

    private void setRemoveBtnOnAction(Button btn) {
        btn.setOnAction((e) -> {

            boolean ok = AlertController.okconfirmmessage("Are you sure to remove?\", yes, no");

            if (ok) {

                int index = colMainTable.getSelectionModel().getSelectedIndex();
                obList.remove(index);

                colMainTable.refresh();
                //calculateNetTotal();
            }

        });
    }

    private ObservableList<AddSupplyLoadTM> obList = FXCollections.observableArrayList();
    Button btnremove;

    @FXML
    void btnaddcartOnAction(ActionEvent event) {

        if(QTYMyUse<Integer.parseInt((supplyqty.getText()))||QTYMyUse==0){
            AlertController.animationMesseagewrong("Error","Low QTY. Can't add to card");
        }else {
            try {

                if (!supplyqty.getText().isEmpty()) {
                    if(ValidateField.numberCheck(supplyqty.getText())) {
                        String itemcode = String.valueOf(cmbitemcode.getValue());
                        String itemname = lblchangingitmname.getText();
                        String category = lblchangingcategory.getText();
                        Integer quantity = Integer.valueOf(supplyqty.getText());
                        btnremove = new Button("Remove");
                        btnremove.setCursor(Cursor.HAND);

                         setRemoveBtnOnAction(btnremove); /* set action to the btnRemove */
                        if (!obList.isEmpty()) {
                            for (int i = 0; i < colMainTable.getItems().size(); i++) {
                                if (colitemcode.getCellData(i).equals(itemcode)) {
                                    quantity += (int) colquantity.getCellData(i);

                                    obList.get(i).setQuantity(quantity);

                                    colMainTable.refresh();
                                    return;
                                }
                            }
                        }

                        AddSupplyLoadTM tm = new AddSupplyLoadTM(itemcode, itemname, category, quantity, btnremove);

                        obList.add(tm);
                        colMainTable.setItems(obList);

                        supplyqty.setText("");
                    }
                    else{
                        AlertController.animationMesseagewrong("Wrong" ,"Invalid input found in item quantity field.\nMake sure to input an integer value");
                        supplyqty.setStyle("-fx-text-fill: red");
                    }
                } else {
                    AlertController.animationMesseagewrong("Wrong","Quantity field can't be empty. " + "Please make sure to fill all fields the next time you try to add to the load ");
                }

                setRemoveBtnOnAction(btnremove);

            }catch(Exception e){
                System.out.println(e);
                System.out.println("btnAddToCart");
            }

        }

    }

    @FXML
    void btnplaceorderOnAction(ActionEvent event) {
        if (!txttotalprice.getText().isEmpty()) {
            String loadid = lblloadid.getText();
            String suppid = String.valueOf(cmbsuppid.getValue());
            Double totalprice = Double.valueOf(txttotalprice.getText());

            if(ValidateField.priceCheck(String.valueOf(totalprice))) {

                List<PlaceSupplyLoadDTO> placeSupplyLoadDTOList = new ArrayList<>();

                for (int i = 0; i < colMainTable.getItems().size(); i++) {
                    AddSupplyLoadTM addSupplyLoadTM = obList.get(i);

                    PlaceSupplyLoadDTO placeSupplyLoadDTO = new PlaceSupplyLoadDTO(
                            addSupplyLoadTM.getItemcode(),
                            addSupplyLoadTM.getQuantity()
                    );
                    placeSupplyLoadDTOList.add(placeSupplyLoadDTO);
                }

                boolean isPlaced = false;
                try {
                    isPlaced = supplyloadFormBO.placeLoad(loadid, suppid, totalprice, placeSupplyLoadDTOList);
                    if (isPlaced) {
                        AlertController.animationMesseageCorect("Confirmation","Load Added Successfully");
                        generateNextLoadId();
                        cmbsuppid.setValue(null);
                        cmbitemcode.setValue(null);
                        lblchangingsuppname.setText("");
                        lblchangingitmname.setText("");
                        lblchangingcategory.setText("");
                        lblchangingqtyonhands.setText("");
                        txttotalprice.setText("");
                        colMainTable.getItems().clear();
                    } else {
                        AlertController.animationMesseagewrong("Wrong","Supply Load Not Placed");
                    }
                } catch (Exception e) {
                }
            }else{
                AlertController.animationMesseagewrong("Wrong","Invalid input found in load payment field.\nMake sure to input an integer value");
                txttotalprice.setStyle("-fx-text-fill: red");
            }
        }else{
            AlertController.animationMesseagewrong("Wrong","Load payment field can't be empty."+"\n"+"Please make sure to fill that field before you try to add the load ");

        }

    }

    @FXML
    void itemOnMouse(MouseEvent event) {

    }



    @FXML
    void initialize() {
        onActionGetAllSupplierId();
        onActionGetAllItemCode();
        generateNextLoadId();
        TimeAndDateController timeobject = new TimeAndDateController();
        timeobject.timenow(lblsupplytime,lblsupplydate);
        setCellValueFactory();

    }
    private void setCellValueFactory() {
        colitemcode.setCellValueFactory(new PropertyValueFactory<>("itemcode"));
        colitemname.setCellValueFactory(new PropertyValueFactory<>("itemname"));
        colcategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colquantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colaction.setCellValueFactory(new PropertyValueFactory<>("removebtn"));
    }

    void onActionGetAllSupplierId() {

        try {
            /*Get all items*/
            ArrayList<SuppliersDTO> allSupp = supplyloadFormBO.getAllSuppliers();

            for (SuppliersDTO i : allSupp) {
                cmbsuppid.getItems().add(i.getSupplierId());
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

        /*try {
            ObservableList<String> EmpList = SupplyModel.getAll();

            cmbsuppid.getItems().addAll(EmpList);

        } catch (SQLException e) {
            AlertController.animationMesseagewrong("Error","something went wrong!");
        }*/
    }

    @FXML
    void cmbSuppIdOnAction(ActionEvent event) {
        String supp_id = String.valueOf(cmbsuppid.getValue());

        try {
            String name = supplyloadFormBO.getSupplierName(supp_id);
            lblchangingsuppname.setText(name);
        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Exception!").show();
        }
        cmbsuppid.setStyle("-fx-text-fill: white");
        cmbsuppid.setStyle("-fx-prompt-text-fill:white");
    }

    void onActionGetAllItemCode() {

        try {
            ArrayList<ItemDTO> EmpList = supplyloadFormBO.getAllItem();
            for (ItemDTO i : EmpList) {
                cmbitemcode.getItems().addAll(i.getItemCode());
            }
        } catch (SQLException e) {
            AlertController.animationMesseagewrong("Error","something went wrong!");
        }
    }


    int QTYMyUse;
    @FXML
    void cmbitemcodeOnAction(ActionEvent event) {
        String itemcode= String.valueOf(cmbitemcode.getValue());

        try {
            ArrayList<ItemDTO> arrayList = supplyloadFormBO.searchItem(itemcode);

            for (ItemDTO item : arrayList) {
                lblchangingitmname.setText(item.getItemName());
                lblchangingcategory.setText(item.getCategory());
                lblchangingqtyonhands.setText(String.valueOf(item.getQty()));
                QTYMyUse= Integer.parseInt(String.valueOf(item.getQty()));
            }

        } catch (Exception e) {

        }
    }

    private void generateNextLoadId() {
        try {
            String id = supplyloadFormBO.getNextSupplyLoadId();
            lblloadid.setText(id);
        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Exception!").show();
        }
    }

    public void supplyqtyOnMouseClicked(MouseEvent mouseEvent) {
        supplyqty.setStyle("-fx-text-fill: white");
    }

    public void txttotalpriceOnMouseClicked(MouseEvent mouseEvent) {
        txttotalprice.setStyle("-fx-text-fill: white");
    }

}
