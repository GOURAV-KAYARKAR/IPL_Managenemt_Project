package com.jbk.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Match_Info {
	@Id
    private int matchId; // Unique identifier for each match
    private String teamOneId; // ID of the first team in the match
    private String teamTwoId; // ID of the second team in the match
    private String date; // Match date in yyyy-MM-dd format
    private String venue; // Venue of the match
    private String result; // Result of the match (e.g., 'Team1 won', 'Team2 won', 'Draw')

    // Default constructor
    public Match_Info() {
    }

    // Parameterized constructor
    public Match_Info(int matchId, String teamOneId, String teamTwoId, String date, String venue, String result) {
        this.matchId = matchId;
        this.teamOneId = teamOneId;
        this.teamTwoId = teamTwoId;
        this.date = date;
        this.venue = venue;
        this.result = result;
    }

    // Getters and Setters
    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getTeamOneId() {
        return teamOneId;
    }

    public void setTeamOneId(String teamOneId) {
        this.teamOneId = teamOneId;
    }

    public String getTeamTwoId() {
        return teamTwoId;
    }

    public void setTeamTwoId(String teamTwoId) {
        this.teamTwoId = teamTwoId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    // toString method for debugging and logging
    @Override
    public String toString() {
        return "Match [matchId=" + matchId + ", teamOneId=" + teamOneId + ", teamTwoId=" + teamTwoId +
               ", date=" + date + ", venue=" + venue + ", result=" + result + "]";
    }
}
