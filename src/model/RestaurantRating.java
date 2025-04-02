package model;

public class RestaurantRating {
    String restaurant;
    int rating;

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public RestaurantRating(String restaurant, int rating) {
        this.restaurant = restaurant;
        this.rating = rating;
    }
}
