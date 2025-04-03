package model;

public class RestaurantRating {
    String restaurant;
    double rating;

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public RestaurantRating(String restaurant, int rating) {
        this.restaurant = restaurant;
        this.rating = rating;
    }
}
