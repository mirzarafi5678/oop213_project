package com.example.launchcompanysundarban.model;

public class SessionManager {
    private static User currentUser;

    public static void setCurrentUser(User user) { currentUser = user; }
    public static User getCurrentUser() { return currentUser; }
    public static void clear() { currentUser = null; }
}
