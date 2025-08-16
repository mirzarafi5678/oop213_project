package com.example.finalproject_oop213.IsratJahan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HandleComplainController {

    @FXML
    private TextField compainNumberTextfield;

    @FXML
    private TextField complainDetailsTextField;

    @FXML
    private TextField complainIDFTextField;

    @FXML
    private ComboBox<?> complainTypeTextField;

    @FXML
    private TableColumn<?, ?> detailsColumn;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> messageColumn;

    @FXML
    private Label messageLabel;

    @FXML
    private TableColumn<?, ?> numberColumn;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> typeColumn;

    @FXML
    void addButton(ActionEvent event) {

    }

    @FXML
    void backButton(ActionEvent event) {

    }

    @FXML
    void updateButton(ActionEvent event) {

    }

    @FXML
    void initialize(){

    }

}
