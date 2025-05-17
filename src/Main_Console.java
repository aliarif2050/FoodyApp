import java.util.Scanner;
class Main_Console {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();
        int discountCounter=0;
        System.out.println("\t\t\t\tFOODY!");// we'll discuss name guys
        System.out.println("Loading...");
        try {
            Thread.sleep(2000); // 2 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\t\t\tWelcome to FOODY");
        boolean choice_m = true;
        outer: while (choice_m) {
            System.out.println("\nWhat to do?\n1. Order Food!\n2. See Cart!\n3. Checkout!\n4. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    RestaurantSelector.showRestaurantMenus(sc, cart);
                    break;
                case 2:
                    if (cart.cartState() == 0) {
                        break;}
                    else {
                        while (true) {
                            cart.displayCart();
                            System.out.println("\nSelect from below:\n1. Remove Item\n2. Clear Cart (If cleared you can order from other restaurant!\n3. Exit to Main menu");
                            int choice0 = sc.nextByte();
                                 if (choice0 == 1) {
                                 System.out.println("Enter the name of item you want to remove! (case insensitive)");
                                 sc.nextLine();
                                 String itemName = sc.nextLine();
                                 cart.removeItem(itemName);
                                }
                                else if (choice0 == 2) {
                                    System.out.println("Sure?🥲(Y or N)");
                                    char clear_cart = sc.next().charAt(0);
                                           if (clear_cart == 'y' || clear_cart == 'Y') {
                                            cart.clearCart();
                                            }
                                }
                                else if(choice0==3){break;}
                        }
                    }
                    break;
                case 3:
                    if (cart.cartState() == 0) {
                        break;
                    } else
                    {
                        while(true)
                        {
                            cart.displayCart();
                            System.out.println("\n1.Checkout!\n2.Apply Discount coupon!\n3.Exit to main menu!");
                            int choice_1 = sc.nextByte();
                            if (choice_1 == 1) {
                                cart.checkout();
                                break;
                            }
                            else if (choice_1 == 2) {
                                System.out.println("\nDo want to see available discounts?🤩(Y/N)");
                                char option = sc.next().charAt(0);
                                if (option == 'Y' || option == 'y') {
                                    while (true) {
                                        System.out.println("1.View Credit Card discounts");
                                        System.out.println("2.View Debit Card discounts");
                                        System.out.println("3.Don't have any of these😭");
                                        int choice_0 = sc.nextInt();
                                        if (choice_0 == 1) {
                                            System.out.println("HBL = Rs200\nMCB = Rs300\nAskari = 100\nDo you have card from any of these?(Y/N)");
                                            char option_0 = sc.next().charAt(0);
                                            if (option_0 == 'Y' || option_0 == 'y') {
                                                CreditCard card = new CreditCard();
                                                card.setdata();
                                                if(discountCounter==0){
                                                    discountCounter++;
                                                cart.applyCreditCardDiscount(card);
                                                break;
                                                }
                                                else {
                                                    System.out.println("Discount already applied!");
                                                    break;
                                                }
                                            }
                                        } else if (choice_0 == 2) {
                                            System.out.println("Meezan = Rs400\nBank Islami = Rs200\nDo you have card from any of these?(Y/N)\"");
                                            char option_1 = sc.next().charAt(0);
                                            if (option_1 == 'Y' || option_1 == 'y') {
                                                DebitCard card = new DebitCard();
                                                card.setdata();
                                                if(discountCounter==0) {
                                                    discountCounter++;
                                                    cart.applyDebitCardDiscount(card);
                                                    break;
                                                }
                                                else{
                                                    System.out.println("Discount already applied!");
                                                    break;
                                                }
                                            }
                                        } else if (choice_0 == 3) {
                                            break;
                                        }
                                    }
                                }
                            } else if(choice_1==3) {break;}
                            else {
                                System.out.println("Kindly select 1 or 2");
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("Thanks!, See you soon🫡");
                    break outer;
                default:
                    System.out.println("Kindly choose from given option😌");
                    break;
            }

        }
    }
}


