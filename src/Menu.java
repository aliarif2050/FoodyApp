import java.util.ArrayList;

class Menu {
    protected ArrayList<FoodItem> items;

    public Menu() {
        items = new ArrayList<>();
    }
    void fastFoodRes(){
        items.add(new FoodItem("Patty Burger", 350));
        items.add(new FoodItem("Pizza", 1800));
        items.add(new FoodItem("Fries", 200));
        items.add(new FoodItem("Soda", 120));
    }
    void addFoodItems(){
        fastFoodRes();
    }
    void addFoodItems(FoodItem item){
        items.add(item);
    }
    public void displayMenu() {
        for (FoodItem item : items) {
            item.display();
        }
    }
}
class DesiMenu extends Menu{
     DesiMenu(){
        super();
    }
   void desiRes()
   {
       items.add(new FoodItem("Chicken Karahi(half)", 800));
       items.add(new FoodItem("Mutton Karahi(half)", 1100));
       items.add(new FoodItem("Lassi", 150));
       items.add(new FoodItem("Aloo Paratha", 120));
   }
    void addFoodItems(){
        desiRes();
    }
    @Override
    void addFoodItems(FoodItem item) {
        super.addFoodItems(item);
    }

    @Override
    public void displayMenu() {
        super.displayMenu();
    }
}