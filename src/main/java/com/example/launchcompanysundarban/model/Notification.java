package com.example.launchcompanysundarban.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Notification {

    public enum Type { INFO, WARNING, ERROR, SUCCESS }

    private final StringProperty type;
    private final StringProperty message;
    private final StringProperty date;

    public Notification(String type, String message, String date) {
        this.type = new SimpleStringProperty(type);
        this.message = new SimpleStringProperty(message);
        this.date = new SimpleStringProperty(date);
    }

    public Notification(String id, Type type, String title, String message, String meta) {
        this.type = new SimpleStringProperty(type.name());
        this.message = new SimpleStringProperty((title == null || title.isBlank() ? "" : (title + ": ")) + message);
        this.date = new SimpleStringProperty(meta);
    }

    public StringProperty typeProperty() { return type; }
    public StringProperty messageProperty() { return message; }
    public StringProperty dateProperty() { return date; }
    public String getMessage() { return message.get(); }
}
