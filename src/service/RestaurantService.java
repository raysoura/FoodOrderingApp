package service;

import model.RestaurantRating;

import java.util.List;

public interface RestaurantService {

    List<RestaurantRating> getTopRestaurantsByFood(String foodItem);

    List<String> getTopRatedRestaurants();

    void rateRestaurant(String restaurant, int rating);

    void rateFoodItem(String foodItem, String restaurant, int rating);

}
