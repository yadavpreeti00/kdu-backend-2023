package org.question3;

public class Item {

    private Long id;
    private String name;
    private double price;
    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Item(Long id, String name, double price, String category){
        this.id=id;
        this.name=name;
        this.price=price;
        this.category=category;
    }

    public String toString(){
        return "ID : "+id +" Name : "+name+" Price : "+price+" Category : "+category;
    }

}
