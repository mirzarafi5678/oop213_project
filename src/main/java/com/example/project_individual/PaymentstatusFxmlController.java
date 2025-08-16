package com.example.project_individual;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PaymentstatusFxmlController
{
    @javafx.fxml.FXML
    private TextField PaymentPurpose;
    @javafx.fxml.FXML
    private TableColumn<Financial_Record,String> AddamountColumn;
    @javafx.fxml.FXML
    private TableColumn<Financial_Record,String> InvestAmountColumn;
    @javafx.fxml.FXML
    private TableColumn<Financial_Record,String> DateColumn;
    @javafx.fxml.FXML
    private TableColumn<Financial_Record,String> PurposeColumn;
    @javafx.fxml.FXML
    private TableColumn<Financial_Record,String> RevenueColumn;
    @javafx.fxml.FXML
    private TableView<Financial_Record> TableView;
    private  ArrayList<Financial_Record> listOfRecord = new ArrayList<>();
    private Alert alert = new Alert(Alert.AlertType.WARNING);

    @javafx.fxml.FXML
    public void initialize() throws IOException, ClassNotFoundException {
        AddamountColumn.setCellValueFactory(new PropertyValueFactory<>("add_Amount"));
        InvestAmountColumn.setCellValueFactory(new PropertyValueFactory<>("Invest_amount"));
        RevenueColumn.setCellValueFactory(new PropertyValueFactory<>("Revenue"));
        PurposeColumn.setCellValueFactory(new PropertyValueFactory<>("purpose"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        // list1 = new ArrayList<>();
        File file = new File("financial.bin");
        List<Financial_Record> list1= PutBinFile.readAllObjects(file);
        listOfRecord.addAll(list1);
        TableView.getItems().addAll(list1);



    }


    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/FinancialOfficerDashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void SearchButton(ActionEvent actionEvent) throws IOException {
        TableView.getItems().clear();
        String a = PaymentPurpose.getText();
        for(Financial_Record s: listOfRecord){
            if(s.getPurpose().equals(a)){
                TableView.getItems().add(s);
            }
        }



    }

}