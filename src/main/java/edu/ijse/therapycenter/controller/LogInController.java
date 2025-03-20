package edu.ijse.therapycenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LogInController {

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Button btSignIn;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    @FXML
    void navHomePage(ActionEvent event) {
        System.out.println("Home Page");
    }

    @FXML
    void navSignUp(MouseEvent event) throws IOException {
        mainAnchor.getChildren().clear();
        mainAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("/view/SignUp.fxml")));
    }

}
