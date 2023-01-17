package org.generator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Match {

    private Integer matchNumber;
    private LocalDate matchDate;
    private LocalTime matchTime;
    private String teamHome;
    private String teamAway;
    private String Ground;

    public Match(Integer matchNumber, LocalDate matchDate, LocalTime matchTime, String teamHome, String teamAway, String ground) {
        this.matchNumber = matchNumber;
        this.matchDate = matchDate;
        this.matchTime = matchTime;
        this.teamHome = teamHome;
        this.teamAway = teamAway;
        Ground = ground;
    }

    @Override
    public String toString() {
        return "Match{" +
                "matchNumber=" + matchNumber +
                ", matchDate=" + matchDate +
                ", matchTime=" + matchTime +
                ", teamHome='" + teamHome + '\'' +
                ", teamAway='" + teamAway + '\'' +
                ", Ground='" + Ground + '\'' +
                '}';
    }

    static List<Match> matchesList=new ArrayList<>();
    public Integer getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(Integer matchNumber) {
        this.matchNumber = matchNumber;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public LocalTime getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(LocalTime matchTime) {
        this.matchTime = matchTime;
    }

    public String getTeamHome() {
        return teamHome;
    }

    public void setTeamHome(String teamHome) {
        this.teamHome = teamHome;
    }

    public String getTeamAway() {
        return teamAway;
    }

    public void setTeamAway(String teamAway) {
        this.teamAway = teamAway;
    }

    public String getGround() {
        return Ground;
    }

    public void setGround(String ground) {
        Ground = ground;
    }
}
