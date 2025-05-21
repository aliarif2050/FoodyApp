import java.util.ArrayList;

class Restaurant {
    private String name;
    protected Menu menu;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new Menu();
    }

    public String getName() {
        return name;
    }

    public void addFoodItemToMenu() {
        menu.addFoodItems();
    }

    public void addFoodItemToMenu(FoodItem item) {
        menu.addFoodItems(item);
    }

    public void displayMenu() {
        System.out.println("========================");
        System.out.println("Menu for " + name + ":");
        menu.displayMenu();
        System.out.println("========================");
    }

    public Menu getMenu() {
        return menu;
    }
}

class DesiRestaurant extends Restaurant {

    public DesiRestaurant(String name) {
        super(name);
        this.menu = new DesiMenu();
    }

    @Override
    public void addFoodItemToMenu() {
        menu.addFoodItems();
    }

    @Override
    public void addFoodItemToMenu(FoodItem item) {
        menu.addFoodItems(item);
    }
}
