package com.example.project_individual;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TicketpriceFxmlController
{
    @javafx.fxml.FXML
    private TextField fromTextField;
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private ComboBox<String> categoryComboBox;
    @javafx.fxml.FXML
    private TextField amountTextField;
    @javafx.fxml.FXML
    private TableColumn<TicketPriceFixed,String> amountColumn;
    @javafx.fxml.FXML
    private TableView<TicketPriceFixed> tableView;
    @javafx.fxml.FXML
    private TableColumn<TicketPriceFixed,String> fromColumn;
    @javafx.fxml.FXML
    private TableColumn<TicketPriceFixed,String> categoryColumn;
    @javafx.fxml.FXML
    private TableColumn<TicketPriceFixed,String> toColumn;
    @javafx.fxml.FXML
    private TextField toTextField;
    @javafx.fxml.FXML
    private TableColumn<TicketPriceFixed,String> idColumn;
    ArrayList<TicketPriceFixed> ticketPriceList = new ArrayList<>();
    Alert alert = new Alert(Alert.AlertType.WARNING);

    @javafx.fxml.FXML
    public void initialize() throws IOException, ClassNotFoundException {

        categoryComboBox.getItems().addAll("VIP","General","Premium");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        fromColumn.setCellValueFactory(new PropertyValueFactory<>("from"));
        toColumn.setCellValueFactory(new PropertyValueFactory<>("to"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        File file = new File("TicketPrice.bin");
        List<TicketPriceFixed> list3 = PutBinFile.readAllObjects(file);
        tableView.getItems().addAll(list3);
    }

    @javafx.fxml.FXML
    public void removeButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/FinancialOfficerDashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void updateButton(ActionEvent actionEvent) {
        TicketPriceFixed selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            alert.setContentText("Please select an item to update");
            alert.show();
            return;
        }
    }

    @javafx.fxml.FXML
    public void addButton(ActionEvent actionEvent) throws IOException {

        boolean digitFound = false;
        for(int i=0; i<fromTextField.getText() .length();i++){
            if(fromTextField.getText().charAt(i)>='0' && fromTextField.getText().charAt(i)<='9'){
                digitFound = true;
            }
        }

        boolean DigitFound = false;
        for(int i=0; i<toTextField.getText() .length();i++){
            if(toTextField.getText().charAt(i)>='0' && toTextField.getText().charAt(i)<='9'){
                DigitFound = true;
            }
        }

        if(idTextField.getText().isEmpty() ||
                fromTextField.getText().isEmpty() ||digitFound|| DigitFound
                || toTextField.getText().isEmpty()){
            alert.setContentText("Fill up the form properly.");
            alert.show();
        }
        else {
            TicketPriceFixed ticketpriceAdd = new TicketPriceFixed(
                    Integer.parseInt(idTextField.getText()),
                    Integer.parseInt(amountTextField.getText()),
                    fromTextField.getText(),
                    toTextField.getText(),
                    categoryComboBox.getValue());

            tableView.getItems().add(ticketpriceAdd);
            ticketPriceList.add(ticketpriceAdd);

            File TicketFile = new File("TicketPrice.bin");
            PutBinFile.saveObject(TicketFile,ticketpriceAdd);



            alert.setContentText("Successfully added");
            alert.show();


            idTextField.clear();
            amountTextField.clear();
            fromTextField.clear();
            toTextField.clear();

        }
    }
}