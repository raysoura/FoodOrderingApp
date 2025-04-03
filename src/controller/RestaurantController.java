package controller;

import model.RestaurantRating;
import service.RestaurantService;

import java.util.List;

public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    public List<RestaurantRating> getTopRestaurantsByFood(String foodItem) {
        return restaurantService.getTopRestaurantsByFood(foodItem);
    }

    public List<String> getTopRatedRestaurants() {
        return restaurantService.getTopRatedRestaurants();
    }
}
