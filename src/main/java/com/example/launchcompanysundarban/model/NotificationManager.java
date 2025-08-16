package com.example.launchcompanysundarban.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class NotificationManager {
    private static final ObservableList<Notification> notifications = FXCollections.observableArrayList();
    private static final DateTimeFormatter TS_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static ObservableList<Notification> getNotifications() { return notifications; }

    public static Notification createNotification(Notification.Type type, String title, String message) {
        String id = UUID.randomUUID().toString();
        String ts = LocalDateTime.now().format(TS_FMT);
        Notification n = new Notification(id, type, title, message, ts);
        notifications.add(0, n);
        return n;
    }

    public static void clearAll() { notifications.clear(); }
}
