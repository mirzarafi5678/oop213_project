package com.example.launchcompanysundarban;

import com.example.launchcompanysundarban.model.DataStore;
import com.example.launchcompanysundarban.model.Notification;
import com.example.launchcompanysundarban.model.NotificationManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class CreateAndPublishScheduleController {

    @FXML private Button backBtn;
    @FXML private TextField tripIdField;
    @FXML private TextField routeField;
    @FXML private DatePicker datePicker;
    @FXML private TextField timeField;
    @FXML private TextField launchIdField;
    @FXML private TextField fareField;
    @FXML private Button publishBtn;
    @FXML private Label statusLabel;

    @FXML
    public void initialize() {
        backBtn.setOnAction(e ->
                NavigationUtil.goBack(OperationManagerDashboardController.getInstance().centerStack));

        publishBtn.setOnAction(e -> {
            statusLabel.setStyle("-fx-text-fill: red;");
            if (routeField.getText().isEmpty()
                    || datePicker.getValue() == null || timeField.getText().isEmpty()
                    || launchIdField.getText().isEmpty() || fareField.getText().isEmpty()) {
                statusLabel.setText("All fields except 'Trip ID' are required.");
                return;
            }
            try {
                LocalDate date = datePicker.getValue();
                LocalTime time = LocalTime.parse(timeField.getText());
                if (date.isBefore(LocalDate.now())) {
                    statusLabel.setText("Date cannot be in the past.");
                    return;
                }
                double fare = Double.parseDouble(fareField.getText());
                if (fare <= 0) {
                    statusLabel.setText("Fare must be greater than 0.");
                    return;
                }

                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                        "Publish schedule?\n" + routeField.getText() + "\n" + date + " " + time + " | Fare " + fare,
                        ButtonType.OK, ButtonType.CANCEL);
                confirm.setHeaderText("Confirm Publish");
                confirm.showAndWait().ifPresent(btn -> {
                    if (btn == ButtonType.OK) {
                        DataStore.addTrip(routeField.getText(), date, time, launchIdField.getText(), fare, "Published");

                        statusLabel.setStyle("-fx-text-fill: green;");
                        statusLabel.setText("Schedule published successfully!");

                        NotificationManager.createNotification(Notification.Type.SUCCESS,
                                "Schedule Published",
                                routeField.getText() + " on " + date + " " + time + " | Fare " + fare);

                        tripIdField.clear();
                        routeField.clear();
                        datePicker.setValue(null);
                        timeField.clear();
                        launchIdField.clear();
                        fareField.clear();
                    }
                });

            } catch (Exception ex) {
                statusLabel.setText("Invalid format. Time=HH:mm, Fare=numeric.");
            }
        });
    }
}
