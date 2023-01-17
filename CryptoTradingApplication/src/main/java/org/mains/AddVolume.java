package org.mains;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.mains.Transaction.allCoins;

public class AddVolume implements Runnable
{
    private static final Logger logger = LoggerFactory.getLogger(AddVolume.class);
    private Transaction transaction;
    public AddVolume(Transaction transaction)
    {
        this.transaction=transaction;
    }

    public void run()
    {
        synchronized (allCoins.get(transaction.getTransactionCoin()))
        {
            //logger.info(allCoins.get(transaction.getTransactionCoin()).toString());

            String coinSymbol = transaction.getTransactionCoin();
            allCoins.values().stream().filter(coin -> coin.getSymbol().equals(coinSymbol))
                    .findFirst()
                    .ifPresent(coin -> coin.setCirculatingSupply(transaction.getTransactionVolume()));

            //logger.info(allCoins.get(transaction.getTransactionCoin()).toString());
        }
    }
}
