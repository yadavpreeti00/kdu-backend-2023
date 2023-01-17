package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;

import static org.example.CSVReader.readCSV;

public class Player {

    private static final Logger logger = LoggerFactory.getLogger(Player.class);

    private String playName;

    public Player(String playName, String playerTeam, String playerRole, Integer matches, Integer runs, Double average, Double strikeRate, Integer wickets) {
        this.playName = playName;
        this.playerTeam = playerTeam;
        this.playerRole = playerRole;
        this.matches = matches;
        this.runs = runs;
        this.average = average;
        this.strikeRate = strikeRate;
        this.wickets = wickets;
    }

    private String playerTeam;
    private String playerRole;
    private Integer matches;
    private Integer runs;
    private Double average;
    private Double strikeRate;
    private Integer wickets;

    static ArrayList<Player>playersList=new ArrayList<>();

    public String getPlayName() {
        return playName;
    }

    public void setPlayName(String playName) {
        this.playName = playName;
    }

    public String getPlayerTeam() {
        return playerTeam;
    }

    public void setPlayerTeam(String playerTeam) {
        this.playerTeam = playerTeam;
    }

    public String getPlayerRole() {
        return playerRole;
    }

    public void setPlayerRole(String playerRole) {
        this.playerRole = playerRole;
    }

    public Integer getMatches() {
        return matches;
    }

    public void setMatches(Integer matches) {
        this.matches = matches;
    }

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Double getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(Double strikeRate) {
        this.strikeRate = strikeRate;
    }

    public Integer getWickets() {
        return wickets;
    }

    public void setWickets(Integer wickets) {
        this.wickets = wickets;
    }



}
