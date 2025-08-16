package com.example.launchcompanysundarban;

import com.example.launchcompanysundarban.model.Trip;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class BookLaunchTripController {

    private static Trip selectedTrip;

    @FXML private Button backBtn;
    @FXML private Button loginBtn;
    @FXML private Label tripDetails;
    @FXML private ComboBox<String> deckCombo;
    @FXML private ComboBox<Integer> seatCombo;
    @FXML private Label freeSeatsLabel;
    @FXML private Button reserveBtn;
    @FXML private Label statusLabel;


    static Trip bookingTrip;
    static String bookingDeck;
    static int bookingSeat;

    public static void setSelectedTrip(Trip trip) {
        selectedTrip = trip;
    }

    @FXML
    public void initialize() {
        backBtn.setOnAction(e -> NavigationUtil.goBack(GuestUserDashboardController.getInstance().centerStack));
        loginBtn.setOnAction(e -> {
            NavigationUtil.loadScene("/com/example/launchcompanysundarban/Login.fxml", "Login - Sundarban Launch Company");
            ((Stage) backBtn.getScene().getWindow()).close();
        });

        if (selectedTrip != null) {
            tripDetails.setText("Trip: " + selectedTrip.getRoute() + " | Date: " + selectedTrip.getDate() +
                    " | Time: " + selectedTrip.getTime() + " | Fare: " + selectedTrip.getFare());
        } else {
            tripDetails.setText("No trip selected.");
        }

        deckCombo.setItems(FXCollections.observableArrayList("Ground Deck", "Second Deck"));
        deckCombo.valueProperty().addListener((obs, oldV, newV) -> refreshSeats());

        reserveBtn.setOnAction(e -> {
            statusLabel.setStyle("-fx-text-fill: red;");
            if (selectedTrip == null) {
                statusLabel.setText("No trip selected.");
                return;
            }
            String deck = deckCombo.getValue();
            Integer seat = seatCombo.getValue();
            if (deck == null) { statusLabel.setText("Please select deck."); return; }
            if (seat == null) { statusLabel.setText("Please select seat."); return; }

            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                    "Reserve " + deck + " - Seat " + seat + "?\n\nTrip: " + selectedTrip.getRoute(),
                    ButtonType.OK, ButtonType.CANCEL);
            confirm.setHeaderText("Confirm Reservation");
            confirm.showAndWait().ifPresent(btn -> {
                if (btn == ButtonType.OK) {
                    // Hold state for details page; actual seat lock after user submits details
                    bookingTrip = selectedTrip;
                    bookingDeck = deck;
                    bookingSeat = seat;
                    NavigationUtil.loadCenter("/com/example/launchcompanysundarban/BookingDetails.fxml",
                            GuestUserDashboardController.getInstance().centerStack);
                }
            });
        });

        refreshSeats();
    }

    private void refreshSeats() {
        statusLabel.setText("");
        String deck = deckCombo.getValue();
        if (deck == null || selectedTrip == null) {
            seatCombo.setItems(FXCollections.observableArrayList());
            freeSeatsLabel.setText("-");
            return;
        }
        if ("Ground Deck".equalsIgnoreCase(deck)) {
            seatCombo.setItems(FXCollections.observableArrayList(selectedTrip.getAvailableSeats("Ground Deck")));
            freeSeatsLabel.setText(String.valueOf(selectedTrip.getGroundDeckFree()));
        } else {
            seatCombo.setItems(FXCollections.observableArrayList(selectedTrip.getAvailableSeats("Second Deck")));
            freeSeatsLabel.setText(String.valueOf(selectedTrip.getSecondDeckFree()));
        }
        if (!seatCombo.getItems().isEmpty()) {
            seatCombo.getSelectionModel().selectFirst();
        }
    }
}
