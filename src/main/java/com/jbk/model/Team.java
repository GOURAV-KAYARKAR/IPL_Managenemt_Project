package com.jbk.model;

public class Team {
    private String teamId; // Unique identifier for each team
    private String teamName; // Name of the team
    private String city; // City the team belongs to
    private String coach; // Name of the team's coach

    // Default constructor
    public Team() {
    }

    // Parameterized constructor
    public Team(String teamId, String teamName, String city, String coach) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.city = city;
        this.coach = coach;
    }

    // Getter and Setter for teamId
    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    // Getter and Setter for teamName
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    // Getter and Setter for city
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Getter and Setter for coach
    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    // toString method for debugging or display purposes
    @Override
    public String toString() {
        return "Team{" +
                "teamId='" + teamId + '\'' +
                ", teamName='" + teamName + '\'' +
                ", city='" + city + '\'' +
                ", coach='" + coach + '\'' +
                '}';
    }
}