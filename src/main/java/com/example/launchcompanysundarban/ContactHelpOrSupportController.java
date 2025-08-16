package com.example.launchcompanysundarban;

import com.example.launchcompanysundarban.model.Notification;
import com.example.launchcompanysundarban.model.NotificationManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ContactHelpOrSupportController {

    @FXML private Button backBtn;
    @FXML private Button loginBtn;
    @FXML private ComboBox<String> countryCode;
    @FXML private TextField phone;
    @FXML private TextField email;
    @FXML private TextArea message;
    @FXML private CheckBox asFeedbackCheck;
    @FXML private Label statusLabel;

    @FXML
    public void initialize() {
        backBtn.setOnAction(e -> NavigationUtil.goBack(GuestUserDashboardController.getInstance().centerStack));
        loginBtn.setOnAction(e -> {
            NavigationUtil.loadScene("/com/example/launchcompanysundarban/Login.fxml", "Login - Sundarban Launch Company");
            ((Stage) backBtn.getScene().getWindow()).close();
        });

        countryCode.getItems().addAll("+880", "+91", "+92");
        countryCode.getSelectionModel().selectFirst();
    }

    @FXML
    private void onSend() {
        String em = email.getText().trim();
        String ph = phone.getText().trim();
        String msg = message.getText().trim();

        if (!em.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$")) {
            statusLabel.setStyle("-fx-text-fill: red;");
            statusLabel.setText("Invalid email.");
            return;
        }
        if (!ph.matches("^[0-9]{6,15}$")) {
            statusLabel.setStyle("-fx-text-fill: red;");
            statusLabel.setText("Phone must be 6–15 digits.");
            return;
        }
        if (msg.length() < 10) {
            statusLabel.setStyle("-fx-text-fill: red;");
            statusLabel.setText("Please provide details (min 10 characters).");
            return;
        }

        String full = "Support from " + em + " / " + countryCode.getValue() + ph + " | " + msg;
        NotificationManager.createNotification(Notification.Type.INFO, "Support Message", full);

        if (asFeedbackCheck.isSelected()) {
            NotificationManager.createNotification(Notification.Type.INFO, "Guest Feedback", full);
        }

        statusLabel.setStyle("-fx-text-fill: green;");
        statusLabel.setText("Message sent! Support will contact you shortly.");
        message.clear();
    }
}
