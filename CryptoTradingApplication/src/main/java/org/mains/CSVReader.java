package org.mains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import static org.mains.Transaction.allCoins;
import static org.mains.Transaction.allTraders;


public class CSVReader {

    private static final Logger logger = LoggerFactory.getLogger(CSVReader.class);

    public static void readCSVCoin()
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/coins.csv"));
            //reading and ignoring first line of csv
            br.readLine();
            String Line;
            while((Line = br.readLine())!=null){

                String []values = Line.split(",");
                String name = values[2];
                String symbol = values[3];
                Double price = Double.parseDouble(values[4]);
                Long circulatingSupply = Long.parseLong(values[5]);
                Coin coin = new Coin(name , symbol , price , circulatingSupply);
                allCoins.put(symbol,coin);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void readCSVTrader()
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/traders.csv"));

            br.readLine();
            String Line;
            while((Line = br.readLine())!=null){

                String []values = Line.split(",");
                String firstName = values[1];
                String lastName = values[2];
                String phone= values[3];
                String walletAddress=values[4];
                Trader trader=new Trader(firstName,lastName,phone,walletAddress);
                allTraders.put(walletAddress,trader);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
