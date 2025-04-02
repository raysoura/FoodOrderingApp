package model;

public class Order {
    String order;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    String restaurant;

    public Order(String order, String restaurant, String foodItem) {
        this.order = order;
        this.restaurant = restaurant;
        this.foodItem = foodItem;
    }

    String foodItem;
}
