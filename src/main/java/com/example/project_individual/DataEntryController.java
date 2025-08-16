package com.example.project_individual;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataEntryController
{
    @javafx.fxml.FXML
    private TableColumn<DataEntry,String> IDColumn;
    @javafx.fxml.FXML
    private TextField productNameTextField;
    @javafx.fxml.FXML
    private TableColumn<DataEntry,String> nameColumn;
    @javafx.fxml.FXML
    private TableColumn<DataEntry,String> DateColumn;
    @javafx.fxml.FXML
    private DatePicker PurchaseDate;
    @javafx.fxml.FXML
    private Label Label;
    @javafx.fxml.FXML
    private TableView<DataEntry> tableView;
    @javafx.fxml.FXML
    private TableColumn<DataEntry,String> productNameColumn;
    @javafx.fxml.FXML
    private TextField inputIDTextField;
    @javafx.fxml.FXML
    private TextField imputAmountTextField;
    @javafx.fxml.FXML
    private TextField inputNameTextField;
    @javafx.fxml.FXML
    private TableColumn<DataEntry,String> AmountColumn;
    ArrayList<DataEntry> dataList = new ArrayList<>();
    Alert alert = new Alert(Alert.AlertType.WARNING);

    @javafx.fxml.FXML
    public void initialize() throws IOException, ClassNotFoundException {
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        AmountColumn.setCellValueFactory(new PropertyValueFactory<>("productAmount"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("purchaseProductName"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<>("purchaseDate"));

        File file = new File("DataEntry.bin");
        List<DataEntry> list2 = PutBinFile.readAllObjects(file);
        tableView.getItems().addAll(list2);
    }

    @javafx.fxml.FXML
    public void BackToDashBoard(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/FinancialOfficerDashboard.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void updateButton(ActionEvent actionEvent) {
        DataEntry selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            alert.setContentText("Please select an item to update");
            alert.show();
            return;
        }



    }

    @javafx.fxml.FXML
    public void addButton(ActionEvent actionEvent) throws IOException {

        boolean digitFound = false;
        for(int i=0; i<productNameTextField.getText() .length();i++){
            if(productNameTextField.getText().charAt(i)>='0' && productNameTextField.getText().charAt(i)<='9'){
                digitFound = true;
            }
        }

        boolean DigitFound = false;
        for(int i=0; i<inputNameTextField.getText() .length();i++){
            if(inputNameTextField.getText().charAt(i)>='0' && inputNameTextField.getText().charAt(i)<='9'){
                DigitFound = true;
            }
        }

        if(productNameTextField.getText().isEmpty() ||
                imputAmountTextField.getText().isEmpty() ||digitFound|| DigitFound ||
                PurchaseDate.getValue().isAfter(LocalDate.now())
                || inputIDTextField.getText().isEmpty()){
            alert.setContentText("Fill up the form properly.");
            alert.show();
        }
        else {
            DataEntry data_add = new DataEntry(
                    Integer.parseInt(inputIDTextField.getText()),
                    Integer.parseInt(imputAmountTextField.getText()),
                    inputNameTextField.getText(),
                    productNameTextField.getText(),
                    PurchaseDate.getValue());

            tableView.getItems().add(data_add);
            dataList.add(data_add);


            File Datafile = new File("DataEntry.bin");
            PutBinFile.saveObject(Datafile,data_add);

            alert.setContentText("Successfully added");
            alert.show();
            Label.setText("Successfully added");

            inputNameTextField.clear();
            imputAmountTextField.clear();
            inputIDTextField.clear();
            productNameTextField.clear();

        }
    }
}