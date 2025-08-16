package com.example.project_individual;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CallRecordController
{
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> CallTypeColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> CallerEmailIDColumn;
    @javafx.fxml.FXML
    private DatePicker CallDate;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> EmergencyCallColumn;
    @javafx.fxml.FXML
    private TextField CallerIDFoield;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> CallDateColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> CallDetailsColumn;
    @javafx.fxml.FXML
    private TextField CallerEmailIDField;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> CallerNameColumn;
    @javafx.fxml.FXML
    private TextField CallerNameField;
    @javafx.fxml.FXML
    private ComboBox<String> CallTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> callerIDColumn;
    @javafx.fxml.FXML
    private TextField CallDetailsField;
    @javafx.fxml.FXML
    private TableView<CallRecord> TableView;
    ArrayList<CallRecord> callList = new ArrayList<>();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @javafx.fxml.FXML
    private RadioButton noRadioButton;
    @javafx.fxml.FXML
    private RadioButton yesRadioButton;

    @javafx.fxml.FXML
    public void initialize() throws IOException, ClassNotFoundException {

        ToggleGroup tg = new ToggleGroup();
        yesRadioButton.setToggleGroup(tg);
        noRadioButton.setToggleGroup(tg);

        callerIDColumn.setCellValueFactory(new PropertyValueFactory<>("callerID"));
        CallerNameColumn.setCellValueFactory(new PropertyValueFactory<>("callerName"));
        CallDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("callDetails"));
        CallerEmailIDColumn.setCellValueFactory(new PropertyValueFactory<>("callerEmailID"));
        EmergencyCallColumn.setCellValueFactory(new PropertyValueFactory<>("emergency"));
        CallTypeColumn.setCellValueFactory(new PropertyValueFactory<>("callType"));
        CallDateColumn.setCellValueFactory(new PropertyValueFactory<>("callDate"));

        CallTypeComboBox.getItems().addAll("Complain","Feedback","Information","Ticket Book","Technical Support");

        File file = new File("callRecord.bin");
        List<CallRecord> list6= PutBinFile.readAllObjects(file);
        TableView.getItems().addAll(list6);
    }

    @javafx.fxml.FXML
    public void deleteButton(ActionEvent actionEvent) {
        TableView.getItems().clear();

    }

    @javafx.fxml.FXML
    public void BackButton(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/AgentDashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) throws IOException {

        boolean digitFound = false;
        for(int i=0; i<CallerNameField.getText().length();i++){
            if(CallerNameField.getText().charAt(i)>='0' && CallerNameField.getText().charAt(i)<='9'){
                digitFound = true;
            }
        }

        boolean DigitFound = false;
        for(int i=0; i<CallerEmailIDField.getText().length();i++){
            if(CallerEmailIDField.getText().charAt(i)>='0' && CallerEmailIDField.getText().charAt(i)<='9'){
                DigitFound = true;
            }
        }

        boolean digitFound2 = false;
        for(int i=0; i<CallDetailsField.getText().length();i++){
            if(CallDetailsField.getText().charAt(i)>='0' && CallDetailsField.getText().charAt(i)<='9'){
                digitFound2 = true;
            }
        }

        if(CallDetailsField.getText().isEmpty() || CallerNameField.getText().isEmpty() || digitFound ||
                CallDate.getValue().isAfter(LocalDate.now())|| digitFound2 || DigitFound
                 || CallerEmailIDField.getText().isEmpty()||CallerIDFoield.getText().isEmpty()){
            alert.setContentText("Fill up the form properly.");
            alert.setContentText("-fx-border-color: red");
        }
        else {
            String selectEmergency = "";
            if(yesRadioButton.isSelected()){
                selectEmergency = "YES";
            }
            else{
                selectEmergency = "NO";
            }

            CallRecord CallRecordAdd = new CallRecord(
                    Integer.parseInt(CallerIDFoield.getText()),
                    CallerNameField.getText(),
                    CallDetailsField.getText(),
                    CallerEmailIDField.getText(),
                    selectEmergency,
                    CallTypeComboBox.getValue(),
                    CallDate.getValue());


            TableView.getItems().add(CallRecordAdd);
            callList.add(CallRecordAdd);



            alert.setContentText("Call Record Data Added ");

            CallerNameField.clear();
            CallerIDFoield.clear();
            CallDetailsField.clear();
            yesRadioButton.setSelected(false);
            noRadioButton.setSelected(false);
            CallerEmailIDField.clear();

            File CallRecordFile = new File("callRecord.bin");
            PutBinFile.saveObject(CallRecordFile,CallRecordAdd);
        }

    }
}