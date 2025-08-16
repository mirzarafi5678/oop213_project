package com.example.project_individual;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmergencySituationController
{
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> CallerNameColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> DetailsColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> CallTypeColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> CallerEmailIDColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> EmergencyColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> CalldateColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> CallerIDColumn;
    @javafx.fxml.FXML
    private TableView<CallRecord> TableView;

    ArrayList<CallRecord> emergencylist = new ArrayList<>();
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

        CallerIDColumn.setCellValueFactory(new PropertyValueFactory<>("callerID"));
        CallerNameColumn.setCellValueFactory(new PropertyValueFactory<>("callerName"));
        DetailsColumn.setCellValueFactory(new PropertyValueFactory<>("callDetails"));
        CallerEmailIDColumn.setCellValueFactory(new PropertyValueFactory<>("callerEmailID"));
        EmergencyColumn.setCellValueFactory(new PropertyValueFactory<>("emergency"));
        CallTypeColumn.setCellValueFactory(new PropertyValueFactory<>("callType"));
        CalldateColumn.setCellValueFactory(new PropertyValueFactory<>("callDate"));



        File file = new File("callRecord.bin");
        List<CallRecord> list6= PutBinFile.readAllObjects(file);
        emergencylist.addAll(list6);
        TableView.getItems().addAll(list6);
    }

    @javafx.fxml.FXML
    public void UpdateButton(ActionEvent actionEvent) {
        TableView.getItems().clear();
         String selectEmergency = "";
        if(yesRadioButton.isSelected()){
            selectEmergency = "YES";
        }
        else{
            selectEmergency = "NO";
        }



        for(CallRecord s: emergencylist){
            if(s.getCallType().equals(selectEmergency) ){
                TableView.getItems().addAll(s);
            }
        }

    }

    @javafx.fxml.FXML
    public void BackButton(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/AgentDashboard.fxml",actionEvent);
    }
}