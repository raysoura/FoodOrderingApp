package service;

import java.util.List;

public interface RestaurantService {

    List<String> getTopRestaurantsByFood(String foodItem);

    List<String> getTopRatedRestaurants();

    void rateRestaurant(String restaurant, int rating);

    void rateFoodItem(String foodItem, String restaurant, int rating);
}
