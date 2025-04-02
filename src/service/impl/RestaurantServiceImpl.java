package service.impl;

import repository.RestaurantRepository;
import service.RestaurantService;

import java.util.List;

public class RestaurantServiceImpl implements RestaurantService {
    RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {

        this.restaurantRepository = restaurantRepository;
    }
    @Override
    public List<String> getTopRestaurantsByFood(String foodItem) {
        return restaurantRepository.getTopRestaurantsByFood(foodItem);
    }

    @Override
    public List<String> getTopRatedRestaurants() {
        return restaurantRepository.getTopRatedRestaurants();
    }

    public void rateRestaurant(String restaurant, int rating) {
        restaurantRepository.rateRestaurant(restaurant, rating);
    }

    public void rateFoodItem(String foodItem, String restaurant, int rating) {
        restaurantRepository.rateFoodItem(foodItem, restaurant, rating);
    }
}
