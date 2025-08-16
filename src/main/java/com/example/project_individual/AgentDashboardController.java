package com.example.project_individual;

import javafx.event.ActionEvent;

import java.io.IOException;

public class AgentDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void FeedBackButton(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/Feedback.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void EmergencyButton(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/EmergencySituation.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void TechnicalSupportButton(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/Technicalsupport.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void TicketBookingButton(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/TicketBook.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) throws IOException {
     Scene_Switcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/login-page.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void InformationButton(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/InformationUpdate.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void CallRecordButto(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/CallRecord.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void VerificationButton(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/Verification.fxml",actionEvent);
    }

    @javafx.fxml.FXML
    public void ComplainButton(ActionEvent actionEvent) throws IOException {
        Scene_Switcher.switchTo("/com/example/project_individual/HandleComplain.fxml",actionEvent);
    }
}