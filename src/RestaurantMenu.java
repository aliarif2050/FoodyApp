class RestaurantMenu {

    public static Restaurant createKFCMenu() {
        Restaurant kfc = new Restaurant("KFC");
        kfc.addFoodItemToMenu();
        kfc.addFoodItemToMenu(new FoodItem("Chicken Bucket", 1200));
        kfc.addFoodItemToMenu(new FoodItem("French Fries", 250));
        kfc.addFoodItemToMenu(new FoodItem("Coca-Cola", 120));
        return kfc;
    }

    public static Restaurant createPizzaHutMenu() {
        Restaurant pizzaHut = new Restaurant("Pizza Hut");
        pizzaHut.addFoodItemToMenu();
        pizzaHut.addFoodItemToMenu(new FoodItem("Pizza", 1800));
        pizzaHut.addFoodItemToMenu(new FoodItem("Pasta", 1200));
        pizzaHut.addFoodItemToMenu(new FoodItem("Garlic Bread", 300));
        return pizzaHut;
    }

    public static Restaurant createMcDonaldsMenu() {
        Restaurant mcDonalds = new Restaurant("McDonald's");
        mcDonalds.addFoodItemToMenu();
        mcDonalds.addFoodItemToMenu(new FoodItem("Big Mac", 350));
        mcDonalds.addFoodItemToMenu(new FoodItem("Coke", 100));
        mcDonalds.addFoodItemToMenu(new FoodItem("McFlurry", 180));
        return mcDonalds;
    }

    public static Restaurant createDesiRestaurantMenu() {
        Restaurant desiRestaurant = new DesiRestaurant("Desi Restaurant");
        desiRestaurant.addFoodItemToMenu();
        desiRestaurant.addFoodItemToMenu(new FoodItem("Chicken Karahi(half)", 800));
        desiRestaurant.addFoodItemToMenu(new FoodItem("Mutton Karahi(half)", 1100));
        desiRestaurant.addFoodItemToMenu(new FoodItem("Soda", 120));
        return desiRestaurant;
    }

    public static Restaurant createQuettaCafeMenu() {
        Restaurant quettaCafe = new DesiRestaurant("Quetta Cafe");
        quettaCafe.addFoodItemToMenu(new FoodItem("Chicken Paratha", 200));
        quettaCafe.addFoodItemToMenu(new FoodItem("Chicken Cheese Paratha", 250));
        quettaCafe.addFoodItemToMenu(new FoodItem("Mix Paratha", 180));
        quettaCafe.addFoodItemToMenu(new FoodItem("Special Chai", 90));
        return quettaCafe;
    }

    public static Restaurant createRanchersMenu() {
        Restaurant ranchers = new Restaurant("Ranchers");
        ranchers.addFoodItemToMenu(new FoodItem("Krnuch Burgers", 250));
        return ranchers;
    }
}
