package com.example.launchcompanysundarban;

import com.example.launchcompanysundarban.model.DataStore;
import com.example.launchcompanysundarban.model.Notification;
import com.example.launchcompanysundarban.model.NotificationManager;
import com.example.launchcompanysundarban.model.Trip;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MarkTripAsDelayedController {

    @FXML private Button backBtn;
    @FXML private ComboBox<String> tripSelect;
    @FXML private DatePicker newDate;
    @FXML private TextField newTime;
    @FXML private Button delayBtn;
    @FXML private Label statusLabel;

    @FXML
    public void initialize() {
        backBtn.setOnAction(e ->
                NavigationUtil.goBack(OperationManagerDashboardController.getInstance().centerStack));

        DataStore.getPublishedTrips().forEach(t -> tripSelect.getItems().add(DataStore.labelForTrip(t)));

        delayBtn.setOnAction(e -> {
            String label = tripSelect.getValue();
            String time = newTime.getText();

            if (label == null || label.isEmpty()) {
                statusLabel.setText("Please select a trip.");
                return;
            }
            if (newDate.getValue() == null || time == null || time.isBlank()) {
                statusLabel.setText("Please enter new date and time.");
                return;
            }

            try {
                LocalDate nd = newDate.getValue();
                if (nd.isBefore(LocalDate.now())) {
                    statusLabel.setText("New date cannot be in the past.");
                    return;
                }
                LocalTime nt = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));

                String id = DataStore.extractIdFromLabel(label).orElse(null);
                Trip t = (id == null) ? null : DataStore.findById(id).orElse(null);
                if (t == null) {
                    statusLabel.setText("Trip not found.");
                    return;
                }

                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                        "Delay trip to " + nd + " " + nt + "?", ButtonType.OK, ButtonType.CANCEL);
                confirm.setHeaderText("Confirm Delay");
                confirm.showAndWait().ifPresent(btn -> {
                    if (btn == ButtonType.OK) {
                        t.setDate(nd);
                        t.setTime(nt);
                        t.setStatus("Delayed");

                        NotificationManager.createNotification(Notification.Type.WARNING,
                                "Trip Delayed",
                                DataStore.labelForTrip(t));

                        statusLabel.setStyle("-fx-text-fill: green;");
                        statusLabel.setText("Trip marked as delayed successfully.");
                        newDate.setValue(null);
                        newTime.clear();
                    }
                });

            } catch (Exception ex) {
                statusLabel.setText("Time must be HH:mm (24h).");
            }
        });
    }
}
