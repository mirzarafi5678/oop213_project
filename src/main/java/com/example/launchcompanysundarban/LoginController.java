package com.example.launchcompanysundarban;

import com.example.launchcompanysundarban.model.SessionManager;
import com.example.launchcompanysundarban.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private TextField passwordVisibleField;
    @FXML private CheckBox showPasswordCheck;
    @FXML private ComboBox<String> roleCombo;
    @FXML private Button loginBtn;
    @FXML private Button visitGuestBtn;
    @FXML private Label validationLabel;

    private final List<User> users = new ArrayList<>();

    @FXML
    public void initialize() {
        roleCombo.getItems().addAll("Operation Manager", "Customer");
        roleCombo.getSelectionModel().selectFirst();


        users.add(new User("admin", "Sundarban Admin", "admin123", "Operation Manager"));
        users.add(new User("customer", "Demo Customer", "cust12345", "Customer")); // realistic length

        passwordVisibleField.managedProperty().bind(showPasswordCheck.selectedProperty());
        passwordVisibleField.visibleProperty().bind(showPasswordCheck.selectedProperty());
        passwordField.managedProperty().bind(showPasswordCheck.selectedProperty().not());
        passwordField.visibleProperty().bind(showPasswordCheck.selectedProperty().not());
        passwordVisibleField.textProperty().bindBidirectional(passwordField.textProperty());

        visitGuestBtn.setOnAction(this::onVisitGuest);
        loginBtn.setOnAction(this::onLogin);


        usernameField.setOnAction(this::onLogin);
        passwordField.setOnAction(this::onLogin);
        passwordVisibleField.setOnAction(this::onLogin);
    }

    private void onVisitGuest(ActionEvent event) {
        try {
            SessionManager.clear();
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/launchcompanysundarban/GuestUserDashboard.fxml")
            );
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) visitGuestBtn.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Guest Dashboard - Sundarban Launch Company");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showError("Unable to open guest dashboard: " + e.getMessage());
        }
    }

    private void onLogin(ActionEvent event) {
        validationLabel.setText("");
        String username = usernameField.getText().trim();
        String password = (showPasswordCheck.isSelected() ? passwordVisibleField.getText() : passwordField.getText());
        String role = roleCombo.getSelectionModel().getSelectedItem();

        if (username.isEmpty()) {
            showError("Username cannot be empty.");
            return;
        }
        if (password == null || password.isBlank()) {
            showError("Password cannot be empty.");
            return;
        }
        if (password.length() < 6) {
            showError("Password must be at least 6 characters.");
            return;
        }

        User match = users.stream()
                .filter(u -> u.getUsername().equals(username)
                        && u.getPassword().equals(password)
                        && u.getRole().equals(role))
                .findFirst().orElse(null);

        if (match == null) {
            showError("Invalid credentials. Try again.");
            return;
        }

        SessionManager.setCurrentUser(match);
        try {
            if ("Operation Manager".equals(role)) {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/com/example/launchcompanysundarban/OperationManagerDashboard.fxml")
                );
                Scene scene = new Scene(loader.load());
                Stage stage = (Stage) loginBtn.getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Operation Manager Dashboard - Sundarban Launch Company");
                stage.show();
            } else {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/com/example/launchcompanysundarban/GuestUserDashboard.fxml")
                );
                Scene scene = new Scene(loader.load());
                Stage stage = (Stage) loginBtn.getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Guest Dashboard - Sundarban Launch Company");
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            showError("Unable to open dashboard: " + e.getMessage());
        }
    }

    private void showError(String msg) {
        validationLabel.setText(msg);
    }
}
