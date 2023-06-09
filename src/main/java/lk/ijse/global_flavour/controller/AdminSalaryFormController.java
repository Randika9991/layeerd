
package lk.ijse.global_flavour.controller;

import com.jfoenix.controls.JFXButton;
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
import lk.ijse.global_flavour.bo.custom.AdminSalaryBO;
import lk.ijse.global_flavour.bo.custom.impl.AdminSalaryBOImpl;
import lk.ijse.global_flavour.dto.AdminSalaryDTO;
import lk.ijse.global_flavour.dto.EmployeeDTO;
import lk.ijse.global_flavour.view.tdm.AdminSalaryTM;
import lk.ijse.global_flavour.util.AlertController;
import lk.ijse.global_flavour.util.ValidateField;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Predicate;


public class AdminSalaryFormController {
    @FXML
    private AnchorPane adminAncPane;

    @FXML
    private JFXTextField txtSalaryId;

    @FXML
    private JFXTextField txtSalaryAmountId;

    @FXML
    private TableView<AdminSalaryTM> TBLsalary;

    @FXML
    private TableColumn<?, ?> tabColumEmployeID;

    @FXML
    private TableColumn<?, ?> tabColumSalaryID;

    @FXML
    private TableColumn<?, ?> tabColumSalaryAmount;

    @FXML
    private TableColumn<?, ?> tabColumPaymentMethord;

    @FXML
    private JFXButton btnDeleatSalary;

    @FXML
    private JFXButton btnUpdateSalary;

    @FXML
    private JFXButton btnSaveSalary;

    @FXML
    private TextField txtsearchSalary;

    @FXML
    private Button searchBtnSalary;

    @FXML
    private JFXComboBox COBEmployeEmpId;

    @FXML
    private JFXComboBox CBMPayM;

    @FXML
    private Label lblInvalidsalary;

    @FXML
    void salIdOnAction(ActionEvent event) {

    }

    //AdminSalaryDAO adminSalary = new AdminSalaryDAOImpl();

    //all added
    //used admin salaryDAO object create AdminSalaryDAOImpl

    //use bo
    //only added AdminSalaryBOImpl



    AdminSalaryBO adminSalaryBO = BOFactory.getBOFactory().getBO(BOFactory.BOType.ADMIN_SALARY);

    @FXML
    void salarySaveONAct(ActionEvent event) {

        if (txtSalaryId.getText().isEmpty() || txtSalaryAmountId.getText().isEmpty()) {
            AlertController.animationMesseagewrong("Error", "Employee details not saved. \nPlease make sure to fill the request fields.");
        } else {
            if (ValidateField.SalaryCheck(txtSalaryId.getText())) {
                lblInvalidsalary.setVisible(false);
                String employeId = String.valueOf(COBEmployeEmpId.getValue());
                String salaryId = txtSalaryId.getText();
                String salaryAmount = txtSalaryAmountId.getText();
                String salaryPayment = String.valueOf(CBMPayM.getValue());

                try {
                    boolean isSaved = adminSalaryBO.AdminSalarySave(new AdminSalaryDTO(salaryId, employeId, salaryAmount, salaryPayment));

                    if (isSaved) {
                        AlertController.animationMesseageCorect("CONFIRMATION", "Salary Save Success!");
                       onActionGetAllSallary();
                    }
                } catch (SQLException e) {
                    AlertController.animationMesseagewrong("Error", "something went wrong!");
                }
            } else {
                lblInvalidsalary.setVisible(true);
            }
        }
    }

    @FXML
    void salaryUpdateONAct(ActionEvent event) {

        if (txtSalaryId.getText().isEmpty() || txtSalaryAmountId.getText().isEmpty()) {
            AlertController.animationMesseagewrong("Error", "Employee details not saved. \nPlease make sure to fill the request fields.");
        } else {
            String employeId = String.valueOf(COBEmployeEmpId.getValue());
            String salaryId = txtSalaryId.getText();
            String salaryAmount = txtSalaryAmountId.getText();
            String salaryPayment = String.valueOf(CBMPayM.getValue());

            try {
                System.out.println("waiting");
                boolean isUpdated = adminSalaryBO.AdminSalaryUpdate(new AdminSalaryDTO(salaryId, employeId, salaryAmount, salaryPayment));
                if (isUpdated) {
                    AlertController.animationMesseageCorect("CONFIRMATION", "Salary updated!");

                   onActionGetAllSallary();
                }
            } catch (SQLException throwables) {
                AlertController.animationMesseagewrong("Error", "something went wrong!");
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                AlertController.animationMesseagewrong("Error", "something went wrong!");
                e.printStackTrace();
            }
        }
    }

