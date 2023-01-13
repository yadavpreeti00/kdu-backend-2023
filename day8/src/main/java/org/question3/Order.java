package org.question3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<Item> getProduct() {
        return product;
    }

    public void setProduct(List<Item> product) {
        this.product = product;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Item>product = new ArrayList<Item>();
    private Consumer consumer;

    public String toString(){
        return "Order Id : "+id+", Status : "+status+", OrderDate : "+orderDate+", Delivery Date : "+deliveryDate+", Item List : "+product+", Consumer : "+consumer;
    }

    public Order(Long id,String status,LocalDate orderDate,LocalDate deliveryDate,List<Item> product,Consumer consumer){
        this.id=id;
        this.status =status;
        this.orderDate=orderDate;
        this.deliveryDate=deliveryDate;
        this.product=product;
        this.consumer=consumer;
    }

}
