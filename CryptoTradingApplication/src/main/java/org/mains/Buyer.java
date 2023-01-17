package org.mains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.mains.Trader.coinVolumeOfTrader;
import static org.mains.Trader.priceWhileBuying;
import static org.mains.Transaction.allCoins;
import static org.mains.Transaction.allTraders;

public class Buyer implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(Buyer.class);

    private Transaction transaction;

    public Buyer(Transaction transaction) {
        this.transaction = transaction;
    }

    public void run() {

        synchronized (allCoins.get(transaction.getTransactionCoin()))
        {
            if (allCoins.get(transaction.getTransactionCoin()).getCirculatingSupply() < transaction.getTransactionVolume())
            {
                logger.info("Not Enough Coins Present to Buy");
            }
            else
            {
                String walletAddress = transaction.getTransactionWalletAddress();
                String coinSymbol = transaction.getTransactionCoin();
                Long volume = transaction.getTransactionVolume();
                Coin coin = allCoins.get(coinSymbol);
                Trader trader = allTraders.get(walletAddress);

                priceWhileBuying.put(coinSymbol, coin.getPrice());

                if (coinVolumeOfTrader.containsKey(coinSymbol))
                {
                    coinVolumeOfTrader.put(coinSymbol, Math.toIntExact(coinVolumeOfTrader.get(coinSymbol) + volume));
                }
                else
                {
                    coinVolumeOfTrader.put(coinSymbol, Math.toIntExact(volume));
                }

                allTraders.put(trader.getWalletAddress(), trader);

                //decrease coin volume in allCoins List
                allCoins.values().stream()
                        .filter(coinObject -> coinObject.getSymbol().equals(coinSymbol))
                        .findFirst()
                        .ifPresent(coinObject -> coinObject.setCirculatingSupply(coinObject.getCirculatingSupply() - transaction.getTransactionVolume()));


                //logger.info(String.valueOf(transaction));
                //logger.info(String.valueOf(trader));
            }
        }
    }

}