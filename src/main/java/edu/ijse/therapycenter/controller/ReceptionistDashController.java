package edu.ijse.therapycenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ReceptionistDashController {

    @FXML
    private AnchorPane loadPageAnchor;

    @FXML
    void logOut(MouseEvent event) throws IOException {
        Stage stage = (Stage) loadPageAnchor.getScene().getWindow();
        Parent load = FXMLLoader.load((getClass().getResource("/view/LogIn.fxml")));
        stage.setScene(new Scene(load));
        stage.setTitle("Center");
        stage.show();
    }

    @FXML
    void navAppoinments(ActionEvent event) throws IOException {
        loadPageAnchor.getChildren().clear();
        loadPageAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("/view/TherapySession.fxml")));
    }

    @FXML
    void navBilling(ActionEvent event) throws IOException {
        loadPageAnchor.getChildren().clear();
        loadPageAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("/view/Payment.fxml")));
    }

    @FXML
    void navDash(ActionEvent event) throws IOException {
        loadPageAnchor.getChildren().clear();
        loadPageAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("/view/DashBoard.fxml")));
    }

    @FXML
    void navPatitnt(ActionEvent event) throws IOException {
        loadPageAnchor.getChildren().clear();
        loadPageAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("/view/Patient.fxml")));
    }

}
