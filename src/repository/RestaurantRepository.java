package repository;

import model.RestaurantRating;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RestaurantRepository {

    private Map<String, RestaurantRating> restaurantRating;
    private Map<String, RestaurantRating> foodItemRating;

    public RestaurantRepository() {
        this.restaurantRating = new HashMap<>();
        this.foodItemRating = new HashMap<>();
    }

    public List<String> getTopRestaurantsByFood(String foodItem) {
        return foodItemRating.values().stream().sorted((a, b) -> b.getRating()-a.getRating())
                .map((a) -> a.getRestaurant()).collect(Collectors.toList());
    }

    public List<String> getTopRatedRestaurants() {
        return restaurantRating.values().stream().sorted((a, b) -> b.getRating()-a.getRating())
                .map((a) -> a.getRestaurant()).collect(Collectors.toList());
    }

    public void rateRestaurant(String restaurant, int rating) {
        synchronized (this) {
            restaurantRating.put(restaurant, new RestaurantRating(restaurant, rating));
        }
    }

    public void rateFoodItem(String foodItem, String restaurant, int rating) {
        synchronized (this) {
            foodItemRating.put(foodItem, new RestaurantRating(restaurant, rating));
        }
    }
}
