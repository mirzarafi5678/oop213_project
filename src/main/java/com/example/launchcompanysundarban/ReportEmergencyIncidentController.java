package com.example.launchcompanysundarban;

import com.example.launchcompanysundarban.model.DataStore;
import com.example.launchcompanysundarban.model.Notification;
import com.example.launchcompanysundarban.model.NotificationManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ReportEmergencyIncidentController {

    @FXML private Button backBtn;
    @FXML private ComboBox<String> tripSelect;
    @FXML private TextArea incidentDetails;
    @FXML private Button reportBtn;
    @FXML private Label statusLabel;

    @FXML
    public void initialize() {
        backBtn.setOnAction(e ->
                NavigationUtil.goBack(OperationManagerDashboardController.getInstance().centerStack));

        DataStore.getPublishedTrips().forEach(t -> tripSelect.getItems().add(DataStore.labelForTrip(t)));

        reportBtn.setOnAction(e -> {
            String label = tripSelect.getValue();
            String details = incidentDetails.getText().trim();

            if (label == null || label.isEmpty()) {
                statusLabel.setText("Please select a trip.");
                return;
            }
            if (details.length() < 10) {
                statusLabel.setText("Please describe the incident (min 10 chars).");
                return;
            }

            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                    "Submit emergency incident?\n" + label + "\nDetails: " + details,
                    ButtonType.OK, ButtonType.CANCEL);
            confirm.setHeaderText("Confirm Submit");
            confirm.showAndWait().ifPresent(btn -> {
                if (btn == ButtonType.OK) {
                    NotificationManager.createNotification(Notification.Type.ERROR, "Emergency Incident",
                            label + " | Details: " + details);

                    statusLabel.setStyle("-fx-text-fill: green;");
                    statusLabel.setText("Incident reported successfully.");
                    incidentDetails.clear();
                }
            });
        });
    }
}
