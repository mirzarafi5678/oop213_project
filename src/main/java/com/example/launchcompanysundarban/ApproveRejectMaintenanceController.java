package com.example.launchcompanysundarban;

import com.example.launchcompanysundarban.model.Notification;
import com.example.launchcompanysundarban.model.NotificationManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ApproveRejectMaintenanceController {

    @FXML private Button backBtn;
    @FXML private TableView<MaintenanceRequest> maintenanceTable;
    @FXML private TableColumn<MaintenanceRequest, String> colRequestId;
    @FXML private TableColumn<MaintenanceRequest, String> colLaunchId;
    @FXML private TableColumn<MaintenanceRequest, String> colDescription;
    @FXML private Button approveBtn;
    @FXML private Button rejectBtn;
    @FXML private Label statusLabel;

    @FXML
    public void initialize() {
        backBtn.setOnAction(e ->
                NavigationUtil.goBack(OperationManagerDashboardController.getInstance().centerStack));

        maintenanceTable.setItems(FXCollections.observableArrayList(
                new MaintenanceRequest("M001", "L1", "Engine checkup"),
                new MaintenanceRequest("M002", "L2", "Safety equipment replacement")
        ));

        colRequestId.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getId()));
        colLaunchId.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getLaunchId()));
        colDescription.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDescription()));

        approveBtn.setOnAction(e -> handleDecision("Approved"));
        rejectBtn.setOnAction(e -> handleDecision("Rejected"));
    }

    private void handleDecision(String decision) {
        MaintenanceRequest sel = maintenanceTable.getSelectionModel().getSelectedItem();
        if (sel == null) {
            statusLabel.setText("Select a request.");
            return;
        }
        statusLabel.setStyle("-fx-text-fill: green;");
        statusLabel.setText("Request " + sel.getId() + " " + decision);

        NotificationManager.createNotification(
                "Approved".equals(decision) ? Notification.Type.SUCCESS : Notification.Type.WARNING,
                "Maintenance " + decision,
                sel.getId() + " | " + sel.getLaunchId() + " | " + sel.getDescription()
        );
    }

    public static class MaintenanceRequest {
        private final String id;
        private final String launchId;
        private final String description;

        public MaintenanceRequest(String id, String launchId, String description) {
            this.id = id;
            this.launchId = launchId;
            this.description = description;
        }

        public String getId() { return id; }
        public String getLaunchId() { return launchId; }
        public String getDescription() { return description; }
    }
}
