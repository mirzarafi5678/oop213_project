package com.example.launchcompanysundarban;

import com.example.finalproject_oop213.MirzaMdSufianHridoy.SceneSwitcher;
import com.example.project_individual.Scene_Switcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GuestUserDashboardController {

    @FXML public StackPane centerStack;

    private static GuestUserDashboardController instance;

    public GuestUserDashboardController() {
        instance = this;
    }

    public static GuestUserDashboardController getInstance() {
        return instance;
    }

    @FXML
    public void initialize() {
        showDefaultCenter();
    }

    public void showDefaultCenter() {
        NavigationUtil.loadCenter("/com/example/launchcompanysundarban/WelcomeGuest.fxml", centerStack);
    }

    @FXML
    public void loadSearchLaunchTrip() {
        NavigationUtil.loadCenter("/com/example/launchcompanysundarban/SearchLaunchTrip.fxml", centerStack);
    }

    @FXML
    public void loadBookLaunchTrip() {
        NavigationUtil.loadCenter("/com/example/launchcompanysundarban/BookLaunchTrip.fxml", centerStack);
    }

    @FXML
    public void loadViewSafetyInstructions() {
        NavigationUtil.loadCenter("/com/example/launchcompanysundarban/ViewSafetyInstructions.fxml", centerStack);
    }

    @FXML
    public void loadReadCompanyServices() {
        NavigationUtil.loadCenter("/com/example/launchcompanysundarban/ReadCompanyServices.fxml", centerStack);
    }

    @FXML
    public void loadContactHelpOrSupport() {
        NavigationUtil.loadCenter("/com/example/launchcompanysundarban/ContactHelpOrSupport.fxml", centerStack);
    }

    @FXML
    public void loadViewSpecialOffers() {
        NavigationUtil.loadCenter("/com/example/launchcompanysundarban/ViewSpecialOffers.fxml", centerStack);
    }

    @FXML
    public void loadRegisterAsPassenger() {
        NavigationUtil.loadCenter("/com/example/launchcompanysundarban/RegisterAsPassenger.fxml", centerStack);
    }

    @FXML
    public void loadHowToUseApplication() {
        NavigationUtil.loadCenter("/com/example/launchcompanysundarban/HowToUseApplication.fxml", centerStack);
    }

    @FXML
    public void backToLogin() throws IOException {
        Stage stage = (Stage) centerStack.getScene().getWindow();
        NavigationUtil.loadScene2("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/login-page.fxml", "Login - Sundarban Launch Company");
        stage.close();
    }
}
