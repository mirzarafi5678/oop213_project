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

public class BugetAllocationController
{
    @javafx.fxml.FXML
    private TextField SearchBudgetField;
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
    private TableColumn<Revenue,String> revenueColumn;
    @javafx.fxml.FXML
    private Label expenseLabal;
    private ArrayList<Revenue> budgetlist = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() throws IOException, ClassNotFoundException {
        depositColumn.setCellValueFactory(new PropertyValueFactory<>("Deposit"));
        expenseColumn.setCellValueFactory(new PropertyValueFactory<>("Expense"));
        revenueColumn.setCellValueFactory(new PropertyValueFactory<>("Revenue"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<>("Date"));

        File file = new File("CalculateRevenue.bin");
        List<Revenue> list2 = PutBinFile.readAllObjects(file);
        budgetlist.addAll(list2);
        tableView.getItems().addAll(list2);

    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/FinancialOfficerDashboard.fxml",actionEvent);
    }



    @javafx.fxml.FXML
    public void calculateButton(ActionEvent actionEvent) {
        if (budgetlist.isEmpty()) {
            Profit.setText("No records to calculate");
            expenseLabal.setText("Add records first");
            return;
        }

        // Calculate totals
        int totalDeposit = 0;
        int totalExpense = 0;
        int totalRevenue = 0;

        for (Revenue revenue : budgetlist) {
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
    public void SearchButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        int a = Integer.parseInt(SearchBudgetField.getText());
        for(Revenue s: budgetlist){
            if(s.getRevenue() == a){
                tableView.getItems().add(s);
            }
        }
    }
}