package edu.ijse.therapycenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LogInController {

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
    void navSignUp(MouseEvent event) {
        System.out.println("Sign Up");
    }

}
