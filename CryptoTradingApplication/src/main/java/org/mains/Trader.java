package org.mains;
import java.util.HashMap;

public class Trader {

    private String firstName;
    private String lastName;
    private String phone;
    private String walletAddress;
    static HashMap<String,Double>priceWhileBuying;
    private Double profit=0.0;
    private Double loss=0.0;


    public Double getProfitLoss() {
        return profitLoss;
    }

    public void setProfitLoss(Double profitLoss) {
        this.profitLoss = profitLoss;
    }

    private Double profitLoss;
    static HashMap<String,Integer>coinVolumeOfTrader;

    public HashMap<String, Double> getPriceWhileBuying() {
        return priceWhileBuying;
    }

    public void setPriceWhileBuying(HashMap<String, Double> priceWhileBuying) {
        this.priceWhileBuying = priceWhileBuying;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getLoss() {
        return loss;
    }

    public void setLoss(Double loss) {
        this.loss = loss;
    }

    public HashMap<String, Integer> getCoinVolumeOfTrader() {
        return coinVolumeOfTrader;
    }


    public void setCoinVolumeOfTrader(HashMap<String, Integer> coinVolumeOfTrader) {
        this.coinVolumeOfTrader = coinVolumeOfTrader;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }


    @Override
    public String toString() {
        return "Trader{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", walletAddress='" + walletAddress + '\'' +
                ", profit=" + profit +
                ", loss=" + loss +
                ", coinVolume="+coinVolumeOfTrader+
                ", coinPriceWhileBuying"+priceWhileBuying+
                '}';
    }


    public Trader(String firstName, String lastName, String phone, String walletAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.walletAddress = walletAddress;
        this.coinVolumeOfTrader=new HashMap<>();
        this.priceWhileBuying=new HashMap<>();
        this.profit=0.0;
        this.loss=0.0;
        this.profitLoss=0.0;
    }

}
