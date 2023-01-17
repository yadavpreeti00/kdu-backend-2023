package org.example;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.example.Player.playersList;

public class CSVReader {


    private static final Logger logger =LoggerFactory.getLogger(CSVReader.class);

    public static void readCSV(){

        //ConcurrentHashMap<String,Coin> allCoins = new ConcurrentHashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/IPL_2021_data.csv"));

            //reading and ignoring first line of csv
            br.readLine();
            String Line;
            while((Line = br.readLine())!=null){

                String []values = Line.split(",");
                String name=values[0];
                String team=values[1];
                String role=values[2];
                Integer matches= Integer.valueOf(values[3]);
                Integer runs= Integer.valueOf(values[4]);
                Double average = Double.valueOf(values[5]);
                Double strikeRate= Double.valueOf(values[6]);
                Integer wickets= Integer.valueOf(values[7]);

                //logger.info(name,team,role,matches,runs,average,strikeRate,wickets);

                playersList.add(new Player(name,team,role,matches,runs,average,strikeRate,wickets));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

