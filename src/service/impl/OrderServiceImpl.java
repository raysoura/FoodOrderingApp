package service.impl;

import model.Order;
import model.RestaurantRating;
import repository.OrderRepository;
import repository.RestaurantRepository;
import service.OrderService;
import service.RestaurantService;

public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    RestaurantService restaurantService;

    public OrderServiceImpl(OrderRepository orderRepository, RestaurantService restaurantService) {
        this.orderRepository = orderRepository;
        this.restaurantService = restaurantService;
    }

    @Override
    public void orderFood(String order, String restaurant, String foodItem) {
        orderRepository.addOrder(order, restaurant, foodItem);
    }

    @Override
    public void rateOrder(String orderId, int rating) {
        Order order = orderRepository.get(orderId);
        restaurantService.rateRestaurant(order.getRestaurant(), rating);
        restaurantService.rateFoodItem(order.getFoodItem(), order.getRestaurant(), rating);
    }
}
