package com.example.project_individual;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VerificationController
{
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> CallTypeColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> detailsColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> nameColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> emailidColumn;
    @javafx.fxml.FXML
    private TextField inputIdTextField;
    @javafx.fxml.FXML
    private TableView<CallRecord> tableView;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> dateColumn;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> emergencyColumn;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TableColumn<CallRecord,String> idColumn;
    ArrayList<CallRecord> idList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() throws IOException, ClassNotFoundException {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("callerID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("callerName"));
        detailsColumn.setCellValueFactory(new PropertyValueFactory<>("callDetails"));
        emailidColumn.setCellValueFactory(new PropertyValueFactory<>("callerEmailID"));
        emergencyColumn.setCellValueFactory(new PropertyValueFactory<>("emergency"));
        CallTypeColumn.setCellValueFactory(new PropertyValueFactory<>("callType"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("callDate"));


        File file = new File("callRecord.bin");
        List<CallRecord> list6= PutBinFile.readAllObjects(file);
        idList.addAll(list6);
        tableView.getItems().addAll(list6);
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/AgentDashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void updateButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        String id = inputIdTextField.getText();
        if (id.isEmpty()) {
            messageLabel.setText("ID cannot be Empty");
        }


        if (!Character.isLetter(id.charAt(0))) {
            messageLabel.setText("please write the correct ID");
        }
        if (!Character.isLetter(id.charAt(1))){
            messageLabel.setText("please write correct id");
        }
        else {
            for(CallRecord s : idList){

                tableView.getItems().add(s);
                }
            }
        }
}


