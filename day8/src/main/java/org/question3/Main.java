package org.question3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.commons.lang3.ObjectUtils.max;


public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Item item1 = new Item(1L, "Oppo", 45000, "Mobile");
        Item item2 = new Item(2L, "Bat", 15000, "Sports");
        Item item3 = new Item(3L, "Ball", 10000, "Sports");
        Item item4 = new Item(4L, "Net", 5000, "Sports");
        Item item5 = new Item(5L, "RealMe", 80000, "Mobile");
        Item item6 = new Item(6L, "iPhone", 55000, "Mobile");
        Item item7 = new Item(7L, "Samsung", 95000, "Mobile");

        List<Item> itemList = Arrays.asList(item1, item2, item3, item4, item5, item6, item7);


        Consumer c1 = new Consumer(1L, "Preeti", 2);
        Consumer c2 = new Consumer(2L, "Shivani", 3);
        Consumer c3 = new Consumer(3L, "Anita", 2);

        List<Consumer> consumerList = Arrays.asList(c1, c2, c3);

        Order order1 = new Order(1L, "Confirmed", LocalDate.of(2022, 11, 01), LocalDate.of(2022, 11, 5),
                Arrays.asList(item1, item2), c1);
        Order order2 = new Order(2L, "Confirmed", LocalDate.of(2022, 11, 07), LocalDate.of(2022, 11, 8),
                Arrays.asList(item3, item4), c1);

        Order order3 = new Order(3L, "Confirmed", LocalDate.of(2022, 10, 1), LocalDate.of(2022, 10, 5),
                Arrays.asList(item1, item2), c2);
        Order order4 = new Order(4L, "Confirmed", LocalDate.of(2022, 11, 12), LocalDate.of(2022, 11, 25),
                Arrays.asList(item5, item6), c2);

        Order order5 = new Order(5L, "Confirmed", LocalDate.of(2023, 1, 01), LocalDate.of(2023, 1, 5),
                Arrays.asList(item2, item3), c3);
        Order order6 = new Order(6L, "Confirmed", LocalDate.of(2022, 11, 18), LocalDate.of(2022, 11, 29),
                Arrays.asList(item4, item5), c3);

        List<Order> orderList = Arrays.asList(order1, order2, order3, order4, order5, order6);

        //Get a list of items belonging to the category “Mobile” with price < 50000
        List<Item> names = itemList.stream()
                .filter(item->item.getCategory().equals("Mobile"))
                .filter(item->item.getPrice()<50000)
                .collect(Collectors.toList());

        logger.info(names.toString());

        //Get a list of product with category = “Sports” and then apply 8% discount
        List<Item>sportsList = itemList.stream()
                .filter(item -> item.getCategory()
                        .equals("Sports"))
                .peek(item -> item.setPrice(item.getPrice() - item.getPrice()*0.08))
                .collect(Collectors.toList());

        logger.info(String.valueOf(sportsList));

        //Get a list of items ordered by the consumer of tier 2 between 01-Nov-2022 and
        //01-Jan-2023
        List<Order>order=orderList.stream()
                .filter(o->o.getConsumer().getTier().equals(2))
                .filter(o-> o.getOrderDate().isAfter(LocalDate.of(2022,11,1)) && o.getOrderDate().isBefore(LocalDate.of(2023,1,1)))
                        .collect(Collectors.toList());

                logger.info(String.valueOf(order));


        //Get the expensive item of the “Mobile” category.
        Optional<Item> mostExpensiveMobile = itemList.stream()
                .filter(item -> item.getCategory()
                        .equals("Mobile"))
                .max(Comparator.comparing(Item::getPrice));

        logger.info(String.valueOf(mostExpensiveMobile));

        //Get the 3 most latest placed orders.
        List<Order> latestThreeOrders = orderList.stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .collect(Collectors.toList());

        logger.info(String.valueOf(latestThreeOrders));

        //Get the 3 oldest placed orders

        List<Order> oldestThreeOrders = orderList.stream()
                .sorted(Comparator.comparing(Order::getOrderDate))
                .limit(3)
                .collect(Collectors.toList());

        logger.info(String.valueOf(oldestThreeOrders));

    }


}
