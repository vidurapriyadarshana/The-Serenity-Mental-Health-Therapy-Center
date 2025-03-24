//package edu.ijse.therapycenter.controller;
//
//import edu.ijse.therapycenter.bo.BOFactory;
//import edu.ijse.therapycenter.bo.custom.impl.PatientBOImpl;
//import edu.ijse.therapycenter.dto.PatientDTO;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//import java.awt.event.MouseEvent;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//
//public class PatientController implements Initializable {
//
//    @FXML
//    private Button btnAdd;
//
//    @FXML
//    private Button btnDelete;
//
//    @FXML
//    private Button btnReset;
//
//    @FXML
//    private Button btnUpdate;
//
//    @FXML
//    private ComboBox<String> cmbGender;
//
//    @FXML
//    private TableColumn<PatientDTO, String> colContact;
//
//    @FXML
//    private TableColumn<PatientDTO, String> colGender;
//
//    @FXML
//    private TableColumn<PatientDTO, String> colId;
//
//    @FXML
//    private TableColumn<PatientDTO, String> colName;
//
//    @FXML
//    private TableColumn<PatientDTO, String> colRegDate;
//
//    @FXML
//    private DatePicker dpRegDate;
//
//    @FXML
//    private Label lblPatientId;
//
//    @FXML
//    private TableView<PatientDTO> tblPatients;
//
//    @FXML
//    private TextField txtContact;
//
//    @FXML
//    private TextField txtName;
//
//    @FXML
//    private Label errorMessage;
//
//    private final PatientBOImpl patientBO = (PatientBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.PATIENT);
//    private String id;
//
//    @FXML
//    void addPatient(ActionEvent event) {
//
//        String id = this.id;
//
//        String name = txtName.getText();
//
//        String contact = txtContact.getText();
//        String regex = "^07\\d{8}$";
//
//        String gender = cmbGender.getValue();
//
//        String regDate = dpRegDate.getValue().toString();
//
//        if(name.isEmpty() || contact.isEmpty() || gender.isEmpty() || regDate.isEmpty()){
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText(null);
//            alert.setContentText("Please fill all the fields");
//            alert.show();
//            return;
//        }
//
//        if (contact.matches(regex)) {
//            System.out.println("Valid contact number: " + contact);
//        } else {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText(null);
//            alert.setContentText("Invalid contact number");
//            alert.show();
//            return;
//        }
//
//
//        PatientDTO patientDTO = new PatientDTO();
//        patientDTO.setId(id);
//        patientDTO.setName(name);
//        patientDTO.setContactInfo(contact);
//        patientDTO.setGender(gender);
//        patientDTO.setBirthDate(regDate);
//
//        boolean isSaved = patientBO.save(patientDTO);
//
//        if (isSaved) {
//            txtName.clear();
//            txtContact.clear();
//            cmbGender.setValue(null);
//            dpRegDate.setValue(null);
//            this.id = String.valueOf(patientBO.getLastPK().orElse("Error"));
//        } else {
//            System.out.println("Failed to save patient");
//        }
//
//    }
//
//    @FXML
//    void deletePatient(ActionEvent event) {
//
//    }
//
//    @FXML
//    void resetForm(ActionEvent event) {
//
//    }
//
//    @FXML
//    void updatePatient(ActionEvent event) {
//
//    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        cmbGender.getItems().addAll("Male", "Female");
//        this.id = String.valueOf(patientBO.getLastPK().orElse("Error"));
//        lblPatientId.setText(id);
//
////        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
////        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
////        colContact.setCellValueFactory(new PropertyValueFactory<>("contactInfo"));
////        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
////        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
////        colRegDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
//
//    }
//
//    @FXML
//    void petientSelectOnAction(MouseEvent event) {
//
//    }
//
//}

package edu.ijse.therapycenter.controller;

import edu.ijse.therapycenter.bo.BOFactory;
import edu.ijse.therapycenter.bo.custom.impl.PatientBOImpl;
import edu.ijse.therapycenter.dto.PatientDTO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class PatientController implements Initializable {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<String> cmbGender;

    @FXML
    private TableColumn<PatientDTO, String> colContact;

    @FXML
    private TableColumn<PatientDTO, String> colGender;

    @FXML
    private TableColumn<PatientDTO, String> colId;

    @FXML
    private TableColumn<PatientDTO, String> colName;

    @FXML
    private TableColumn<PatientDTO, String> colRegDate;

    @FXML
    private DatePicker dpRegDate;

    @FXML
    private Label errorMessage;

    @FXML
    private Label lblPatientId;

    @FXML
    private TableView<PatientDTO> tblPatients;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtName;

    private final PatientBOImpl patientBO = (PatientBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.PATIENT);
    private String id;

    @FXML
    void addPatient(ActionEvent event) {
        String id = this.id;

        String name = txtName.getText();

        String contact = txtContact.getText();
        String regex = "^07\\d{8}$";

        String gender = cmbGender.getValue();

        String regDate = dpRegDate.getValue().toString();

        if(name.isEmpty() || contact.isEmpty() || gender.isEmpty() || regDate.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the fields");
            alert.show();
            return;
        }

        if (contact.matches(regex)) {
            System.out.println("Valid contact number: " + contact);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid contact number");
            alert.show();
            return;
        }


        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(id);
        patientDTO.setName(name);
        patientDTO.setContactInfo(contact);
        patientDTO.setGender(gender);
        patientDTO.setBirthDate(regDate);

        boolean isSaved = patientBO.save(patientDTO);

        if (isSaved) {
            txtName.clear();
            txtContact.clear();
            cmbGender.setValue(null);
            dpRegDate.setValue(null);
            this.id = String.valueOf(patientBO.getLastPK().orElse("Error"));
        } else {
            System.out.println("Failed to save patient");
        }

    }

    @FXML
    void deletePatient(ActionEvent event) {

    }

    @FXML
    void petientSelectOnAction(MouseEvent event) {
        PatientDTO selectedPatient = tblPatients.getSelectionModel().getSelectedItem();

        if (selectedPatient != null) {
            lblPatientId.setText(selectedPatient.getId());
            txtName.setText(selectedPatient.getName());
            txtContact.setText(selectedPatient.getContactInfo());
            cmbGender.setValue(selectedPatient.getGender());

            if (selectedPatient.getBirthDate() != null) {
                dpRegDate.setValue(LocalDate.parse(selectedPatient.getBirthDate()));
            }
        }
    }


    @FXML
    void resetForm(ActionEvent event) {

    }

    @FXML
    void updatePatient(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbGender.getItems().addAll("Male", "Female");
        this.id = String.valueOf(patientBO.getLastPK().orElse("Error"));
        lblPatientId.setText(id);



        colId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        colContact.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContactInfo()));
        colGender.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGender()));
        colRegDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBirthDate()));


        loadPatientTable();
    }

    private void loadPatientTable() {

        List<PatientDTO> patientList = patientBO.getAll();

        for (PatientDTO patient : patientList) {
            System.out.println("ID: " + patient.getId());
            System.out.println("Name: " + patient.getName());
            System.out.println("Contact Info: " + patient.getContactInfo());
            System.out.println("Gender: " + patient.getGender());
            System.out.println("Birth Date: " + patient.getBirthDate());
            System.out.println("-------------------------------");
        }

        ObservableList<PatientDTO> patientTMS = FXCollections.observableArrayList(patientList);

        tblPatients.setItems(patientTMS);
    }



}
