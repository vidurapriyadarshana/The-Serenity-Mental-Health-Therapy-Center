package edu.ijse.therapycenter.controller;

import edu.ijse.therapycenter.Initializer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private Button btSignUp;

    @FXML
    private ChoiceBox<String> choiceRole;

    @FXML
    private Text lblID;

    @FXML
    private TextField txtConfirmPassword;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void navLogInPage(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceRole.getItems().addAll("Admin", "Receptionist");
    }
}
