package edu.ijse.therapycenter.controller;

import edu.ijse.therapycenter.bo.BOFactory;
import edu.ijse.therapycenter.bo.custom.impl.PatientBOImpl;
import edu.ijse.therapycenter.dto.PatientDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
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
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colGender;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colRegDate;

    @FXML
    private DatePicker dpRegDate;

    @FXML
    private Label lblPatientId;

    @FXML
    private TableView<?> tblPatients;

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
        String gender = cmbGender.getValue();
        String regDate = dpRegDate.getValue().toString();

        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(id);
        patientDTO.setName(name);
        patientDTO.setContactInfo(contact);
        patientDTO.setGender(gender);
        patientDTO.setBirthDate(regDate);

        boolean isSaved = patientBO.save(patientDTO);

        if (isSaved) {
            System.out.println("Patient saved successfully");
        } else {
            System.out.println("Failed to save patient");
        }
    }

    @FXML
    void deletePatient(ActionEvent event) {

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
    }
}
