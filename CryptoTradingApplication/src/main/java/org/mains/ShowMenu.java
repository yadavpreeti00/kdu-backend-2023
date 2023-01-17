package org.mains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShowMenu implements Runnable{

    private static final Logger logger = LoggerFactory.getLogger(Transaction.class);

    Scanner sc=new Scanner(System.in);
    @Override
    public void run()
    {
        UserMenu obj=new UserMenu();
        boolean run=true;

        while(run)
        {
            logger.info("Select the below options to get the details:");
            logger.info("1. Retrieve details of a particular");
            logger.info("2. Display top 50 coins in the market based on price");
            logger.info("3. See the portfolio of a particular trader");
            logger.info("4. Display the total profit and loss of a particular trader");
            logger.info("5. See the top 5 and bottom 5 traders based on their profit/loss");

            logger.info("Enter choice 1, 2, 3,4 ,5. Press any other key to exit:");

            String walletAddress;

            Integer choice=0;
            try
            {
                choice = sc.nextInt();
            }
            catch(InputMismatchException e)
            {
                logger.info("Invalid Choice "+e);
            }


            switch (choice)
            {
                case 1:
                    logger.info("Enter the coin symbol :\n");
                    String coinSymbol=sc.next();
                    logger.info("The details of "+coinSymbol+" are:");
                    obj.getCoinDetails(coinSymbol);
                    break;

                case 2:
                    logger.info("Top Fifty Coins are:");
                    obj.getTopFiftyCoins();
                    break;

                case 3:
                    logger.info("Enter wallet address of the trader to see his/her portfolio:");
                    walletAddress=sc.next();
                    obj.showTraderPortfolio(walletAddress);
                    break;

                case 4:
                    logger.info("Enter wallet address of the trader to see his/her profit loss:");
                    walletAddress=sc.next();
                    obj.showTraderProfitLoss(walletAddress);
                    break;
                case 5:
                    logger.info("Top 5 Traders are :");
                    obj.getTopFiveTrader();
                    logger.info("Bottom 5 Traders are :");
                    obj.getBottomFiveTrader();
                    break;
                default:
                    logger.info("Exiting...");
                    run=false;
            }

        }
    }
}
