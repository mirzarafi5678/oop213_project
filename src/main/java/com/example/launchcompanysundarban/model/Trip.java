package com.example.launchcompanysundarban.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Trip {
    private final String id;
    private final String route;
    private LocalDate date;
    private LocalTime time;
    private final String launchId;
    private double fare;
    private String status;
    private String crewId;


    private final int groundDeckCapacity = 100;
    private final int secondDeckCapacity = 80;
    private final Set<Integer> groundDeckBooked = new HashSet<>();
    private final Set<Integer> secondDeckBooked = new HashSet<>();

    public Trip(String id, String route, LocalDate date, LocalTime time,
                String launchId, double fare, String status) {
        this.id = id;
        this.route = route;
        this.date = date;
        this.time = time;
        this.launchId = launchId;
        this.fare = fare;
        this.status = status;
    }

    public String getId() { return id; }
    public String getRoute() { return route; }
    public LocalDate getDate() { return date; }
    public LocalTime getTime() { return time; }
    public String getLaunchId() { return launchId; }
    public double getFare() { return fare; }
    public String getStatus() { return status; }
    public String getCrewId() { return crewId; }

    public void setStatus(String status) { this.status = status; }
    public void setCrewId(String crewId) { this.crewId = crewId; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setTime(LocalTime time) { this.time = time; }
    public void setFare(double fare) { this.fare = fare; }


    public int getGroundDeckCapacity() { return groundDeckCapacity; }
    public int getSecondDeckCapacity() { return secondDeckCapacity; }
    public int getGroundDeckFree() { return groundDeckCapacity - groundDeckBooked.size(); }
    public int getSecondDeckFree() { return secondDeckCapacity - secondDeckBooked.size(); }

    public List<Integer> getAvailableSeats(String deckName) {
        if ("Ground Deck".equalsIgnoreCase(deckName)) {
            return IntStream.rangeClosed(1, groundDeckCapacity)
                    .filter(s -> !groundDeckBooked.contains(s))
                    .boxed().collect(Collectors.toList());
        } else if ("Second Deck".equalsIgnoreCase(deckName) || "2nd Deck".equalsIgnoreCase(deckName)) {
            return IntStream.rangeClosed(1, secondDeckCapacity)
                    .filter(s -> !secondDeckBooked.contains(s))
                    .boxed().collect(Collectors.toList());
        }
        return List.of();
    }

    public boolean reserveSeat(String deckName, int seatNo) {
        if ("Ground Deck".equalsIgnoreCase(deckName)) {
            if (seatNo < 1 || seatNo > groundDeckCapacity || groundDeckBooked.contains(seatNo)) return false;
            groundDeckBooked.add(seatNo);
            return true;
        } else if ("Second Deck".equalsIgnoreCase(deckName) || "2nd Deck".equalsIgnoreCase(deckName)) {
            if (seatNo < 1 || seatNo > secondDeckCapacity || secondDeckBooked.contains(seatNo)) return false;
            secondDeckBooked.add(seatNo);
            return true;
        }
        return false;
    }
}
