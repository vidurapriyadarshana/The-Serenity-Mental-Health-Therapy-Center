package edu.ijse.therapycenter.controller;

import edu.ijse.therapycenter.bo.BOFactory;
import edu.ijse.therapycenter.bo.custom.impl.TherapistBOImpl;
import edu.ijse.therapycenter.bo.custom.impl.TherapyProgramBOImpl;
import edu.ijse.therapycenter.entity.TherapyProgram;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
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
    private TableColumn<TherapyProgram, String> colDuration;

    @FXML
    private TableColumn<TherapyProgram, String> colFee;

    @FXML
    private TableColumn<TherapyProgram, String> colName;

    @FXML
    private TableColumn<TherapyProgram, Double> colProgramId;

    @FXML
    private Label errorMessage;

    @FXML
    private Label lblProgramId;

    @FXML
    private TableView<TherapyProgram> tblTherapyPrograms;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtFee;

    @FXML
    private TextField txtName;

    private String id;

    private final TherapyProgramBOImpl therapyProgramBO = (TherapyProgramBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.THERAPY_PROGRAM);

    @FXML
    void addTherapyProgram(ActionEvent event) {

    }

    @FXML
    void deleteTherapyProgram(ActionEvent event) {

    }

    @FXML
    void resetForm(ActionEvent event) {

    }

    @FXML
    void therapyProgramSelectOnAction(MouseEvent event) {

    }

    @FXML
    void updateTherapyProgram(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.id = therapyProgramBO.getLastPK().orElse("0");
        lblProgramId.setText(this.id);
    }
}
