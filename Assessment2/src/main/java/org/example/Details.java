package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.ObjectUtils.max;
import static org.example.Player.playersList;

public class Details {

    private static final Logger logger = LoggerFactory.getLogger(Details.class);

    public List<Player> bowlers(String teamName)
    {
        List<Player> players=playersList.stream().filter(player -> player.getPlayerTeam().equalsIgnoreCase(teamName))
                .filter(player -> player.getWickets()>=40)
                .collect(Collectors.toList());

        return players;
    }

    public Player getHighestWicketTaker(String teamName)
    {
        Player highestWicketTaker=playersList.stream()
                .filter(player -> player.getPlayerTeam().equalsIgnoreCase(teamName))
                .max(Comparator.comparing(Player::getWickets))
                .orElse(null);

        return highestWicketTaker;
    }

    public Player getHighestRunScorer(String teamName)
    {
        Player highestRunScorer=playersList.stream()
                .filter(player -> player.getPlayerTeam().equalsIgnoreCase(teamName))
                .max(Comparator.comparing(Player::getRuns))
                .orElse(null);

        return highestRunScorer;
    }

    public List<Player> getTopThreeRunScorers(String teamName)
    {
        List<Player> topThreeRunScorers=playersList.stream()
                .sorted(Comparator.comparing(Player::getRuns).reversed())
                .limit(3)
                .collect(Collectors.toList());

        return topThreeRunScorers;
    }

    public List<Player> getTopThreeWicketTakers(String teamName)
    {
        List<Player> topThreeWicketTakers=playersList.stream()
                .sorted(Comparator.comparing(Player::getWickets).reversed())
                .limit(3)
                .collect(Collectors.toList());

        return topThreeWicketTakers;
    }

}
