package org.mains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static org.mains.BlockHash.getBlockHash;
import static org.mains.Transaction.*;

public class PerformTransaction implements Runnable{

    private static final Logger logger = LoggerFactory.getLogger(PerformTransaction.class);

    public void run() {


        CSVReader readCSV = new CSVReader();
        readCSV.readCSVCoin();
        readCSV.readCSVTrader();

        JSONReader readJSON = new JSONReader();

        try
        {
            readJSON.readingJSON();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

//        logger.info(String.valueOf(allCoins.size()));
//        logger.info(String.valueOf(allTraders.size()));
//        logger.info(String.valueOf(allTransactions.size()));

//        allTraders.forEach((key, value) -> System.out.println(key + " : " + value));
//        allCoins.forEach((key, value) -> System.out.println(key + " : " + value));

        //create a cached thread pool
        ExecutorService executor = Executors.newCachedThreadPool();

        //submit tasks to the thread pool
        for (Transaction transaction : allTransactions)
        {

            if (transaction.getTransactionType().equals("BUY"))
            {
                getBlockHash();
                Runnable task = new Buyer(transaction);
                executor.execute(task);
            }
            else if (transaction.getTransactionType().equals("SELL"))
            {
                getBlockHash();
                Runnable task = new Seller(transaction);
                executor.execute(task);
            }
            else if (transaction.getTransactionType().equals("UPDATE_PRICE"))
            {
                getBlockHash();
                Runnable task = new UpdatePrice(transaction);
                executor.execute(task);
            }
            else if (transaction.getTransactionType().equals("ADD_VOLUME"))
            {
                getBlockHash();
                Runnable task = new AddVolume(transaction);
                executor.execute(task);
            }
        }
        //shutdown the thread pool
        executor.shutdown();
    }
}
