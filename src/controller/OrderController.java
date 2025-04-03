package controller;

import service.OrderService;

public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void orderFood(String order, String foodItem, String restaurant) {
        orderService.orderFood(order, restaurant, foodItem);
    }

    public void rateOrder(String order, int rating) {
        orderService.rateOrder(order, rating);
    }
}
