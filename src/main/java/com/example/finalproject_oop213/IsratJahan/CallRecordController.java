package com.example.finalproject_oop213.IsratJahan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CallRecordController {

    @FXML
    private DatePicker DateOFComplain;

    @FXML
    private TableColumn<?, ?> IDColumn;

    @FXML
    private TextField NumberOfComplainText;

    @FXML
    private TableView<?> TableView;

    @FXML
    private TextField complainDetailsText;

    @FXML
    private TextField complainerIDTextField;

    @FXML
    private TextField complainerNameTextField;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private TableColumn<?, ?> detailsColumn;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    void BackButton(ActionEvent event) {

    }

    @FXML
    void exportPDFButton(ActionEvent event) {

    }

    @FXML
    void saveButton(ActionEvent event) {

    }

    @FXML
    void initialize(){

    }

}
