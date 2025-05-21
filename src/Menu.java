import java.util.ArrayList;

class Menu {
    protected ArrayList<FoodItem> items;

    public Menu() {
        items = new ArrayList<>();
    }

    protected void addFastFoodItems() {
        items.add(new FoodItem("Patty Burger", 350));
        items.add(new FoodItem("Pizza", 1800));
        items.add(new FoodItem("Fries", 200));
        items.add(new FoodItem("Soda", 120));
    }

    public void addFoodItems() {
        addFastFoodItems();
    }

    public void addFoodItems(FoodItem item) {
        items.add(item);
    }

    public void displayMenu() {
        for (FoodItem item : items) {
            item.display();
        }
    }

    public ArrayList<FoodItem> getItems() {
        return items;
    }
}

class DesiMenu extends Menu {
    public DesiMenu() {
        super();
    }

    protected void addDesiItems() {
        items.add(new FoodItem("Chicken Karahi(half)", 800));
        items.add(new FoodItem("Mutton Karahi(half)", 1100));
        items.add(new FoodItem("Lassi", 150));
        items.add(new FoodItem("Aloo Paratha", 120));
    }

    @Override
    public void addFoodItems() {
        addDesiItems();
    }
}
