package repository;

import model.Order;

import java.util.*;

public class OrderRepository {
    private Map<String, Order> orderMap;

    public OrderRepository() {
        this.orderMap = new HashMap<>();
    }

    public void addOrder(String order, String restaurant, String foodItem) {
        orderMap.put(order, new Order(order, restaurant, foodItem));
    }

    public Order get(String orderId) {
        return orderMap.get(orderId);
    }



}
