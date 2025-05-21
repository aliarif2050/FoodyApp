import java.util.Scanner;

public class RestaurantSelector {

    public static void showRestaurantMenus(Scanner sc, Cart cart) {
        boolean loop = true;
        Restaurant kfc = RestaurantMenu.createKFCMenu();
        Restaurant pizzaHut = RestaurantMenu.createPizzaHutMenu();
        Restaurant mcDonalds = RestaurantMenu.createMcDonaldsMenu();
        Restaurant desiRestaurant = RestaurantMenu.createDesiRestaurantMenu();
        Restaurant quettaCafe = RestaurantMenu.createQuettaCafeMenu();

        while (loop) {
            loop = false;
            System.out.println("Select a restaurant:");
            System.out.println("1. KFC\n2. Pizza Hut\n3. McDonald's\n4. Desi Restaurant\n5. Quetta Cafe");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    handleRestaurantOrdering(kfc, sc, cart);
                    break;
                case 2:
                    handleRestaurantOrdering(pizzaHut, sc, cart);
                    break;
                case 3:
                    handleRestaurantOrdering(mcDonalds, sc, cart);
                    break;
                case 4:
                    handleRestaurantOrdering(desiRestaurant, sc, cart);
                    break;
                case 5:
                    handleRestaurantOrdering(quettaCafe, sc, cart);
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid restaurant.");
                    loop = true;
            }
        }
    }

    private static void handleRestaurantOrdering(Restaurant restaurant, Scanner sc, Cart cart) {
        restaurant.displayMenu();
        System.out.println("Would you like to order something? (Y/N)");
        char option = sc.next().charAt(0);
        if (option == 'Y' || option == 'y') {
            cart.startOrder(restaurant);
            while (true) {
                System.out.println("What would you like to eat from " + restaurant.getName() + " menu?");
                sc.nextLine();
                String select = sc.nextLine();
                boolean found = false;

                for (FoodItem item : restaurant.getMenu().getItems()) {
                    if (item.getName().equalsIgnoreCase(select)) {
                        cart.addItem(item, restaurant);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Item not found!");
                }

                System.out.println("Want to order something else? (Y/N)");
                char choice = sc.next().charAt(0);
                if (choice != 'Y' && choice != 'y') break;
            }
        }
    }
}
