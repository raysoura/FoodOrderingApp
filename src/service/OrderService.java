package service;

public interface OrderService {

    void orderFood(String order, String restaurant, String foodItem);

    void rateOrder(String order, int rating);

}
