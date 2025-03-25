package edu.ijse.therapycenter.controller;

import edu.ijse.therapycenter.bo.BOFactory;
import edu.ijse.therapycenter.bo.custom.impl.TherapistBOImpl;
import edu.ijse.therapycenter.bo.custom.impl.TherapyProgramBOImpl;
import edu.ijse.therapycenter.dto.PatientDTO;
import edu.ijse.therapycenter.dto.TherapyProgramDTO;
import edu.ijse.therapycenter.entity.TherapyProgram;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class TherapyProgramController implements Initializable {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<TherapyProgramDTO, String> colDuration;

    @FXML
    private TableColumn<TherapyProgramDTO, Double> colFee;

    @FXML
    private TableColumn<TherapyProgramDTO, String> colName;

    @FXML
    private TableColumn<TherapyProgramDTO, String> colProgramId;

    @FXML
    private Label errorMessage;

    @FXML
    private Label lblProgramId;

    @FXML
    private TableView<TherapyProgramDTO> tblTherapyPrograms;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtFee;

    @FXML
    private TextField txtName;

    @FXML
    private ChoiceBox<String> selectTime;

    private String id;

    private final TherapyProgramBOImpl therapyProgramBO = (TherapyProgramBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.THERAPY_PROGRAM);

    @FXML
    void addTherapyProgram(ActionEvent event) {
        String id = this.id;
        String name = txtName.getText();
        String duration = txtDuration.getText() + " " + selectTime.getValue();
        String fee = txtFee.getText();

        if(name.isEmpty() || duration.isEmpty() || fee.isEmpty()){
            errorMessage.setText("Please fill all fields");
            return;
        }

        TherapyProgramDTO therapyProgramDTO = new TherapyProgramDTO();
        therapyProgramDTO.setProgramId(id);
        therapyProgramDTO.setName(name);
        therapyProgramDTO.setDuration(duration);
        therapyProgramDTO.setFee(Double.parseDouble(fee));

        boolean isAdded = therapyProgramBO.save(therapyProgramDTO);

        if(isAdded){
            errorMessage.setText("Therapy Program added successfully");
            this.id = therapyProgramBO.getLastPK().orElse("0");
            lblProgramId.setText(this.id);
            txtName.clear();
            txtDuration.clear();
            txtFee.clear();
        }else{
            errorMessage.setText("Failed to add Therapy Program");
        }
    }

    @FXML
    void deleteTherapyProgram(ActionEvent event) {

    }

    @FXML
    void resetForm(ActionEvent event) {
        txtName.clear();
        txtDuration.clear();
        txtFee.clear();
        errorMessage.setText("");
        selectTime.setValue(null);
        lblProgramId.setText(this.id);
    }

    @FXML
    void therapyProgramSelectOnAction(MouseEvent event) {
        TherapyProgramDTO selectedPatient = tblTherapyPrograms.getSelectionModel().getSelectedItem();
        if (selectedPatient != null) {
            lblProgramId.setText(selectedPatient.getProgramId());
            txtName.setText(selectedPatient.getName());


            String duration = selectedPatient.getDuration();
            String[] parts = duration.split(" ");
            txtDuration.setText(parts[0]);
            selectTime.setValue(parts[1]);
            txtFee.setText(String.valueOf(selectedPatient.getFee()));
        }
    }

    @FXML
    void updateTherapyProgram(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectTime.getItems().addAll("Weeks", "Months", "Years");

        this.id = therapyProgramBO.getLastPK().orElse("0");
        lblProgramId.setText(this.id);

        colProgramId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProgramId()));
        colName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        colDuration.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDuration()));
        colFee.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getFee()));

        loadTherapyProgramTable();
    }

    private void loadTherapyProgramTable() {
        List<TherapyProgramDTO> therapyProgramList = therapyProgramBO.getAll();
        ObservableList<TherapyProgramDTO> therapyProgramTMS = FXCollections.observableArrayList(therapyProgramList);
        tblTherapyPrograms.setItems(therapyProgramTMS);
    }

}
