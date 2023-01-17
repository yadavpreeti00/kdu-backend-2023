package org.mains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import static org.mains.Trader.priceWhileBuying;
import static org.mains.Transaction.allCoins;
import static org.mains.Transaction.allTraders;


public class Seller implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Seller.class);

    private Transaction transaction;

    public Seller(Transaction transaction)
    {
        this.transaction = transaction;
    }


    public void run()
    {
        synchronized (allCoins.get(transaction.getTransactionCoin()))
        {

            String walletAddress = transaction.getTransactionWalletAddress();
            String coinSymbol = transaction.getTransactionCoin();
            Long transactionVolume = transaction.getTransactionVolume();
            Trader trader = allTraders.get(walletAddress);

            //accessing object through map key
            Coin coin=allCoins.get(coinSymbol);
            Double currentPrice=coin.getPrice();

//            logger.info(coin.toString());
//            logger.info(transaction.toString());
//            logger.info(trader.toString());

            if(!(trader.getCoinVolumeOfTrader().containsKey(coinSymbol)))
            {
                logger.info("Invalid Transaction. Seller does not contain the coin he is trying to sell.");
            }
            else if(trader.getCoinVolumeOfTrader().get(coinSymbol)< transactionVolume)
            {
                logger.info("You don't have sufficient volume of coin to sell.");
            }
            else
            {
                //add coin and volume of coin to trader
                HashMap<String, Integer> sellCoin = trader.getCoinVolumeOfTrader();

                sellCoin.put(coinSymbol, Math.toIntExact(sellCoin.get(coinSymbol) - transactionVolume));

                Double priceDifference=0.0;
                Double priceOfTransactionCoinWhileBuying=0.0;

                if(priceWhileBuying.containsKey(coinSymbol))
                {
                    priceOfTransactionCoinWhileBuying = priceWhileBuying.get(coinSymbol);
                }
                if(priceOfTransactionCoinWhileBuying>currentPrice)
                {
                    priceDifference=priceOfTransactionCoinWhileBuying-currentPrice;
                    trader.setLoss(trader.getLoss()+(transactionVolume*priceDifference));
                }
                else
                {
                    priceDifference=currentPrice-priceOfTransactionCoinWhileBuying;
                    trader.setProfit(trader.getProfit()+(transactionVolume*priceDifference));
                }
                trader.setProfitLoss(trader.getProfitLoss()+(transactionVolume*priceDifference));
                trader.setCoinVolumeOfTrader(sellCoin);
                allTraders.put(trader.getWalletAddress(), trader);

            }
        }
    }
}

