package com.example.project_individual;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FeedbackController
{
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> CallerNameColumn;
    @javafx.fxml.FXML
    private ComboBox<String> CallTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> CallTypeColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> detailsColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> EmailIDColumn;
    @javafx.fxml.FXML
    private TableView<CallRecord> tableView;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> emergencyColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> CallDateColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> CallerIDColumn;
    ArrayList<CallRecord> feedbackList = new ArrayList<>();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @javafx.fxml.FXML
    public void initialize() throws IOException, ClassNotFoundException {

        CallerIDColumn.setCellValueFactory(new PropertyValueFactory<>("callerID"));
        CallerNameColumn.setCellValueFactory(new PropertyValueFactory<>("callerName"));
        detailsColumn.setCellValueFactory(new PropertyValueFactory<>("callDetails"));
        EmailIDColumn.setCellValueFactory(new PropertyValueFactory<>("callerEmailID"));
        emergencyColumn.setCellValueFactory(new PropertyValueFactory<>("emergency"));
        CallTypeColumn.setCellValueFactory(new PropertyValueFactory<>("callType"));
        CallDateColumn.setCellValueFactory(new PropertyValueFactory<>("callDate"));

        CallTypeComboBox.getItems().addAll("Complain","Feedback","Information","Ticket Book","Technical Support");

        File file = new File("callRecord.bin");
        List<CallRecord> list6= PutBinFile.readAllObjects(file);
        feedbackList.addAll(list6);
        tableView.getItems().addAll(list6);
    }

    @javafx.fxml.FXML
    public void BackButton(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/AgentDashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void updateButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        String a = CallTypeComboBox.getValue();
        for(CallRecord s: feedbackList){
            if(s.getCallType().equals(a)){
                tableView.getItems().add(s);
            }
        }
    }
}