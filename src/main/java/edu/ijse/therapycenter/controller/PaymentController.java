package edu.ijse.therapycenter.controller;

import edu.ijse.therapycenter.bo.BOFactory;
import edu.ijse.therapycenter.bo.custom.impl.PatientBOImpl;
import edu.ijse.therapycenter.bo.custom.impl.PaymentBOImpl;
import edu.ijse.therapycenter.bo.custom.impl.QuoryBOImpl;
import edu.ijse.therapycenter.dto.PaymentDTO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {

    @FXML
    private Button btnProcess;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<PaymentDTO, String> colAmount;

    @FXML
    private TableColumn<PaymentDTO, String> colDate;

    @FXML
    private TableColumn<PaymentDTO, String> colPatient;

    @FXML
    private TableColumn<PaymentDTO, String> colPaymentId;

    @FXML
    private TableColumn<PaymentDTO, String> colSession;

    @FXML
    private DatePicker datePickerPayment;

    @FXML
    private Label errorMessage;

    @FXML
    private Label lblPaymentId;

    @FXML
    private ChoiceBox<String> selectPatient;

    @FXML
    private ChoiceBox<String> selectSession;

    @FXML
    private TableView<PaymentDTO> tblPayments;

    @FXML
    private Label lblAmount;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblSession;

    private final PaymentBOImpl paymentBO = (PaymentBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.PAYMENT);
    private final PatientBOImpl patientBO = (PatientBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.PATIENT);
    private final QuoryBOImpl quoryBO = (QuoryBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.QUARY);

    private ArrayList<String> patientDetails;

    @FXML
    void paymentSelectOnAction(MouseEvent event) {

    }

    @FXML
    void petientSelectOnAction(ActionEvent event) {
        String selectedPatient = selectPatient.getValue();

        patientDetails = quoryBO.getPatientDetails(selectedPatient);

        System.out.println(patientDetails);

        lblAmount.setText(patientDetails.get(3));
        lblSession.setText(patientDetails.get(4));
    }

    @FXML
    void processPayment(ActionEvent event) {
        String paymentId = lblPaymentId.getText();

        String patientId = selectPatient.getValue();

        String sessionId = selectSession.getValue();

        String amount = lblAmount.getText();
        String date = lblDate.getText();


    }

    @FXML
    void resetForm(ActionEvent event) {
        lblPaymentId.setText(paymentBO.getLastPK().orElse("0"));
        selectPatient.setValue(null);
        lblAmount.setText("");
        lblSession.setText("");
        lblDate.setText(LocalDate.now().toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblPaymentId.setText(paymentBO.getLastPK().orElse("0"));

        List<String> patientList = patientBO.patientList();
        selectPatient.getItems().addAll(patientList);
        lblDate.setText(LocalDate.now().toString());

        colPaymentId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));


        loadPatientTable();
    }

    private void loadPatientTable() {
        List<PaymentDTO> paymentList = paymentBO.getAll();
        ObservableList<PaymentDTO> paymentTMS = FXCollections.observableArrayList(paymentList);
        tblPayments.setItems(paymentTMS);
    }
}
