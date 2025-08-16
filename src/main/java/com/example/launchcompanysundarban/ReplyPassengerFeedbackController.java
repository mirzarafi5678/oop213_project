package com.example.launchcompanysundarban;

import com.example.launchcompanysundarban.model.Notification;
import com.example.launchcompanysundarban.model.NotificationManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ReplyPassengerFeedbackController {

    @FXML private Button backBtn;
    @FXML private TableView<Feedback> feedbackTable;
    @FXML private TableColumn<Feedback, String> colPassenger;
    @FXML private TableColumn<Feedback, String> colFeedback;
    @FXML private TextField replyField;
    @FXML private Button replyBtn;
    @FXML private Label statusLabel;

    @FXML
    public void initialize() {
        backBtn.setOnAction(e ->
                NavigationUtil.goBack(OperationManagerDashboardController.getInstance().centerStack));

        feedbackTable.setItems(FXCollections.observableArrayList(
                new Feedback("John Doe", "Service was good."),
                new Feedback("Jane Smith", "Need more safety instructions."),
                new Feedback("Ayesha Rahman", "Cabin was clean. Good job."),
                new Feedback("Rafiul Karim", "Ticketing queue was long.")
        ));

        colPassenger.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPassenger()));
        colFeedback.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getFeedback()));

        replyBtn.setOnAction(e -> {
            Feedback sel = feedbackTable.getSelectionModel().getSelectedItem();
            if (sel == null) {
                statusLabel.setText("Select a feedback.");
                return;
            }
            String reply = replyField.getText().trim();
            if (reply.isEmpty()) {
                statusLabel.setText("Enter a reply.");
                return;
            }
            statusLabel.setStyle("-fx-text-fill: green;");
            statusLabel.setText("Replied to " + sel.getPassenger() + ": " + reply);
            NotificationManager.createNotification(Notification.Type.SUCCESS,
                    "Feedback Replied",
                    sel.getPassenger() + " | \"" + sel.getFeedback() + "\" | Reply: " + reply);
            replyField.clear();
        });
    }

    public static class Feedback {
        private final String passenger;
        private final String feedback;

        public Feedback(String passenger, String feedback) {
            this.passenger = passenger;
            this.feedback = feedback;
        }

        public String getPassenger() { return passenger; }
        public String getFeedback() { return feedback; }
    }
}
