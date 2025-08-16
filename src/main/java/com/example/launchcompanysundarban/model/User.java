package com.example.launchcompanysundarban.model;

public class User {
    private final String username;
    private final String displayName;
    private final String password;
    private final String role;

    public User(String username, String displayName, String password, String role) {
        this.username = username;
        this.displayName = displayName;
        this.password = password;
        this.role = role;
    }

    public String getUsername() { return username; }
    public String getDisplayName() { return displayName; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
}
