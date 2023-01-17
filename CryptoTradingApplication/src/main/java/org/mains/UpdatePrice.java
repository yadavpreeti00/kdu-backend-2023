package org.mains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.mains.Transaction.allCoins;

public class UpdatePrice implements  Runnable{

    private static final Logger logger = LoggerFactory.getLogger(UpdatePrice.class);

    private Transaction transaction;

    public UpdatePrice(Transaction transaction)
    {
        this.transaction=transaction;
    }

    public void run()
    {
        synchronized (allCoins.get(transaction.getTransactionCoin()))
        {
            //logger.info(allCoins.get(transaction.getTransactionCoin()).toString());

            String coinSymbol = transaction.getTransactionCoin();
            allCoins.values().stream()
                    .filter(coin -> coin.getSymbol().equals(coinSymbol))
                    .findFirst()
                    .ifPresent(coin -> coin.setPrice(transaction.getTransactionPrice()));

            //logger.info(allCoins.get(transaction.getTransactionCoin()).toString());
        }
    }
}
