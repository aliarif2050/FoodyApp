import java.util.Scanner;

public class PaymentMethod {
 Scanner sc= new Scanner(System.in);
 private String cardHolderName;
 private String cardNumber;
 private int CVC;
 String bankName;
 public String getBankName() {
  return bankName;
 }
 public String getCardNumber() {
  return cardNumber;
 }
 public void setdata(){
  System.out.println("Enter Bank Name: ");
  this.bankName=sc.next();
  System.out.println("Enter Card Holder Name: ");
  this.cardHolderName=sc.nextLine();
  sc.nextLine();
  System.out.println("Enter Card/Account IBAN: ");
     this.cardNumber= sc.next();
 }
 protected void displayCardDetails(){
  System.out.println("Name :" + cardHolderName);
  System.out.println("Card Number : " + cardNumber);
 }
}
class CreditCard extends PaymentMethod{
 public int discount(){
  if(getBankName().equalsIgnoreCase("HBL")&&getCardNumber().substring(4,8).equals("HABB")){
      return 200;
  } else if (getBankName().equalsIgnoreCase("MCB")&&getCardNumber().substring(4,8).equals("MCIB")) {
      return 300;
  } else if (getBankName().equalsIgnoreCase("Askari")&&getCardNumber().substring(4,8).equals("ASCM")) {
      return 100;
  }
  return 0;
 }
}
class DebitCard extends PaymentMethod{
 public int discount(){
  if (getBankName().equalsIgnoreCase("Meezan")&&getCardNumber().substring(4,8).equals("MEZN")) {
   return 400;
  } else if (getBankName().equalsIgnoreCase("Bank Islami")&&getCardNumber().substring(4,8).equals("BKIB")) {
   return 200;
  }
  return 0;
 }
}
