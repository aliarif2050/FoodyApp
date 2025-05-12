import java.util.ArrayList;
import java.util.List;

class Cart {
    private List<FoodItem> items;
    private double total;
    private Restaurant currentRestaurant;

    public Cart() {
        this.items = new ArrayList<>();
        this.total = 0.0;
        this.currentRestaurant = null;
    }

    public void startOrder(Restaurant restaurant) {
        if (currentRestaurant != null && !currentRestaurant.equals(restaurant)) {
            System.out.println("⚠️ You already have items from " + currentRestaurant.name
                    + " in your cart. Clear cart or checkout first!");
            return;
        }
        this.currentRestaurant = restaurant;
        System.out.println("🛒 Now ordering from: " + restaurant.name);
    }

    public void addItem(FoodItem item, Restaurant restaurant) {
        if (currentRestaurant == null) {
            startOrder(restaurant); // Auto-bind if no restaurant selected
        }
        if (!restaurant.equals(currentRestaurant)) {
            System.out.println("❌ Can't add items from multiple restaurants!");
            return;
        }
        items.add(item);
        total += item.getPrice();
        System.out.println("✅ Added " + item.getName() + " to your cart!");
    }

    public void removeItem(String itemName) {
        boolean removed = false;
        for (FoodItem item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                items.remove(item);
                total -= item.getPrice();
                System.out.println("❌ Removed " + item.getName());
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("⚠️ " + itemName + " not found in cart.");
        }
    }
    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("🛒 Your cart is empty!");
        } else {
            System.out.println("\n🛒 YOUR CART (" + currentRestaurant.name + "):");
            for (FoodItem item : items) {
                System.out.println("- " + item.getName() + " (₹" + item.getPrice() + ")");
            }
            System.out.println("💵 TOTAL: ₹" + total);
        }
    }

    public void checkout() {
        if (items.isEmpty()) {
            System.out.println("🛒 Cart is empty. Add items first!");
        } else {
            System.out.println("💰 Total Bill: ₹" + total);
            System.out.println("✅ Order placed from " + currentRestaurant.name + "!");
            clearCart();
        }
    }

    // Clear cart
    public void clearCart() {
        items.clear();
        total = 0.0;
        currentRestaurant = null;
    }
    public int cartState(){
        if(items.isEmpty()){
            System.out.println("🛒 Cart is empty. Add items first!");;
            return 0;
        }
        else return 1;

    }
    public void applyCreditCardDiscount(CreditCard card){
        total-= card.discount();
        System.out.println("Discount of "+ card.discount() + " has been applied!");
    }
    public void applyDebitCardDiscount(DebitCard card){
        total-= card.discount();
        System.out.println("Discount of "+ card.discount() + " has been applied!");
    }
}
