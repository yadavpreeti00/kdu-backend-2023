package org.mains;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import static org.mains.Transaction.*;

public class JSONReader {

    private static final Logger logger = LoggerFactory.getLogger(JSONReader.class);

    public static void readingJSON() throws IOException
    {

        String file = "src/main/resources/test_transaction.json";
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = new File(file);
        JsonNode root = mapper.readTree(jsonFile);


        for (JsonNode transaction : root)
        {
            String type = transaction.get("type").textValue();
            JsonNode data = transaction.get("data");
            String coin = data.get("coin").textValue();
            Double price = null;
            String walletAddress;
            Long volume;

            if(type.equals("BUY") )
            {
                Long quantity = data.get("quantity").asLong();
                walletAddress = data.get("wallet_address").textValue();
                Transaction transaction1=new Transaction(type,coin, quantity,walletAddress);
                allTransactions.add(transaction1);
            }
            else if(type.equals("SELL"))
            {
                Long quantity = data.get("quantity").asLong();
                walletAddress = data.get("wallet_address").textValue();
                Transaction transaction1=new Transaction(type,coin, (long) quantity,walletAddress);
                allTransactions.add(transaction1);
            }
            else if(type.equals("UPDATE_PRICE"))
            {
                price=data.get("price").doubleValue();
                Transaction transaction1=new Transaction(type,coin,price);
                allTransactions.add(transaction1);
            }
            else if(type.equals("ADD_VOLUME")){
                volume= data.get("volume").asLong();
                Transaction transaction1=new Transaction(type,coin,volume);
                allTransactions.add(transaction1);
            }
        }
    }
}
