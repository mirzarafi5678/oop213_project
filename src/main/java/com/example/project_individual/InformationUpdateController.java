package com.example.project_individual;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InformationUpdateController
{
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> emailIDColumn;
    @javafx.fxml.FXML
    private TableColumn <CallRecord,String>detailsColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> nameColumn;
    @javafx.fxml.FXML
    private TableView<CallRecord> tableView;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> dateColumn;
    @javafx.fxml.FXML
    private TableColumn <CallRecord,String>callTypeColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> emergencyColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> idColumn;
    ArrayList<CallRecord> informationlist = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() throws IOException, ClassNotFoundException {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("callerID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("callerName"));
        detailsColumn.setCellValueFactory(new PropertyValueFactory<>("callDetails"));
        emailIDColumn.setCellValueFactory(new PropertyValueFactory<>("callerEmailID"));
        emergencyColumn.setCellValueFactory(new PropertyValueFactory<>("emergency"));
        callTypeColumn.setCellValueFactory(new PropertyValueFactory<>("callType"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("callDate"));
        File file = new File("callRecord.bin");
        List<CallRecord> list6= PutBinFile.readAllObjects(file);
        informationlist.addAll(list6);
        tableView.getItems().addAll(list6);

    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/AgentDashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void updateButton(ActionEvent actionEvent) throws IOException {
        // if any information update needed
        //click in this Button
        Scene_Switcher.switchTo("/com/example/project_individual/CallRecord.fxml",actionEvent);
    }
}