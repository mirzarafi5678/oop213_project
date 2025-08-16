package com.example.launchcompanysundarban;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class HowToUseApplicationController {

    @FXML private Button backBtn;
    @FXML private Button loginBtn;
    @FXML private TextArea instructionsArea;

    @FXML
    public void initialize() {
        backBtn.setOnAction(e -> NavigationUtil.goBack(GuestUserDashboardController.getInstance().centerStack));
        loginBtn.setOnAction(e -> {
            NavigationUtil.loadScene("/com/example/launchcompanysundarban/Login.fxml", "Login - Sundarban Launch Company");
            ((Stage) backBtn.getScene().getWindow()).close();
        });

        instructionsArea.setText("📱 How to Use Application:\n" +
                "1. Search trips using the Search Launch Trip option.\n" +
                "2. Select a trip and book by registering.\n" +
                "3. View safety and services for guidance.\n" +
                "4. Contact support for any assistance.");
    }
}
