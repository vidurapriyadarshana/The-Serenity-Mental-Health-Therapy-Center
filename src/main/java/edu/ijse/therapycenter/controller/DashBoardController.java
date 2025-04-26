package edu.ijse.therapycenter.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {

    @FXML
    private Label patientsCount;

    @FXML
    private Label programsCount;

    @FXML
    private Label sessionsCount;

    @FXML
    private Label therapistsCount;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        patientsCount.setText("10");
        programsCount.setText("5");
        sessionsCount.setText("7");
        therapistsCount.setText("5");
    }
}
