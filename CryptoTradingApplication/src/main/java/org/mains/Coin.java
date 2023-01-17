package org.mains;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Coin {

    private static final Logger logger = LoggerFactory.getLogger(Coin.class);

    private int rank;
    private String name;
    private String symbol;
    private Double price;
    private Long circulatingSupply;


    @Override
    public String toString() {
        return "Coin{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", price='" + price + '\'' +
                ", circulatingSupply='" + circulatingSupply + '\'' +
                '}';
    }

    public Coin(String name, String symbol, Double price, Long circulatingSupply) {
        this.rank = rank;
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.circulatingSupply = circulatingSupply;
    }


    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getCirculatingSupply() {
        return circulatingSupply;
    }

    public void setCirculatingSupply(Long circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }
}
