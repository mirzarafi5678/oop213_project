package com.example.finalproject_oop213.IsratJahan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EmergencySituationController {

    @FXML
    private TextField DetailsTextField;

    @FXML
    private TableView<?> TableView;

    @FXML
    private DatePicker complainDate;

    @FXML
    private TextField complainIDTextField;

    @FXML
    private TextField complainerNameTextField;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private TableColumn<?, ?> detailsColumn;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private TableColumn<?, ?> typeColumn;

    @FXML
    private ComboBox<?> typeComboBox;

    @FXML
    void BackButton(ActionEvent event) {

    }

    @FXML
    void UpdateButton(ActionEvent event) {

    }

    @FXML
    void saveButton(ActionEvent event) {

    }
    @FXML
    void initialize(){

    }

}
