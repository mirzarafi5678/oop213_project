package com.example.project_individual;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HandleComplainController
{
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> emailIDColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> DetailsColumn;
    @javafx.fxml.FXML
    private ComboBox<String> CallTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> nameColumn;
    @javafx.fxml.FXML
    private TableView<CallRecord> tableView;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> dateColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> callTypeColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> emergencyColumn;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> idColumn;
    ArrayList<CallRecord> complainList = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() throws IOException, ClassNotFoundException {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("callerID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("callerName"));
        DetailsColumn.setCellValueFactory(new PropertyValueFactory<>("callDetails"));
        emailIDColumn.setCellValueFactory(new PropertyValueFactory<>("callerEmailID"));
        emergencyColumn.setCellValueFactory(new PropertyValueFactory<>("emergency"));
        callTypeColumn.setCellValueFactory(new PropertyValueFactory<>("callType"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("callDate"));

        CallTypeComboBox.getItems().addAll("Complain","Feedback","Information","Ticket Book","Technical Support");

        File file = new File("callRecord.bin");
        List<CallRecord> list6= PutBinFile.readAllObjects(file);
        complainList.addAll(list6);
        tableView.getItems().addAll(list6);
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/AgentDashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void updateButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        String a = CallTypeComboBox.getValue();
        for(CallRecord s: complainList){
            if(s.getCallType().equals(a)){
                tableView.getItems().add(s);
                messageLabel.setText("Success");
            }
        }
    }
}