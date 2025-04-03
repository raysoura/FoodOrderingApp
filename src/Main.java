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

        orderController.orderFood("order-0", "food-1", "restaurant-0");
        orderController.rateOrder("order-0", 3);
        orderController.orderFood("order-1", "food-0", "restaurant-2");
        orderController.rateOrder("order-1", 1);
        orderController.orderFood("order-2", "food-0", "restaurant-1");
        orderController.rateOrder("order-2",  3);
        orderController.orderFood("order-3", "food-0", "restaurant-2");
        orderController.rateOrder("order-3",  5);
        orderController.orderFood("order-4", "food-0", "restaurant-0");
        orderController.rateOrder("order-4",  3);
        orderController.orderFood("order-5", "food-0", "restaurant-1");
        orderController.rateOrder("order-5",  4);
        orderController.orderFood("order-6", "food-1", "restaurant-0");
        orderController.rateOrder("order-6",  2);
        orderController.orderFood("order-7", "food-1", "restaurant-0");
        orderController.rateOrder("order-7",  2);
        orderController.orderFood("order-8", "food-0", "restaurant-1");
        orderController.rateOrder("order-8",  2);
        orderController.orderFood("order-9", "food-0", "restaurant-1");
        orderController.rateOrder("order-9",  4);


        System.out.println("Printing Fooditem: food-0");
        restaurantController.getTopRestaurantsByFood("food-0").stream().forEach((s)-> System.out.println(s.getRestaurant()+"  "+s.getRating()));
        System.out.println();
        System.out.println("Printing Fooditem: food-1");
        restaurantController.getTopRestaurantsByFood("food-1").stream().forEach((s)-> System.out.println(s.getRestaurant()+"  "+s.getRating()));
        System.out.println();
        System.out.println("Printing Restaurants");
        restaurantController.getTopRatedRestaurants().stream().forEach((s)-> System.out.println(s));
    }
}