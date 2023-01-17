package org.generator;

import org.example.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class TimeTable
{
    private static final Logger logger = LoggerFactory.getLogger(TimeTable.class);
    static ArrayList<String> teams=new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        logger.info("Enter the number of teams for tournament:");
        String team="";
        Integer totalTeams=sc.nextInt();
        for(Integer i=0;i<totalTeams;i++)
        {
            team=sc.next();
            team=team.toUpperCase();
            teams.add(team);
        }
        TimeTableGenerator obj=new TimeTableGenerator();
        obj.generateTimeTable();
    }

}
