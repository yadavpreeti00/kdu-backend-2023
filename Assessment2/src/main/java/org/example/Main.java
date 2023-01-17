package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static org.example.CSVReader.readCSV;
import static org.example.Player.playersList;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args)
    {
            readCSV();
            //logger.info(String.valueOf(playersList.size()));

            Scanner sc=new Scanner(System.in);
            Details obj = new Details();

            boolean run=true;

            while(run)
            {
                logger.info("Select the options to get the given details of IPL TOURNAMENT 2021");
                logger.info("1. Get all the bowlers who have taken at least 40 wickets of your favourite team.");
                logger.info("2. Get the details of highest wicket taker and highest run scorer of your favourite team.");
                logger.info("3. Get the top 3 run-scorer and top 3 wicket-takers of the season.");

                logger.info("Enter choice 1 , 2 or 3. Press any other key to exit:");

                Integer choice=0;
                try
                {
                    choice = sc.nextInt();
                }
                catch(InputMismatchException e)
                {
                    logger.info("Invalid Choice "+e);
                }
                String team;

                switch (choice)
                {
                    case 1:
                        logger.info("Enter Team Name :\n");
                        team=sc.next();

                        logger.info("The bowlers who have taken at least 40 wickets of "+team+" are :");

                        List<Player> moreThan40Wickets = obj.bowlers(team);
                        for (Player player : moreThan40Wickets) {
                            logger.info(player.getPlayerTeam() + " " + player.getPlayName() + " " + player.getWickets());
                        }
                        logger.info("");
                        break;

                    case 2:
                        logger.info("Enter Team Name :\n");
                        team=sc.next();
                        Player highestWicketTaker = obj.getHighestWicketTaker(team);
                        logger.info("Highest Wicket Taker of "+team+" : ");
                        logger.info(highestWicketTaker.getPlayerTeam() + " " + highestWicketTaker.getPlayName() + " " + highestWicketTaker.getWickets());
                        logger.info("");
                        logger.info("Highest Run Scorer of "+team+" : ");
                        Player highestRunScorer = obj.getHighestRunScorer(team);
                        logger.info(highestRunScorer.getPlayerTeam() + " " + highestRunScorer.getPlayName() + " " + highestRunScorer.getRuns());
                        logger.info("");
                        break;

                    case 3:
                        logger.info("Enter Team Name :\n");
                        team=sc.next();

                        logger.info("Top Three Run Scorers of Tournament\n");
                        List<Player> topThreeRunScorers = obj.getTopThreeRunScorers(team);
                        for (Player player : topThreeRunScorers) {
                            logger.info(player.getPlayerTeam() + " " + player.getPlayName() + " " + player.getRuns());
                        }
                        logger.info("");

                        logger.info("Top Three Wicket Takers of Tournament\n");
                        List<Player> topThreeWicketTakers = obj.getTopThreeWicketTakers(team);
                        for (Player player : topThreeWicketTakers) {
                            logger.info(player.getPlayerTeam() + " " + player.getPlayName() + " " + player.getWickets());
                        }
                        logger.info("");
                        break;

                    default:
                        logger.info("Exiting...");
                        run=false;
                }

            }
    }
}