package com.example.project_individual;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UtilitesExpenseFxmlController
{
    @javafx.fxml.FXML
    private ComboBox<String> UtiliesTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<UtiliesExpense,String> PaymentTypeColumn;
    @javafx.fxml.FXML
    private TextField AmountTextField;
    @javafx.fxml.FXML
    private DatePicker DateOfPayment;
    @javafx.fxml.FXML
    private TableColumn<UtiliesExpense,String> UtiliesTypeColumn;
    @javafx.fxml.FXML
    private TableView<UtiliesExpense> tableView;
    @javafx.fxml.FXML
    private ComboBox<String> PaymentTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<UtiliesExpense,String> AmountColumn;
    @javafx.fxml.FXML
    private TableColumn<UtiliesExpense,String> DateOfPaymentColumn;
    ArrayList<UtiliesExpense> expenseList = new ArrayList<>();
    Alert alert = new Alert(Alert.AlertType.WARNING);

    @javafx.fxml.FXML
    public void initialize() throws IOException, ClassNotFoundException {

        PaymentTypeComboBox.getItems().addAll("card","Bkash","Nagad","Cash","Bank");
        UtiliesTypeComboBox.getItems().addAll("Water","Electricity","Oil","Others");
        UtiliesTypeColumn.setCellValueFactory(new PropertyValueFactory<>("utilitesType"));
        PaymentTypeColumn.setCellValueFactory(new PropertyValueFactory<>("paymentType"));
        AmountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        DateOfPaymentColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfPayment"));

        File file = new File("UtilitiesExpense.bin");
        List<UtiliesExpense> list4= PutBinFile.readAllObjects(file);
        tableView.getItems().addAll(list4);
    }

    @javafx.fxml.FXML
    public void backToDashboard(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/FinancialOfficerDashboard.fxml",actionEvent);

    }

    @javafx.fxml.FXML
    public void DeleteButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
    }

    @javafx.fxml.FXML
    public void AddButton(ActionEvent actionEvent) throws IOException {

        if (AmountTextField.getText().isEmpty() ||
                DateOfPayment.getValue().isAfter(LocalDate.now())) {
            alert.setContentText("Fill up the form properly.");
            alert.show();
        }
        else {
            UtiliesExpense ExpenseAdd = new UtiliesExpense(
                    UtiliesTypeComboBox.getValue(),
                    PaymentTypeComboBox.getValue(),
                    Integer.parseInt(AmountTextField.getText()),
                    DateOfPayment.getValue());

            tableView.getItems().add(ExpenseAdd);
            expenseList.add(ExpenseAdd);

            File ExpenseFile = new File("UtilitiesExpense.bin");
            PutBinFile.saveObject(ExpenseFile,ExpenseAdd);

            alert.setContentText("Successfully added");

            AmountTextField.clear();



        }
    }
}