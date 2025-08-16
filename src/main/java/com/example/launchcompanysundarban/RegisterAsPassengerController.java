package com.example.launchcompanysundarban;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RegisterAsPassengerController {

    @FXML private Button backBtn;
    @FXML private Button loginBtn;
    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField email;
    @FXML private TextField phone;
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private Button registerBtn;
    @FXML private Label validationLabel;

    @FXML
    public void initialize() {
        backBtn.setOnAction(e -> NavigationUtil.goBack(GuestUserDashboardController.getInstance().centerStack));
        loginBtn.setOnAction(e -> {
            NavigationUtil.loadScene("/com/example/launchcompanysundarban/Login.fxml", "Login - Sundarban Launch Company");
            ((Stage) backBtn.getScene().getWindow()).close();
        });

        registerBtn.setOnAction(e -> onRegister());
    }

    private void onRegister() {
        if (firstName.getText().isEmpty() || lastName.getText().isEmpty() ||
                email.getText().isEmpty() || phone.getText().isEmpty() ||
                username.getText().isEmpty() || password.getText().isEmpty()) {
            validationLabel.setText("All fields are required.");
            return;
        }
        if (!email.getText().matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$")) {
            validationLabel.setText("Invalid email address.");
            return;
        }
        if (!phone.getText().matches("^[0-9]{6,15}$")) {
            validationLabel.setText("Phone must be 6–15 digits.");
            return;
        }
        if (password.getText().length() < 6) {
            validationLabel.setText("Password must be at least 6 characters.");
            return;
        }
        validationLabel.setStyle("-fx-text-fill: green;");
        validationLabel.setText("Registration successful! Proceeding to booking...");
        NavigationUtil.loadCenter("/com/example/launchcompanysundarban/BookLaunchTrip.fxml", GuestUserDashboardController.getInstance().centerStack);
    }
}
