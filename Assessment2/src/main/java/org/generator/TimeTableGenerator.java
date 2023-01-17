package org.generator;

import org.example.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.generator.Match.matchesList;
import static org.generator.TimeTable.teams;
import static org.generator.WriteToCSV.writeToCSV;

public class TimeTableGenerator
{
    private static final Logger logger = LoggerFactory.getLogger(TimeTableGenerator.class);

    int matchesPerDay=2;
    int matchNumber=1;


    LocalDate startDate = LocalDate.of(2023,11,1);
    LocalTime matchTime1= LocalTime.of(6,30);
    LocalTime matchTime2= LocalTime.of(9,30);

    public void generateTimeTable()
    {
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {

                LocalDate matchDate=startDate;

                String teamHome=teams.get(i);
                String teamAway=teams.get(j);
                String ground=teams.get(i);

                matchesList.add(new Match(matchNumber,matchDate,matchTime1,teamHome,teamAway,ground));
                matchNumber++;
                matchesList.add(new Match(matchNumber,matchDate,matchTime2,teamAway,teamHome,ground));
                matchNumber++;
                startDate=startDate.plusDays(1);
            }
        }
        writeToCSV(matchesList, "src/main/resources/output.csv");
        for(Match match:matchesList)
        {
            logger.info(match.toString());
        }
    }

}

