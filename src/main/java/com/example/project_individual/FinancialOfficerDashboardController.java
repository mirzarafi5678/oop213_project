package com.example.project_individual;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class FinancialOfficerDashboardController
{
    @javafx.fxml.FXML
    private Button DataEntry;
    @javafx.fxml.FXML
    private TextField SearchPaymentPurpose;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void budgetAllocation(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/BugetAllocation.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void financialRecord(ActionEvent actionEvent) throws IOException{
        Scene_Switcher.switchTo("/com/example/project_individual/financialrecord-fxml.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void calculateRevenue(ActionEvent actionEvent) throws IOException{
        Scene_Switcher.switchTo("/com/example/project_individual/CalculateRevenue.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void ticketPrice(ActionEvent actionEvent) throws IOException{
        Scene_Switcher.switchTo("/com/example/project_individual/ticketprice-fxml.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/login-page.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void salaryIncrease(ActionEvent actionEvent) throws IOException{
        Scene_Switcher.switchTo("/com/example/project_individual/salaryincrease-fxml.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void utilitesExpenses(ActionEvent actionEvent) throws IOException{
        Scene_Switcher.switchTo("/com/example/project_individual/utilitesExpense-fxml.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void paymentStatus(ActionEvent actionEvent) throws IOException {

        Scene_Switcher.switchTo("/com/example/project_individual/PaymentStatus.fxml",actionEvent);

//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(usageClass.class.getResource("PaymentStatus.fxml"));
//            Scene nextScene = new Scene(fxmlLoader.load());
//            Stage nextStage = new Stage();
//            nextStage.setTitle("Payment Details");
//            nextStage.setScene(nextScene);
//            PaymentstatusFxmlController nextController = fxmlLoader.getController();
//            //nextController.receivePaymentDetailsFromDashboard(SearchPaymentPurpose.getText());
//            nextStage.show();
//        } catch (Exception e) {
//            //
//        }
    }

    @javafx.fxml.FXML
    public void DataEntry(ActionEvent actionEvent) throws IOException{
        Scene_Switcher.switchTo("/com/example/project_individual/DataEntry.fxml",actionEvent);

    }
}