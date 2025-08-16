package com.example.launchcompanysundarban;

import com.example.launchcompanysundarban.model.Notification;
import com.example.launchcompanysundarban.model.NotificationManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class NotificationsController {

    @FXML private Button backBtn;
    @FXML private TableView<Notification> notificationTable;
    @FXML private TableColumn<Notification, String> colType;
    @FXML private TableColumn<Notification, String> colMessage;
    @FXML private TableColumn<Notification, String> colDate;
    @FXML private Button clearBtn;
    @FXML private TextArea detailArea;
    @FXML private TextField replyField;
    @FXML private Button replyBtn;
    @FXML private Label emptyLabel;

    @FXML
    public void initialize() {
        backBtn.setOnAction(e ->
                NavigationUtil.goBack(OperationManagerDashboardController.getInstance().centerStack));

        notificationTable.setItems(NotificationManager.getNotifications());

        colType.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().typeProperty().get()));
        colMessage.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getMessage()));
        colDate.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().dateProperty().get()));

        updateEmptyState();

        NotificationManager.getNotifications().addListener((javafx.collections.ListChangeListener<? super Notification>) c -> updateEmptyState());

        notificationTable.getSelectionModel().selectedItemProperty().addListener((obs, old, cur) -> {
            if (cur != null) {
                detailArea.setText(cur.getMessage() + "\n\nTime: " + cur.dateProperty().get() + "\nType: " + cur.typeProperty().get());
                // Enable reply for support/feedback notifications
                boolean replyable = cur.getMessage().toLowerCase().contains("support") ||
                        cur.getMessage().toLowerCase().contains("feedback");
                replyField.setDisable(!replyable);
                replyBtn.setDisable(!replyable);
            } else {
                detailArea.clear();
                replyField.setDisable(true);
                replyBtn.setDisable(true);
            }
        });

        replyField.setDisable(true);
        replyBtn.setDisable(true);

        replyBtn.setOnAction(e -> {
            Notification sel = notificationTable.getSelectionModel().getSelectedItem();
            if (sel == null) return;
            String reply = replyField.getText().trim();
            if (reply.isEmpty()) return;

            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                    "Send reply?\n\n" + reply, ButtonType.OK, ButtonType.CANCEL);
            confirm.setHeaderText("Confirm Reply");
            confirm.showAndWait().ifPresent(btn -> {
                if (btn == ButtonType.OK) {
                    NotificationManager.createNotification(Notification.Type.SUCCESS, "Support Reply Sent",
                            "Re: " + sel.getMessage() + " | Reply: " + reply);
                    replyField.clear();
                }
            });
        });

        clearBtn.setOnAction(e -> {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                    "Clear all notifications?", ButtonType.OK, ButtonType.CANCEL);
            confirm.setHeaderText("Confirm Clear");
            confirm.showAndWait().ifPresent(btn -> {
                if (btn == ButtonType.OK) {
                    NotificationManager.clearAll();
                    updateEmptyState();
                    detailArea.clear();
                    replyField.clear();
                }
            });
        });
    }

    private void updateEmptyState() {
        boolean isEmpty = NotificationManager.getNotifications().isEmpty();
        emptyLabel.setText(isEmpty ? "No notifications to show." : "");
    }


    public static void addNotification(String title, String message) {
        NotificationManager.createNotification(Notification.Type.INFO, title, message);
    }
}
