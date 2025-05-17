import java.util.ArrayList;
class Restaurant {
    String name;
    Menu menu;
    DesiMenu desi;

    Restaurant(){
        this.menu=new Menu();
    }
    Restaurant(String name){
      this.name=name;
    }
    public void addFoodItemToMenu(){
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
    }

 class DesiRestaurant extends Restaurant{
    DesiRestaurant(String name){
        super(name);
        this.desi= new DesiMenu();
    }
     public void addFoodItemToMenu(){
         desi.addFoodItems();
     }
     public void addFoodItemToMenu(FoodItem item) {
         desi.addFoodItems(item);
    }
     public void displayMenu() {
         System.out.println("========================");
         System.out.println("Menu for " + name + ":");
         desi.displayMenu();
         System.out.println("========================");
     }
 }
