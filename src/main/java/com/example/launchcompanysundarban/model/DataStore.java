package com.example.launchcompanysundarban.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class DataStore {
    private static final List<Trip> trips = new ArrayList<>();

    static {
        trips.add(new Trip(UUID.randomUUID().toString(), "Dhaka -> Pabna", LocalDate.now().plusDays(2), LocalTime.of(9,0), "L-101", 350.0, "Published"));
        trips.add(new Trip(UUID.randomUUID().toString(), "Dhaka -> Khulna", LocalDate.now().plusDays(5), LocalTime.of(14,30), "L-202", 500.0, "Draft"));
        trips.add(new Trip(UUID.randomUUID().toString(), "Barisal -> Dhaka", LocalDate.now().plusDays(3), LocalTime.of(8,30), "L-050", 420.0, "Published"));
        trips.add(new Trip(UUID.randomUUID().toString(), "Dhaka -> Barisal", LocalDate.now().plusDays(1), LocalTime.of(7,15), "L-077", 480.0, "Published"));
    }

    public static List<Trip> getAllTrips() { return trips; }
    public static List<Trip> getPublishedTrips() {
        return trips.stream().filter(t -> "Published".equalsIgnoreCase(t.getStatus())).collect(Collectors.toList());
    }
    public static List<Trip> getDraftTrips() {
        return trips.stream().filter(t -> "Draft".equalsIgnoreCase(t.getStatus())).collect(Collectors.toList());
    }
    public static void addTrip(String route, LocalDate date, LocalTime time, String launchId, double fare, String status) {
        trips.add(new Trip(UUID.randomUUID().toString(), route, date, time, launchId, fare, status));
    }
    public static Optional<Trip> findById(String id) { return trips.stream().filter(t -> t.getId().equals(id)).findFirst(); }

    public static List<Trip> search(String start, String dest, LocalDate date) {
        return trips.stream().filter(t -> {
            String lower = t.getRoute().toLowerCase();
            boolean routeMatches = (start == null || start.isBlank() || lower.contains(start.toLowerCase()))
                    && (dest == null || dest.isBlank() || lower.contains(dest.toLowerCase()));
            boolean dateMatches = (date == null) || t.getDate().equals(date);
            return routeMatches && dateMatches && "Published".equalsIgnoreCase(t.getStatus());
        }).collect(Collectors.toList());
    }
    public static String labelForTrip(Trip t) {
        return "[" + t.getId() + "] " + t.getRoute() + " (" + t.getDate() + " " + t.getTime() + ")";
    }
    public static Optional<String> extractIdFromLabel(String label) {
        if (label == null) return Optional.empty();
        int a = label.indexOf('[');
        int b = label.indexOf(']');
        if (a >= 0 && b > a) return Optional.of(label.substring(a + 1, b));
        return Optional.empty();
    }
}