    @FXML
    void salaryDeleteONAct(ActionEvent event) {

        if (txtSalaryId.getText().isEmpty()) {

        } else {
            boolean ok = AlertController.okconfirmmessage("Are you Sure. Do you wont Delete item");

            if (ok) {
                String code = txtSalaryId.getText();
                try {
                    boolean isDeleted = adminSalaryBO.AdminSalaryDelete(code);
                    if (isDeleted) {
                        AlertController.animationMesseageCorect("CONFIRMATION", "Delete Success!");
                        onActionGetAllSallary();
                    }
                } catch (SQLException e) {
                    AlertController.animationMesseagewrong("Error", "something went wrong!");
                }

            }
        }
    }

    @FXML
    void SalryTableOnMouse(MouseEvent event) {

        TablePosition pos = TBLsalary.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();

        ObservableList<TableColumn<AdminSalaryTM, ?>> columns = TBLsalary.getColumns();

        COBEmployeEmpId.setValue(columns.get(0).getCellData(row).toString());
        txtSalaryId.setText(columns.get(1).getCellData(row).toString());
        txtSalaryAmountId.setText(columns.get(2).getCellData(row).toString());
        CBMPayM.setValue(columns.get(3).getCellData(row).toString());

    }

    @FXML
    void searchSalaryBtnOnClick(ActionEvent event) {
        String id = txtsearchSalary.getText();

        try {

            ArrayList<AdminSalaryDTO> itSalary = adminSalaryBO.AdminSalarySearch(id);

            for (AdminSalaryDTO e : itSalary){
                COBEmployeEmpId.setValue(e.getEmployId());
                txtSalaryId.setText(e.getSalaryId());
                txtSalaryAmountId.setText(e.getAmount());
                CBMPayM.setValue(e.getPayment());
            }
        } catch (SQLException e) {
            AlertController.animationMesseagewrong("Error", "something went wrong!");
        }
    }





    @FXML
    ////////////////////////////////////////////////////typing keyboard search
    void searchSalaryID(KeyEvent event) throws SQLException {
        String searchValue = txtsearchSalary.getText().trim();

        ArrayList<AdminSalaryDTO> arrayList = adminSalaryBO.AdminSalaryGetAll();
        ObservableList<AdminSalaryTM> obList = FXCollections.observableArrayList();
        for (AdminSalaryDTO a: arrayList) {
            obList.add(new AdminSalaryTM(a.getSalaryId(), a.getEmployId(), a.getAmount(), a.getPayment()));
        }
        if (!searchValue.isEmpty()) {
            ObservableList<AdminSalaryTM> filteredData = obList.filtered(new Predicate<AdminSalaryTM>() {
                @Override
                public boolean test(AdminSalaryTM itemTM) {
                    return String.valueOf(itemTM.getSalaryId()).toLowerCase().contains(searchValue.toLowerCase());
                }
            });
            TBLsalary.setItems(filteredData);
        } else {
            TBLsalary.setItems(obList);
        }

    }
    ////////////////////////////////////////////////////typing keyboard search




    @FXML
    void initialize() throws SQLException {
        onActionGetAllEmployeeaddToSalary();
        CBMPayM.getItems().addAll("Cash", "Card");
        onActionGetAllSallary();
        setCellValuefactory();
        lblInvalidsalary.setVisible(false);
    }



    void onActionGetAllSallary() throws SQLException {

        TBLsalary.getItems().clear();
        try {
            /*Get all items*/
            ArrayList<AdminSalaryDTO> allItems = adminSalaryBO.AdminSalaryGetAll();
            for (AdminSalaryDTO i : allItems) {
                TBLsalary.getItems().add(new AdminSalaryTM(i.getSalaryId(), i.getEmployId(), i.getAmount(), i.getPayment()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    void onActionGetAllEmployeeaddToSalary() {

        try {

            ArrayList<EmployeeDTO> EmpList = adminSalaryBO.GetAllEmployee();
            for (EmployeeDTO e : EmpList) {
                COBEmployeEmpId.getItems().addAll(e.getEmployeeId());
            }

        } catch (SQLException e) {
            AlertController.animationMesseagewrong("Error", "something went wrong!");
        }
    }

    void setCellValuefactory() {
        tabColumEmployeID.setCellValueFactory(new PropertyValueFactory<>("employId"));
        tabColumSalaryID.setCellValueFactory(new PropertyValueFactory<>("salaryId"));
        tabColumSalaryAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        tabColumPaymentMethord.setCellValueFactory(new PropertyValueFactory<>("payment"));
    }

    public void lblClearAllOnAction(ActionEvent actionEvent) {
        COBEmployeEmpId.setValue("");
        txtSalaryId.setText("");
        txtSalaryAmountId.setText("");
        CBMPayM.setValue("");
    }
}
