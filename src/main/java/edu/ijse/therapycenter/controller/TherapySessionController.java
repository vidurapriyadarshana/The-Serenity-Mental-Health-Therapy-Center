package edu.ijse.therapycenter.controller;

import edu.ijse.therapycenter.bo.BOFactory;
import edu.ijse.therapycenter.bo.custom.impl.PatientBOImpl;
import edu.ijse.therapycenter.bo.custom.impl.TherapistBOImpl;
import edu.ijse.therapycenter.bo.custom.impl.TherapyProgramBOImpl;
import edu.ijse.therapycenter.bo.custom.impl.TherapySessionBOImpl;
import edu.ijse.therapycenter.dto.PatientDTO;
import edu.ijse.therapycenter.dto.TherapistDTO;
import edu.ijse.therapycenter.dto.TherapyProgramDTO;
import edu.ijse.therapycenter.dto.TherapySessionDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TherapySessionController implements Initializable {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSchedule;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<TherapySessionDTO, String> colDate;

    @FXML
    private TableColumn<TherapySessionDTO, String> colPatient;

    @FXML
    private TableColumn<TherapySessionDTO, String> colProgram;

    @FXML
    private TableColumn<TherapySessionDTO, String> colSessionId;

    @FXML
    private TableColumn<TherapySessionDTO, String> colStatus;

    @FXML
    private TableColumn<TherapySessionDTO, String> colTherapist;

    @FXML
    private TableColumn<TherapySessionDTO, String> colTime;

    @FXML
    private DatePicker datePickerSession;

    @FXML
    private Label errorMessage;

    @FXML
    private Label lblSessionId;

    @FXML
    private ChoiceBox<String> selectPatient;

    @FXML
    private ChoiceBox<String> selectProgram;

    @FXML
    private ChoiceBox<String> selectTherapist;

    @FXML
    private ChoiceBox<String> selectTime;

    @FXML
    private TableView<TherapySessionDTO> tblTherapySessions;

    private final TherapySessionBOImpl therapySessionBO = (TherapySessionBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.THERAPY_SESSION);
    private final PatientBOImpl patientBO = (PatientBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.PATIENT);
    private final TherapistBOImpl therapistBO = (TherapistBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.THERAPIST);
    private final TherapyProgramBOImpl therapyProgramBO = (TherapyProgramBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.THERAPY_PROGRAM);

    private PatientDTO patientDTO = new PatientDTO();
    private TherapistDTO therapistDTO = new TherapistDTO();
    private TherapyProgramDTO therapyProgramDTO = new TherapyProgramDTO();

    @FXML
    void cancelSession(ActionEvent event) {

    }

    @FXML
    void resetForm(ActionEvent event) {
        lblSessionId.setText(therapySessionBO.getLastPK().orElse("1"));
        selectPatient.getSelectionModel().clearSelection();
        selectProgram.getSelectionModel().clearSelection();
        selectTherapist.getSelectionModel().clearSelection();
        selectTime.getSelectionModel().clearSelection();
        datePickerSession.setValue(null);
    }

    @FXML
    void scheduleSession(ActionEvent event) {
        String patientName = selectPatient.getValue();
        String therapistName = selectTherapist.getValue();
        String programName = selectProgram.getValue();

        System.out.println(patientName + therapistName + programName);

        patientDTO = patientBO.getAllPatient(patientName);
        System.out.println(patientDTO);

        therapistDTO = therapistBO.getAllTherapist(therapistName);
        System.out.println(therapistDTO);

        therapyProgramDTO = therapyProgramBO.getAllTherapyProgram(programName);
        System.out.println(therapyProgramDTO);
    }

    @FXML
    void sessionSelectOnAction(MouseEvent event) {

    }

    @FXML
    void updateSession(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblSessionId.setText(therapySessionBO.getLastPK().orElse("1"));

        List<String> patientList = patientBO.patientList();
        List<String> therapistList = therapistBO.therapistList();
        List<String> programList = therapyProgramBO.getProgramList();

        selectPatient.getItems().addAll(patientList);
        selectTherapist.getItems().addAll(therapistList);
        selectProgram.getItems().addAll(programList);

        selectTime.getItems().addAll("08:00 AM", "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM");
    }
}
