package edu.ijse.therapycenter.controller;

import edu.ijse.therapycenter.bo.BOFactory;
import edu.ijse.therapycenter.bo.custom.impl.UserBOImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
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
    private AnchorPane mainAnchor;

    @FXML
    private PasswordField txtConfirmPassword;

    @FXML
    private Text txtDisplayUserID;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    private final UserBOImpl userBO = (UserBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.USER);

    @FXML
    void navLogInPage(MouseEvent event) throws IOException {
        mainAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("/view/LogIn.fxml")));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceRole.getItems().addAll("Admin", "Receptionist");

        String lastPK = userBO.getLastPK().orElse("U001");
        lblID.setText(lastPK);
    }
}
