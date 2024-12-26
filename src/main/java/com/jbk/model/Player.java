package com.jbk.model;

public class Player {
    private int playerId; // Unique identifier for each player
    private String name; // Name of the player
    private int age; // Age of the player
    private String teamId; // ID of the team the player belongs to
    private String role; // Player's role (e.g., batsman, bowler, all-rounder)

    // Default constructor
    public Player() {
    }

    // Parameterized constructor
    public Player(int playerId, String name, int age, String teamId, String role) {
        this.playerId = playerId;
        this.name = name;
        this.age = age;
        this.teamId = teamId;
        this.role = role;
    }

    // Getter and Setter for playerId
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter and Setter for teamId
    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    // Getter and Setter for role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // toString method for debugging or display purposes
    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", teamId='" + teamId + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

