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
            System.out.println("Warning: You already have items from " + currentRestaurant.getName()
                    + " in your cart. Clear cart or checkout first!");
            return;
        }
        this.currentRestaurant = restaurant;
        System.out.println("Now ordering from: " + restaurant.getName());
    }

    public void addItem(FoodItem item, Restaurant restaurant) {
        if (currentRestaurant == null) {
            startOrder(restaurant);
        }
        if (!restaurant.equals(currentRestaurant)) {
            System.out.println("Error: Can't add items from multiple restaurants!");
            return;
        }
        items.add(item);
        total += item.getPrice();
        System.out.println("Added " + item.getName() + " to your cart!");
    }

    public void removeItem(String itemName) {
        boolean removed = false;
        for (FoodItem item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                items.remove(item);
                total -= item.getPrice();
                System.out.println("Removed " + item.getName());
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Warning: " + itemName + " not found in cart.");
        }
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty!");
        } else {
            System.out.println("\nYOUR CART (" + currentRestaurant.getName() + "):");
            for (FoodItem item : items) {
                System.out.println("- " + item.getName() + " (Rs " + item.getPrice() + ")");
            }
            System.out.println("TOTAL: Rs " + total);
        }
    }

    public void checkout() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty. Add items first!");
        } else {
            System.out.println("Total Bill: Rs " + total);
            System.out.println("Order placed from " + currentRestaurant.getName() + "!");
            clearCart();
        }
    }

    public void clearCart() {
        items.clear();
        total = 0.0;
        currentRestaurant = null;
    }

    public int isCartEmpty() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty. Add items first!");
            return 0;
        }
        else return 1;
    }

    public void applyCreditCardDiscount(CreditCard card) {
        total -= card.discount();
        System.out.println("Discount of " + card.discount() + " has been applied!");
    }

    public void applyDebitCardDiscount(DebitCard card) {
        total -= card.discount();
        System.out.println("Discount of " + card.discount() + " has been applied!");
    }
}
