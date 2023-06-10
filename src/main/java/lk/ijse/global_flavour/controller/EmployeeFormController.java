//all added

package lk.ijse.global_flavour.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import lk.ijse.global_flavour.bo.BOFactory;
import lk.ijse.global_flavour.bo.custom.EmployeeBO;
import lk.ijse.global_flavour.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.global_flavour.dto.EmployeeDTO;
import lk.ijse.global_flavour.view.tdm.EmployeeTM;
import lk.ijse.global_flavour.util.AlertController;
import lk.ijse.global_flavour.util.ValidateField;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

public class EmployeeFormController {


    @FXML
    private JFXTextField txtEmpId;

    @FXML
    private JFXTextField txtEmpName;

    @FXML
    private JFXTextField txtEmpNic;

    @FXML
    private DatePicker txtEmpDOBBox;

    @FXML
    private JFXTextField txtEmpJobTitle;

    @FXML
    private JFXTextField txtEmpContact;

    @FXML
    private JFXTextField txtEmpAddress;

    @FXML
    private Label lblInvalidContactNo;

    @FXML
    private Label lblInvalidEmail;

    @FXML
    private Label lblInvalidNicNo1;

    @FXML
    private JFXTextField txtEmpEmail;

    @FXML
    private TableView<EmployeeTM> tablEmplyee;


    @FXML
    private TableColumn<?, ?> tablEmployeeID;

    @FXML
    private TableColumn<?, ?> tablEmployeeName;

    @FXML
    private TableColumn<?, ?> tablEmployeeNIC;

    @FXML
    private TableColumn<?, ?> tablEmployeeDOB;

    @FXML
    private TableColumn<?, ?> tablEmployeeJT;

    @FXML
    private TableColumn<?, ?> tablEmployeeContact;

    @FXML
    private TableColumn<?, ?> tablEmployeeAddrsss;

    @FXML
    private TableColumn<?, ?> tablEmployeemail;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnSave;

    @FXML
    private Button searchBtn;

    @FXML
    private TextField txtsearchEmployee;

    @FXML
    private Label lblInvalidEmployeeId;

    @FXML
    void txtContactNumberOnMouseClick(MouseEvent event) {
        lblInvalidContactNo.setVisible(false);
    }

    @FXML
    void txtEmployeeNicOnMouseClick(MouseEvent event) {

        lblInvalidNicNo1.setVisible(false);
    }

    @FXML
    void txtemailOnMouseClick(MouseEvent event) {

        lblInvalidEmail.setVisible(false);
    }

    //all added
    //used admin EmployeeDAO object create EmployeeDAOImpl

    //EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    //use bo
    //only added EmployeeBOImpl

    EmployeeBO employeeBO = BOFactory.getBOFactory().getBO(BOFactory.BOType.EMPLOYEE);

