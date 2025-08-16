package com.example.project_individual;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TechnicalsupportController
{
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> DetailsColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> CallTypeColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> nameColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> EmergencyColumn;
    @javafx.fxml.FXML
    private TableView<CallRecord> tableView;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> dateColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> emailIdColumn;
    @javafx.fxml.FXML
    private ComboBox<String> CalltypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> idColumn;
    ArrayList<CallRecord> technicalIssueList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() throws IOException, ClassNotFoundException {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("callerID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("callerName"));
        DetailsColumn.setCellValueFactory(new PropertyValueFactory<>("callDetails"));
        emailIdColumn.setCellValueFactory(new PropertyValueFactory<>("callerEmailID"));
        EmergencyColumn.setCellValueFactory(new PropertyValueFactory<>("emergency"));
        CallTypeColumn.setCellValueFactory(new PropertyValueFactory<>("callType"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("callDate"));

        CalltypeComboBox.getItems().addAll("Complain","Feedback","Information","Ticket Book","Technical Support");

        File file = new File("callRecord.bin");
        List<CallRecord> list6= PutBinFile.readAllObjects(file);
        technicalIssueList.addAll(list6);
        tableView.getItems().addAll(list6);
    }

    @javafx.fxml.FXML
    public void UpdateButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        String a = CalltypeComboBox.getValue();
        for(CallRecord s: technicalIssueList){
            if(s.getCallType().equals(a)){
                tableView.getItems().add(s);
            }
        }
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/AgentDashboard.fxml",actionEvent);
    }
}