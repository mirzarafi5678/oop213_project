package com.example.launchcompanysundarban;

import com.example.launchcompanysundarban.model.DataStore;
import com.example.launchcompanysundarban.model.Notification;
import com.example.launchcompanysundarban.model.NotificationManager;
import com.example.launchcompanysundarban.model.Trip;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class UpdateFareCreatePromotionController {

    @FXML private Button backBtn;
    @FXML private ComboBox<String> tripSelect;
    @FXML private TextField fareField;
    @FXML private TextField promoField;
    @FXML private Button updateBtn;
    @FXML private Label statusLabel;

    @FXML
    public void initialize() {
        backBtn.setOnAction(e ->
                NavigationUtil.goBack(OperationManagerDashboardController.getInstance().centerStack));

        DataStore.getPublishedTrips().forEach(t -> tripSelect.getItems().add(DataStore.labelForTrip(t)));

        updateBtn.setOnAction(e -> {
            String label = tripSelect.getValue();
            String fareText = fareField.getText().trim();
            String promo = promoField.getText().trim();

            if (label == null || label.isEmpty()) {
                statusLabel.setText("Please select a trip.");
                return;
            }
            if (fareText.isEmpty()) {
                statusLabel.setText("Please enter a new fare.");
                return;
            }
            double fare;
            try {
                fare = Double.parseDouble(fareText);
                if (fare <= 0) {
                    statusLabel.setText("Fare must be greater than 0.");
                    return;
                }
            } catch (NumberFormatException ex) {
                statusLabel.setText("Fare must be numeric.");
                return;
            }

            String id = DataStore.extractIdFromLabel(label).orElse(null);
            Trip t = (id == null) ? null : DataStore.findById(id).orElse(null);
            if (t == null) {
                statusLabel.setText("Trip not found.");
                return;
            }

            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                    "Update fare" + (promo.isEmpty() ? "" : " and promotion") + "?\n" + label
                            + "\nNew Fare: " + fare + (promo.isEmpty() ? "" : ("\nPromo: " + promo)),
                    ButtonType.OK, ButtonType.CANCEL);
            confirm.setHeaderText("Confirm Update");
            confirm.showAndWait().ifPresent(btn -> {
                if (btn == ButtonType.OK) {
                    t.setFare(fare);

                    NotificationManager.createNotification(Notification.Type.INFO,
                            "Fare/Promo Update",
                            DataStore.labelForTrip(t) + " | Fare: " + fare + (promo.isEmpty() ? "" : (" | Promo: " + promo)));

                    statusLabel.setStyle("-fx-text-fill: green;");
                    statusLabel.setText("Fare/Promotion updated successfully.");

                    fareField.clear();
                    promoField.clear();
                }
            });
        });
    }
}
