package com.example.launchcompanysundarban;

import com.example.launchcompanysundarban.model.Notification;
import com.example.launchcompanysundarban.model.NotificationManager;
import com.example.launchcompanysundarban.model.Trip;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class BookingDetailsController {

    @FXML private Button backBtn;
    @FXML private Button loginBtn;
    @FXML private Label tripSummary;

    @FXML private TextField fullName;
    @FXML private TextField phone;
    @FXML private TextArea address;

    @FXML private Label validationLabel;
    @FXML private Button submitBtn;
    @FXML private Button cancelBtn;

    @FXML
    public void initialize() {
        backBtn.setOnAction(e -> NavigationUtil.goBack(GuestUserDashboardController.getInstance().centerStack));
        loginBtn.setOnAction(e -> {
            NavigationUtil.loadScene("/com/example/launchcompanysundarban/Login.fxml", "Login - Sundarban Launch Company");
            ((Stage) backBtn.getScene().getWindow()).close();
        });

        Trip t = BookLaunchTripController.bookingTrip;
        String deck = BookLaunchTripController.bookingDeck;
        int seat = BookLaunchTripController.bookingSeat;

        if (t != null) {
            tripSummary.setText("Trip: " + t.getRoute() + " | " + t.getDate() + " " + t.getTime()
                    + " | Deck: " + deck + " | Seat: " + seat + " | Fare: " + t.getFare());
        } else {
            tripSummary.setText("No trip selected.");
        }

        cancelBtn.setOnAction(e -> NavigationUtil.goBack(GuestUserDashboardController.getInstance().centerStack));

        submitBtn.setOnAction(e -> {
            validationLabel.setStyle("-fx-text-fill: red;");
            String name = fullName.getText().trim();
            String ph = phone.getText().trim();
            String addr = address.getText().trim();

            if (name.isEmpty() || ph.isEmpty() || addr.isEmpty()) {
                validationLabel.setText("All fields are required.");
                return;
            }
            if (!ph.matches("^[0-9]{6,15}$")) {
                validationLabel.setText("Phone must be 6–15 digits.");
                return;
            }
            if (t == null) {
                validationLabel.setText("Trip not found.");
                return;
            }

            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                    "Confirm booking for " + name + "?\n\n" + tripSummary.getText(), ButtonType.OK, ButtonType.CANCEL);
            confirm.setHeaderText("Confirm Booking");
            confirm.showAndWait().ifPresent(btn -> {
                if (btn == ButtonType.OK) {
                    boolean reserved = t.reserveSeat(deck, seat);
                    if (!reserved) {
                        validationLabel.setText("Seat is no longer available. Please choose another.");
                        return;
                    }


                    NotificationManager.createNotification(Notification.Type.INFO,
                            "New Booking Request",
                            name + " | Phone: " + ph + " | " + addr + " | " + tripSummary.getText());

                    validationLabel.setStyle("-fx-text-fill: green;");
                    validationLabel.setText("Booking submitted! You will be contacted.");


                    NavigationUtil.loadCenter("/com/example/launchcompanysundarban/WelcomeGuest.fxml",
                            GuestUserDashboardController.getInstance().centerStack);
                }
            });
        });
    }
}
