package com.example.finalproject_oop213.IsratJahan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BugetAllocationController {

    @FXML
    private DatePicker DatePicker;

    @FXML
    private TextField PurposeOfBudgetTextField;

    @FXML
    private TableView<?> Table1;

    @FXML
    private TextField amountOfBudgetTextField;

    @FXML
    private Label budgetAllocationLabel;

    @FXML
    private ComboBox<?> categoryCombo;

    @FXML
    private Label expenseLabel;

    @FXML
    private Label revenueLabel;

    @FXML
    private TableColumn<?, ?> table1AmountColumn;

    @FXML
    private TableColumn<?, ?> table1ExpenseColumn;

    @FXML
    private TableView<?> table2;

    @FXML
    private TableColumn<?, ?> table2AmountColumn;

    @FXML
    private TableColumn<?, ?> table2RevenueColumn;

    @FXML
    void addButton(ActionEvent event) {

    }

    @FXML
    void backButton(ActionEvent event) {

    }

    @FXML
    void initialize(){

    }

}
