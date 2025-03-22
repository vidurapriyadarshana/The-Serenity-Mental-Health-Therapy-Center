package edu.ijse.therapycenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TherapistManagementController {

    @FXML
    private TableColumn<?, ?> colActions;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colSessions;

    @FXML
    private TableColumn<?, ?> colSpecialization;

    @FXML
    private ComboBox<?> comboFilter;

    @FXML
    private TableView<?> tableTherapists;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSearch;

    @FXML
    private TextField txtSpecialization;

    @FXML
    void handleAdd(ActionEvent event) {

    }

    @FXML
    void handleClear(ActionEvent event) {

    }

    @FXML
    void handleSave(ActionEvent event) {

    }

}
