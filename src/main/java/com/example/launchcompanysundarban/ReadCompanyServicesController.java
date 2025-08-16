package com.example.launchcompanysundarban;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ReadCompanyServicesController {

    @FXML private Button backBtn;
    @FXML private Button loginBtn;
    @FXML private TextArea serviceArea;

    @FXML
    public void initialize() {
        backBtn.setOnAction(e -> NavigationUtil.goBack(GuestUserDashboardController.getInstance().centerStack));
        loginBtn.setOnAction(e -> {
            NavigationUtil.loadScene("/com/example/launchcompanysundarban/Login.fxml", "Login - Sundarban Launch Company");
            ((Stage) backBtn.getScene().getWindow()).close();
        });

        serviceArea.setText(" Sundarban Launch Company Services:\n" +
                "- Passenger Transport\n" +
                "- Cargo Transport\n" +
                "- Luxury Cabins\n" +
                "- Seasonal Tour Packages\n" +
                "- Group & Corporate Bookings");
    }
}
