import java.util.Scanner;

public class PaymentMethod {
    private Scanner sc = new Scanner(System.in);
    private String cardHolderName;
    private String cardNumber;
    private int cvc;
    private String bankName;

    public String getBankName() {
        return bankName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setData() {
        System.out.println("Enter Bank Name: ");
        this.bankName = sc.next();
        sc.nextLine();

        System.out.println("Enter Card Holder Name: ");
        this.cardHolderName = sc.nextLine();

        System.out.println("Enter Card/Account IBAN: ");
        this.cardNumber = sc.next();
    }

    protected void displayCardDetails() {
        System.out.println("Name: " + cardHolderName);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Bank: " + bankName);
    }
}

class CreditCard extends PaymentMethod {
    public int discount() {
        try {
            if (getBankName().equalsIgnoreCase("HBL") && getCardNumber().substring(4, 8).equals("HABB")) {
                return 200;
            } else if (getBankName().equalsIgnoreCase("MCB") && getCardNumber().substring(4, 8).equals("MCIB")) {
                return 300;
            } else if (getBankName().equalsIgnoreCase("Askari") && getCardNumber().substring(4, 8).equals("ASCM")) {
                return 100;
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Warning: Invalid card number format");
        }
        return 0;
    }
}

class DebitCard extends PaymentMethod {
    public int discount() {
        try {
            if (getBankName().equalsIgnoreCase("Meezan") && getCardNumber().substring(4, 8).equals("MEZN")) {
                return 400;
            } else if (getBankName().equalsIgnoreCase("Bank Islami") && getCardNumber().substring(4, 8).equals("BKIB")) {
                return 200;
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Warning: Invalid card number format");
        }
        return 0;
    }
}
