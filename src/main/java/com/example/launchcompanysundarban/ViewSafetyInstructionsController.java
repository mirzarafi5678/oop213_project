package com.example.launchcompanysundarban;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ViewSafetyInstructionsController {

    @FXML private Button backBtn;
    @FXML private Button loginBtn;
    @FXML private TextArea safetyArea;

    @FXML
    public void initialize() {
        backBtn.setOnAction(e -> NavigationUtil.goBack(GuestUserDashboardController.getInstance().centerStack));
        loginBtn.setOnAction(e -> {
            NavigationUtil.loadScene("/com/example/launchcompanysundarban/Login.fxml", "Login - Sundarban Launch Company");
            ((Stage) backBtn.getScene().getWindow()).close();
        });

        safetyArea.setText(" Safety Instructions:\n" +
                "1. Wear a life jacket at all times.\n" +
                "2. Follow crew instructions in emergencies.\n" +
                "3. Do not overload the vessel.\n" +
                "4. Emergency exits are clearly marked.\n" +
                "5. Keep aisles and exits clear.\n" +
                "6. Children must be supervised by adults.");
    }
}