    @FXML
    void buttonSaveOnACT(ActionEvent actionEvent) {

        if(txtEmpName.getText().isEmpty() || txtEmpJobTitle.getText().isEmpty() || txtEmpAddress.getText().isEmpty()){
            AlertController.animationMesseagewrong("Error","Employee details not saved. \nPlease make sure to fill the request fields.");
        }else {

            if(ValidateField.employeeCheck(txtEmpId.getText()) ||ValidateField.nicCheck(txtEmpNic.getText()) || ValidateField.contactCheck(txtEmpContact.getText()) ||ValidateField.emailCheck(txtEmpEmail.getText())){
                if(ValidateField.emailCheck(txtEmpEmail.getText())){
                    if(ValidateField.contactCheck(txtEmpContact.getText())){
                        if(ValidateField.nicCheck(txtEmpNic.getText())){
                            if(ValidateField.employeeCheck(txtEmpId.getText())){
                                lblInvalidEmployeeId.setVisible(false);


                                String employeeId = txtEmpId.getText();
                                String employeeName = txtEmpName.getText();
                                String employeeNic = txtEmpNic.getText();
                                String employeeDOB = String.valueOf(txtEmpDOBBox.getValue());
                                String employeeJobTittle = txtEmpJobTitle.getText();
                                String employeeContact = txtEmpContact.getText();
                                String employeeAddress = txtEmpAddress.getText();
                                String employeeEmail = txtEmpEmail.getText();

                                EmployeeDTO cus = new EmployeeDTO(employeeId, employeeName, employeeAddress, employeeDOB,employeeContact,employeeEmail,employeeNic,employeeJobTittle);

                                try {
                                    boolean isSaved = employeeBO.saveEmployee(cus);
                                    if (isSaved) {
                                        AlertController.animationMesseageCorect("CONFIRMATION","Employee Save Success!");
                                        onActionGetAllEmployee();

                                    }
                                } catch (SQLException e) {
                                    System.out.println(e);
                                    AlertController.animationMesseagewrong("Error","Duplicate nic or contactNo!");
                                }

                            }else {
                                lblInvalidEmployeeId.setVisible(true);
                            }
                        }else {
                            lblInvalidNicNo1.setVisible(true);
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
                lblInvalidNicNo1.setVisible(true);
                lblInvalidEmployeeId.setVisible(true);

            }
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        if(txtEmpId.getText().isEmpty() || txtEmpName.getText().isEmpty() || txtEmpJobTitle.getText().isEmpty() || txtEmpAddress.getText().isEmpty()){
            AlertController.animationMesseagewrong("Error","Employee details not updated. \nPlease make sure to fill the request fields.");
        }else {

            if(ValidateField.nicCheck(txtEmpNic.getText()) || ValidateField.contactCheck(txtEmpContact.getText()) ||ValidateField.emailCheck(txtEmpEmail.getText())){
                if(ValidateField.emailCheck(txtEmpEmail.getText())){
                    if(ValidateField.contactCheck(txtEmpContact.getText())){
                        if(ValidateField.nicCheck(txtEmpNic.getText())){

                            String employeeId12 = txtEmpId.getText();
                            String name = txtEmpName.getText();
                            String address = txtEmpAddress.getText();
                            String dOB = String.valueOf(txtEmpDOBBox.getValue());
                            String contact = txtEmpContact.getText();
                            String email = txtEmpEmail.getText();
                            String nic = txtEmpNic.getText();
                            String jobTittle = txtEmpJobTitle.getText();

                            EmployeeDTO employeeDTO = new EmployeeDTO(employeeId12, name, address, dOB, contact, email, nic, jobTittle);
                            try {

                                boolean isUpdated = employeeBO.updateEmployee(employeeDTO);
                                AlertController.animationMesseageCorect("CONFIRMATION","Employee updated!");
                                onActionGetAllEmployee();
                            } catch (SQLException | ClassNotFoundException e) {
                                e.printStackTrace();
                                AlertController.animationMesseagewrong("Error","something went wrong!");
                            }
                        }else {
                            lblInvalidNicNo1.setVisible(true);
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
                lblInvalidNicNo1.setVisible(true);
            }
        }


    }

    @FXML
    public void btnDeleteOnAction(ActionEvent actionEvent) {

        if(txtEmpId.getText().isEmpty()){

        }else {
            boolean ok = AlertController.okconfirmmessage("Are you Sure.\nDo you wont Delete item");

            if(ok){
                String code = txtEmpId.getText();

                try {
                    boolean isDeleted = employeeBO.deleteEmployee(code);
                    if (isDeleted) {
                        AlertController.animationMesseageCorect("CONFIRMATION","Delete Success!");
                        onActionGetAllEmployee();
                    }
                } catch (SQLException e) {
                    AlertController.animationMesseagewrong("Error","something went wrong!");
                }
            }
        }
    }

    @FXML
    void searchBtnOnClick(ActionEvent event) {
        String empid = txtsearchEmployee.getText();

        try {
            ArrayList<EmployeeDTO> arrayList = employeeBO.searchEmployee(empid);

            for (EmployeeDTO cust: arrayList){
                tablEmplyee.getItems().add(new EmployeeTM(cust.getEmployeeId(), cust.getEmployeeName(), cust.getAddress(), cust.getDOB(),cust.getCotactNo(),cust.getEmail(),cust.getNic(),cust.getJobTittle()));
            }

        } catch (SQLException e) {
            AlertController.animationMesseagewrong("Error","something went wrong!");
        }
    }

    @FXML
    void employeeMarkOnMouse(MouseEvent event) {
        TablePosition pos=tablEmplyee.getSelectionModel().getSelectedCells().get(0);
        int row=pos.getRow();

        ObservableList<TableColumn<EmployeeTM,?>> columns=tablEmplyee.getColumns();

        txtEmpId.setText(columns.get(0).getCellData(row).toString());
        txtEmpName.setText(columns.get(1).getCellData(row).toString());
        txtEmpNic.setText(columns.get(2).getCellData(row).toString());
        txtEmpDOBBox.setValue(LocalDate.parse(columns.get(3).getCellData(row).toString()));
        txtEmpJobTitle.setText(columns.get(4).getCellData(row).toString());
        txtEmpContact.setText(columns.get(5).getCellData(row).toString());
        txtEmpAddress.setText(columns.get(6).getCellData(row).toString());
        txtEmpEmail.setText(columns.get(7).getCellData(row).toString());

    }

    @FXML
    void OnActionIDEmplye(ActionEvent event) {
        String empid = txtEmpId.getText();

        try {
            ArrayList<EmployeeDTO> arrayList = employeeBO.searchEmployee(empid);
            for (EmployeeDTO cust : arrayList){
                tablEmplyee.getItems().add(new EmployeeTM(cust.getEmployeeId(), cust.getEmployeeName(), cust.getAddress(), cust.getDOB(),cust.getCotactNo(),cust.getEmail(),cust.getNic(),cust.getJobTittle()));
                System.out.println(cust.getDOB());
            }
        } catch (SQLException e) {
            AlertController.animationMesseagewrong("Error","something went wrong!");
        }
    }

    //////////////////////////////////////////////////////

    @FXML
    void searchEmployeeID(KeyEvent event) throws SQLException {

        String searchValue=txtsearchEmployee.getText().trim();
        ArrayList<EmployeeDTO> obList=employeeBO.getAllEmployee();
        ObservableList<EmployeeTM> observableList = FXCollections.observableArrayList();
        for (EmployeeDTO e : obList) {
            observableList.add(new EmployeeTM(e.getEmployeeId(), e.getEmployeeName(), e.getAddress(), e.getDOB(), e.getCotactNo(), e.getEmail(), e.getNic(), e.getJobTittle()));
        }

        if (!searchValue.isEmpty()) {
            ObservableList<EmployeeTM> filteredData = observableList.filtered(new Predicate<EmployeeTM>(){
                @Override
                public boolean test(EmployeeTM employeetm) {
                    return String.valueOf(employeetm.getEmployeeId()).toLowerCase().contains(searchValue.toLowerCase());        }
            });
            tablEmplyee.setItems(filteredData);} else {
            tablEmplyee.setItems(observableList);
        }
    }

    //////////////////////////////////////////////////

    @FXML
    void initialize() {
        setCellValuefactory();
        onActionGetAllEmployee();
        lblInvalidContactNo.setVisible(false);
        lblInvalidEmail.setVisible(false);
        lblInvalidNicNo1.setVisible(false);
        lblInvalidEmployeeId.setVisible(false);
    }

    void setCellValuefactory(){
        tablEmployeeID.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        tablEmployeeName.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        tablEmployeeNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        tablEmployeeDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        tablEmployeeJT.setCellValueFactory(new PropertyValueFactory<>("jobTittle"));
        tablEmployeeContact.setCellValueFactory(new PropertyValueFactory<>("cotactNo"));
        tablEmployeeAddrsss.setCellValueFactory(new PropertyValueFactory<>("address"));
        tablEmployeemail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    void onActionGetAllEmployee() {
        tablEmplyee.getItems().clear();
        try {
            ArrayList<EmployeeDTO> EmpList = employeeBO.getAllEmployee();

            for (EmployeeDTO cust :EmpList) {
                tablEmplyee.getItems().add(new EmployeeTM(cust.getEmployeeId(), cust.getEmployeeName(), cust.getAddress(), cust.getDOB(),cust.getCotactNo(),cust.getEmail(),cust.getNic(),cust.getJobTittle()));
            }

        } catch (SQLException e) {
            AlertController.animationMesseagewrong("Error","something went wrong!");
        }
    }

    public void lblClearAllOnAction(ActionEvent actionEvent) {
        txtEmpId.setText("");
        txtEmpName.setText("");
        txtEmpAddress.setText("");

        txtEmpContact.setText("");
        txtEmpEmail.setText("");
        txtEmpNic.setText("");
        txtEmpJobTitle.setText("");
        txtEmpDOBBox.setValue(null);

    }
}
