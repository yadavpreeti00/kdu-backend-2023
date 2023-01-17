package org.mains;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Transaction {
    private static final Logger logger = LoggerFactory.getLogger(Transaction.class);

    //using concurrent hashmap and copyOnWriteArray to avoid race condition (concurrent access)
    static ConcurrentHashMap<String,Coin> allCoins=new ConcurrentHashMap<>();
    static ConcurrentHashMap<String,Trader> allTraders=new ConcurrentHashMap<>();
    static CopyOnWriteArrayList<Transaction> allTransactions=new CopyOnWriteArrayList<>();

    private String transactionType;
    private String transactionCoin;
    private String transactionWalletAddress;
    private Double transactionPrice;
    private Long transactionVolume;


    @Override
    public String toString() {
        return "Transaction{" +
                "transactionType='" + transactionType + '\'' +
                ", transactionCoin='" + transactionCoin + '\'' +
                ", transactionWalletAddress='" + transactionWalletAddress + '\'' +
                ", transactionPrice=" + transactionPrice +
                ", transactionVolume=" + transactionVolume +
                '}';
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionCoin() {
        return transactionCoin;
    }

    public void setTransactionCoin(String transactionCoin) {
        this.transactionCoin = transactionCoin;
    }

    public String getTransactionWalletAddress() {
        return transactionWalletAddress;
    }

    public void setTransactionWalletAddress(String transactionWalletAddress) {
        this.transactionWalletAddress = transactionWalletAddress;
    }

    public Double getTransactionPrice() {
        return transactionPrice;
    }

    public void setTransactionPrice(Double transactionPrice) {
        this.transactionPrice = transactionPrice;
    }

    public Long getTransactionVolume() {
        return transactionVolume;
    }

    public void setTransactionVolume(Long transactionVolume) {
        this.transactionVolume = transactionVolume;
    }


    //buy sell
    public Transaction(String type,String transactionCoin,Long transactionVolume,String transactionWalletAddress){
        this.transactionType=type;
        this.transactionCoin=transactionCoin;
        this.transactionVolume=transactionVolume;
        this.transactionWalletAddress=transactionWalletAddress;
    }

    //update price
    public Transaction(String type,String transactionCoin,Double transactionPrice){
        this.transactionType=type;
        this.transactionCoin=transactionCoin;
        this.transactionPrice=transactionPrice;

    }

    //add volume
    public Transaction(String type,String transactionCoin,Long transactionVolume){
        this.transactionType=type;
        this.transactionType=transactionCoin;
        this.transactionVolume=transactionVolume;
    }

}