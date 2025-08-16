package com.example.launchcompanysundarban;

import com.example.launchcompanysundarban.model.DataStore;
import com.example.launchcompanysundarban.model.Trip;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.List;

public class SearchLaunchTripController {

    @FXML private Button backBtn;
    @FXML private Button loginBtn;
    @FXML private TextField fromField;
    @FXML private TextField toField;
    @FXML private DatePicker datePicker;
    @FXML private TableView<Trip> tripTable;
    @FXML private TableColumn<Trip, String> colRoute;
    @FXML private TableColumn<Trip, LocalDate> colDate;
    @FXML private TableColumn<Trip, Double> colFare;
    @FXML private Label validationLabel;

    @FXML
    public void initialize() {
        backBtn.setOnAction(e -> NavigationUtil.goBack(GuestUserDashboardController.getInstance().centerStack));
        loginBtn.setOnAction(e -> {
            NavigationUtil.loadScene("/com/example/launchcompanysundarban/Login.fxml", "Login - Sundarban Launch Company");
            ((Stage) backBtn.getScene().getWindow()).close();
        });

        colRoute.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getRoute()));
        colDate.setCellValueFactory(c -> new javafx.beans.property.SimpleObjectProperty<>(c.getValue().getDate()));
        colFare.setCellValueFactory(c -> new javafx.beans.property.SimpleObjectProperty<>(c.getValue().getFare()));

        tripTable.setOnMouseClicked(this::onTripSelect);
    }

    @FXML
    private void onSearch() {
        validationLabel.setText("");
        String from = fromField.getText().trim();
        String to = toField.getText().trim();
        LocalDate date = datePicker.getValue();

        if (from.isEmpty() || to.isEmpty() || date == null) {
            validationLabel.setText("All fields are required.");
            return;
        }

        List<Trip> trips = DataStore.search(from, to, date);
        if (trips.isEmpty()) {
            validationLabel.setText("No trips found. Try a different date or route.");
        }
        tripTable.setItems(FXCollections.observableArrayList(trips));
    }

    private void onTripSelect(MouseEvent e) {
        Trip selected = tripTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            BookLaunchTripController.setSelectedTrip(selected);
            NavigationUtil.loadCenter("/com/example/launchcompanysundarban/BookLaunchTrip.fxml", GuestUserDashboardController.getInstance().centerStack);
        }
    }
}
