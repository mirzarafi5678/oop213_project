package com.example.finalproject_oop213.MirzaMdSufianHridoy.TicketAgentController;

import com.example.finalproject_oop213.MirzaMdSufianHridoy.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class TicketAgentDashBoardController {
    @javafx.fxml.FXML
    public void AddNoticeButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/ticketagent/addNoticeByAgent-page.fxml",actionEvent);

    }



    @javafx.fxml.FXML
    public void AddLunchTripButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/ticketagent/removeOrAddLaunchTrip-page.fxml",actionEvent);
    }




    @javafx.fxml.FXML
    public void CraetApassengerTicketButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/ticketagent/createPassengerTicket-page.fxml",actionEvent);
    }





    @javafx.fxml.FXML
    public void DownlaodAllPassegerDetail(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/ticketagent/DownloadSummeryDetail-Page.fxml");
    }



    @javafx.fxml.FXML
    public void RemovePassengerTicket(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/ticketagent/RemovePassengerTicket-Pgae.fxml",actionEvent);
    }
    @javafx.fxml.FXML
    public void LogOutButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/login-page.fxml",actionEvent);
    }


    @javafx.fxml.FXML
    public void CalculatePriceButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/ticketagent/CalculateTotalPrice-page.fxml");
    }

    @javafx.fxml.FXML
    public void ViewAllDataFromDatabaseButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/ticketagent/viewDataFromDatabase-page.fxml",actionEvent);
    }





    @javafx.fxml.FXML
    public void removeLaunchTripButton(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/ticketagent/lastButton-Page.fxml",actionEvent);
    }
}
