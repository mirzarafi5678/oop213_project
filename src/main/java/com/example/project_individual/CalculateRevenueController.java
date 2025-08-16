package com.example.project_individual;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalculateRevenueController
{
    @javafx.fxml.FXML
    private TableColumn<Revenue,String> expenseColumn;
    @javafx.fxml.FXML
    private TableView<Revenue> tableView;
    @javafx.fxml.FXML
    private Label Profit;
    @javafx.fxml.FXML
    private TableColumn<Revenue,String> depositColumn;
    @javafx.fxml.FXML
    private TableColumn<Revenue,String> datecolumn;
    @javafx.fxml.FXML
    private Label expenseLabal;
    @javafx.fxml.FXML
    private TableColumn<Revenue,String> revenueColumn;

    @javafx.fxml.FXML
    private TextField DepositTextField;
    @javafx.fxml.FXML
    private TextField ExpenseTextField;
    @javafx.fxml.FXML
    private DatePicker DateTextField;
    @javafx.fxml.FXML
    private TextField RevenueTextField;
    private ArrayList<Revenue> revenueList = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() throws IOException, ClassNotFoundException {


        depositColumn.setCellValueFactory(new PropertyValueFactory<>("Deposit"));
        expenseColumn.setCellValueFactory(new PropertyValueFactory<>("Expense"));
        revenueColumn.setCellValueFactory(new PropertyValueFactory<>("Revenue"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<>("Date"));

        File file = new File("CalculateRevenue.bin");
        List<Revenue> list2 = PutBinFile.readAllObjects(file);
        tableView.getItems().addAll(list2);
    }

    @javafx.fxml.FXML
    public void AddButton(ActionEvent actionEvent) throws IOException {
        Revenue newRevenue = new Revenue(Integer.parseInt(DepositTextField.getText()),
                Integer.parseInt(ExpenseTextField.getText()),
                Integer.parseInt(RevenueTextField.getText()),
                DateTextField.getValue());
        tableView.getItems().add(newRevenue);
        revenueList.add(newRevenue);
        DepositTextField.clear();
        ExpenseTextField.clear();
        DepositTextField.clear();

        File Revenuefile = new File("CalculateRevenue.bin");
        PutBinFile.saveObject(Revenuefile,newRevenue);

    }

    @javafx.fxml.FXML
    public void calculateButton(ActionEvent actionEvent) {
        if (revenueList.isEmpty()) {
            Profit.setText("No records to calculate");
            expenseLabal.setText("Add records first");
            return;
        }

        // Calculate totals
        int totalDeposit = 0;
        int totalExpense = 0;
        int totalRevenue = 0;

        for (Revenue revenue : revenueList) {
            totalDeposit += revenue.getDeposit();
            totalExpense += revenue.getExpense();
            totalRevenue += revenue.getRevenue();
        }

        // Calculate profit (Revenue - Expenses + Deposits)
        int netProfit = totalRevenue - totalExpense + totalDeposit;

        // Update labels
        Profit.setText("Net Profit: " + netProfit);
        expenseLabal.setText("Expenses: " + totalExpense + " | Deposits: " + totalDeposit);

    }

    @javafx.fxml.FXML
    public void BackButton(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/FinancialOfficerDashboard.fxml",actionEvent);
    }




}