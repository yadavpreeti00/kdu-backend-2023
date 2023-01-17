package org.mains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Comparator;
import java.util.Map;
import static org.mains.Transaction.allCoins;
import static org.mains.Transaction.allTraders;

public class UserMenu {

    private static final Logger logger = LoggerFactory.getLogger(Transaction.class);
    public void getCoinDetails(String coinSymbol)
    {
        if(!(allCoins.containsKey(coinSymbol)))
        {
            logger.info("Invalid coin. Please Enter correct symbol.");
        }
        else
        {
            Coin coin=allCoins.get(coinSymbol);
            logger.info(coin.toString());
        }
    }


    public void getTopFiftyCoins()
    {
        allCoins.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparingDouble(Coin::getPrice).reversed()))
                .limit(50)
                .forEach(System.out::println);
    }

    public void showTraderPortfolio(String walletAddress)
    {
        Trader trader=allTraders.get(walletAddress);
        logger.info(trader.toString());
    }

    public void showTraderProfitLoss(String walletAddress)
    {
        Trader trader=allTraders.get(walletAddress);
        logger.info("Profit of "+trader.getFirstName()+" "+trader.getLastName()+" is: "+trader.getProfit()+" and Loss is: "+trader.getLoss());
    }

    public void getTopFiveTrader()
    {
        allTraders.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparingDouble(Trader::getProfitLoss)))
                .limit(5)
                .forEach(System.out::println);
    }

    public void getBottomFiveTrader()
    {
        allTraders.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparingDouble(Trader::getProfitLoss).reversed()))
                .limit(5)
                .forEach(System.out::println);
    }

}
