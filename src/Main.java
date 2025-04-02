import controller.OrderController;
import controller.RestaurantController;
import repository.OrderRepository;
import repository.RestaurantRepository;
import service.OrderService;
import service.RestaurantService;
import service.impl.OrderServiceImpl;
import service.impl.RestaurantServiceImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        OrderRepository orderRepository = new OrderRepository();
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        RestaurantService restaurantService = new RestaurantServiceImpl(restaurantRepository);
        OrderService orderService = new OrderServiceImpl(orderRepository, restaurantService);
        OrderController orderController = new OrderController(orderService);
        RestaurantController restaurantController = new RestaurantController(restaurantService);

        orderController.orderFood("order-0","food-1", "restaurant-0");
        orderController.rateOrder("order-0", 3);

        orderController.orderFood("order-1", "restaurant-2", "food-0");
        orderController.rateOrder("order-1", 1);

        orderController.orderFood("order-2", "restaurant-1","food-0");
        orderController.rateOrder("order-2", 3);

        orderController.orderFood("order-3", "restaurant-2","food-0");
        orderController.rateOrder("order-3", 5);

        System.out.println("Printing Restaurants");
        restaurantController.getTopRatedRestaurants().stream().forEach((s)-> System.out.println(s));
        System.out.println("Printing Fooditem");
        restaurantController.getTopRestaurantsByFood("food-0").stream().forEach((s)-> System.out.println(s));
    }
}