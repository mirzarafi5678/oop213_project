package com.example.launchcompanysundarban;

import com.example.launchcompanysundarban.model.DataStore;
import com.example.launchcompanysundarban.model.Notification;
import com.example.launchcompanysundarban.model.NotificationManager;
import com.example.launchcompanysundarban.model.Trip;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AssignCrewController {

    @FXML private Button backBtn;
    @FXML private CheckBox onlyUnassigned;
    @FXML private TableView<Trip> tripsTable;
    @FXML private TableColumn<Trip, String> colTripId;
    @FXML private TableColumn<Trip, String> colRoute;
    @FXML private TableColumn<Trip, String> colDate;
    @FXML private TableColumn<Trip, String> colTime;
    @FXML private TableColumn<Trip, String> colCrew;
    @FXML private TextField crewField;
    @FXML private Button assignBtn;
    @FXML private Label statusLabel;

    private FilteredList<Trip> filtered;

    @FXML
    public void initialize() {
        backBtn.setOnAction(e ->
                NavigationUtil.goBack(OperationManagerDashboardController.getInstance().centerStack));

        filtered = new FilteredList<>(FXCollections.observableArrayList(DataStore.getPublishedTrips()), t -> true);
        tripsTable.setItems(filtered);

        onlyUnassigned.selectedProperty().addListener((obs, old, now) -> {
            filtered.setPredicate(t -> !now || t.getCrewId() == null || t.getCrewId().isBlank());
        });

        colTripId.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getId()));
        colRoute.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getRoute()));
        colDate.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDate().toString()));
        colTime.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getTime().toString()));
        colCrew.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCrewId() == null ? "" : c.getValue().getCrewId()));

        assignBtn.setOnAction(e -> {
            Trip sel = tripsTable.getSelectionModel().getSelectedItem();
            if (sel == null) {
                statusLabel.setText("Select a trip first.");
                return;
            }
            String crew = crewField.getText().trim();
            if (crew.isEmpty()) {
                statusLabel.setText("Enter crew member name.");
                return;
            }

            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                    "Assign \"" + crew + "\" to trip " + sel.getId() + " (" + sel.getRoute() + ")?",
                    ButtonType.OK, ButtonType.CANCEL);
            confirm.setHeaderText("Confirm Crew Assignment");
            confirm.showAndWait().ifPresent(btn -> {
                if (btn == ButtonType.OK) {
                    sel.setCrewId(crew);
                    tripsTable.refresh();
                    statusLabel.setStyle("-fx-text-fill: green;");
                    statusLabel.setText("Assigned " + crew + " to trip " + sel.getId());

                    NotificationManager.createNotification(Notification.Type.INFO,
                            "Crew Assigned",
                            "Trip " + sel.getId() + " | " + sel.getRoute() + " | Crew: " + crew);

                    crewField.clear();
                }
            });
        });
    }
}
