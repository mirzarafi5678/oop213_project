package com.example.launchcompanysundarban;

import com.example.launchcompanysundarban.model.DataStore;
import com.example.launchcompanysundarban.model.Notification;
import com.example.launchcompanysundarban.model.NotificationManager;
import com.example.launchcompanysundarban.model.Trip;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CancelOrRemoveTripController {

    @FXML private Button backBtn;
    @FXML private ComboBox<String> tripSelect;
    @FXML private TextArea reasonField;
    @FXML private Button cancelBtn;
    @FXML private Label statusLabel;

    @FXML
    public void initialize() {
        backBtn.setOnAction(e ->
                NavigationUtil.goBack(OperationManagerDashboardController.getInstance().centerStack));

        DataStore.getPublishedTrips().forEach(t -> tripSelect.getItems().add(DataStore.labelForTrip(t)));

        cancelBtn.setOnAction(e -> {
            String label = tripSelect.getValue();
            String reason = reasonField.getText().trim();

            if (label == null || label.isEmpty()) {
                statusLabel.setText("Please select a trip.");
                return;
            }
            if (reason.isEmpty()) {
                statusLabel.setText("Please enter a cancellation reason.");
                return;
            }

            String id = DataStore.extractIdFromLabel(label).orElse(null);
            Trip t = (id == null) ? null : DataStore.findById(id).orElse(null);
            if (t == null) {
                statusLabel.setText("Trip not found.");
                return;
            }

            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                    "Cancel trip?\n" + label + "\nReason: " + reason,
                    ButtonType.OK, ButtonType.CANCEL);
            confirm.setHeaderText("Confirm Cancellation");
            confirm.showAndWait().ifPresent(btn -> {
                if (btn == ButtonType.OK) {
                    t.setStatus("Cancelled");

                    NotificationManager.createNotification(Notification.Type.ERROR,
                            "Trip Cancelled",
                            DataStore.labelForTrip(t) + " | Reason: " + reason);

                    statusLabel.setStyle("-fx-text-fill: green;");
                    statusLabel.setText("Trip cancelled successfully.");
                    reasonField.clear();
                }
            });
        });
    }
}
