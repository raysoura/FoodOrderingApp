package repository;

import model.RestaurantRating;

import java.util.*;
import java.util.stream.Collectors;

public class RestaurantRepository {

    private Map<String, RestaurantRating> restaurantRating;
    private Map<String, Map<String, RestaurantRating>> foodItemRating;

    public RestaurantRepository() {
        this.restaurantRating = new HashMap<>();
        this.foodItemRating = new HashMap<>();
    }

    public List<RestaurantRating> getTopRestaurantsByFood(String foodItem) {
        Map<String, RestaurantRating> restaurantRatingList = foodItemRating.get(foodItem);
        return restaurantRatingList.values().stream()
                .sorted(Comparator.comparingDouble(RestaurantRating::getRating).reversed()).collect(Collectors.toList());
    }

    public List<String> getTopRatedRestaurants() {
        return restaurantRating.values().stream().sorted(Comparator.comparingDouble(RestaurantRating::getRating).reversed())
                .map((a) -> a.getRestaurant()).collect(Collectors.toList());
    }

    public void rateRestaurant(String restaurant, int rating) {
        synchronized (this) {
            if(!restaurantRating.containsKey(restaurant)) {
                restaurantRating.put(restaurant, new RestaurantRating(restaurant, rating));
            } else {
                RestaurantRating restaurantRating1 = restaurantRating.get(restaurant);
                double newRating = (restaurantRating1.getRating()+rating)/2.0;
                restaurantRating1.setRating(newRating);
            }
        }
    }

    public void rateFoodItem(String foodItem, String restaurant, int rating) {
        synchronized (this) {
            Map<String, RestaurantRating> restaurantRatingList = foodItemRating.getOrDefault(foodItem, new HashMap<>());
            if (!restaurantRatingList.containsKey(restaurant)) {
                restaurantRatingList.put(restaurant, new RestaurantRating(restaurant, rating));
            } else {
                RestaurantRating existingRestaurantRating = restaurantRatingList.get(restaurant);
                double finalRating = (existingRestaurantRating.getRating()+rating)/2.0;
                existingRestaurantRating.setRating(finalRating);
            }
            foodItemRating.put(foodItem, restaurantRatingList);
        }
    }

    public void updateFoodItem(String foodItem, String restaurant) {
        Map<String, RestaurantRating> ratingMap = foodItemRating.getOrDefault(foodItem, new HashMap<>());
        if (!ratingMap.containsKey(restaurant)) {
            ratingMap.put(restaurant, new RestaurantRating(restaurant, 0));
        }
        foodItemRating.put(foodItem, ratingMap);
    }
}
