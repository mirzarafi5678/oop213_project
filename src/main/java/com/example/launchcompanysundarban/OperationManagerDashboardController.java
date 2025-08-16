package com.example.launchcompanysundarban;

import com.example.launchcompanysundarban.model.SessionManager;
import com.example.launchcompanysundarban.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class OperationManagerDashboardController {

    private static OperationManagerDashboardController instance;

    public OperationManagerDashboardController() {
        instance = this;
    }

    public static OperationManagerDashboardController getInstance() { return instance; }

    @FXML private Label welcomeLabel;
    @FXML private Button logoutBtn;
    @FXML public StackPane centerStack;
    @FXML private Button notificationsBtn;

    @FXML private Button btnCreateSchedule;
    @FXML private Button btnAssignCrew;
    @FXML private Button btnMarkDelayed;
    @FXML private Button btnCancelTrip;
    @FXML private Button btnMaintenance;
    @FXML private Button btnReportIncident;
    @FXML private Button btnFarePromo;
    @FXML private Button btnFeedback;

    @FXML
    public void initialize() {
        User u = SessionManager.getCurrentUser();
        welcomeLabel.setText(u == null ? "" : "Welcome, " + u.getDisplayName());

        logoutBtn.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to logout?", ButtonType.OK, ButtonType.CANCEL);
            alert.setHeaderText("Confirm Logout");
            alert.showAndWait().ifPresent(btn -> {
                if (btn == ButtonType.OK) {
                    SessionManager.clear();
                    NavigationUtil.clearHistory(centerStack);
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/finalproject_oop213/MirzaMdSufianHridoy_fxml/login-page.fxml"));
                        Scene scene = new Scene(loader.load());
                        Stage stage = (Stage) logoutBtn.getScene().getWindow();
                        stage.setScene(scene);
                        stage.setTitle("Sundarban Launch Company - Login");
                        stage.centerOnScreen();
//                        stage.setMaximized(true);
                        stage.show();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
        });


        btnCreateSchedule.setOnAction(e -> NavigationUtil.loadCenter("/com/example/launchcompanysundarban/CreateAndPublishSchedule.fxml", centerStack));
        btnAssignCrew.setOnAction(e -> NavigationUtil.loadCenter("/com/example/launchcompanysundarban/AssignCrew.fxml", centerStack));
        btnMarkDelayed.setOnAction(e -> NavigationUtil.loadCenter("/com/example/launchcompanysundarban/MarkTripAsDelayed.fxml", centerStack));
        btnCancelTrip.setOnAction(e -> NavigationUtil.loadCenter("/com/example/launchcompanysundarban/CancelOrRemoveTrip.fxml", centerStack));
        btnMaintenance.setOnAction(e -> NavigationUtil.loadCenter("/com/example/launchcompanysundarban/ApproveRejectMaintenance.fxml", centerStack));
        btnReportIncident.setOnAction(e -> NavigationUtil.loadCenter("/com/example/launchcompanysundarban/ReportEmergencyIncident.fxml", centerStack));
        btnFarePromo.setOnAction(e -> NavigationUtil.loadCenter("/com/example/launchcompanysundarban/UpdateFareCreatePromotion.fxml", centerStack));
        btnFeedback.setOnAction(e -> NavigationUtil.loadCenter("/com/example/launchcompanysundarban/ReplyPassengerFeedback.fxml", centerStack));

        notificationsBtn.setOnAction(e -> NavigationUtil.loadCenter("/com/example/launchcompanysundarban/Notifications.fxml", centerStack));
    }
}
