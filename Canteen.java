import java.util.*;
import java.text.DecimalFormat;


class Canteen { 

    class MenueItems{
        String [] food = {"Takoyaki", "Fries", "Pizza", "Burger", "Sandwich"};
        Double [] price = {5.99, 2.99, 8.99, 6.99, 4.99};
    }
    public void displayMenu() {

        System.out.println("==== M E N U ====");

        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ". " + new MenueItems().food[i] + " - $" + new MenueItems().price[i]);
        }

        System.out.println(" ");
        
    }
    public double[] OrderItem(int itemNumber, int amount) {
        double[] results = new double[3];
        results[0] = 0.00; // overallTotal
        results[1] = 0.00; // overallDiscount 
        results[2] = 0.00; // totalItemsOrdered  
        double totalPrice = 0.00;
        double discount = 0.00;
        boolean validItem = true;

        while (validItem) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the item number: ");
        int itemNumberInput = scanner.nextInt();
        
        
            if (itemNumberInput < 1 || itemNumberInput > 5) {
                System.out.println(" ");
                System.out.println("Invalid order! Please enter a valid and quantity.");
                System.out.println(" ");
                } 
            else if ( itemNumberInput >= 1 && itemNumberInput <= 5) {

                System.out.print("Enter the quantity you want to order: ");
                int quantity = scanner.nextInt();
                System.out.print("Are you a student? (Y/N): ");
                String studentStatus = scanner.next();
                totalPrice = (new MenueItems().price[itemNumberInput - 1] * quantity);

                    if(studentStatus.equalsIgnoreCase("Y")) {

                        if(totalPrice >= 500.00) {
                            discount = (totalPrice) * 0.15;
                            // will resort the the total price with a 15% discount
                        }
                        else {discount = (totalPrice) * 0.10;
                        }

                    } 
                    else if (studentStatus.equalsIgnoreCase("N")) {
                        if(totalPrice >= 500.00) {
                            discount = (totalPrice) * 0.05;
                        }
                        else {
                         discount = 0.00;
                        }
                    } 
                    else {
                        System.out.println("Invalid input. Please enter Y or N.");
                    }

                System.out.println("");
                DecimalFormat df = new DecimalFormat("#0.00");
                System.out.println("Subtotal: $" + df.format(totalPrice));
                System.out.println("Discount: $" + df.format(discount));
                System.out.println("Total: $" + df.format(totalPrice - discount));
                results[0] += totalPrice;
                results[1] += discount;
                results[2] += quantity;
                System.out.println(" ");
            } else {
                validItem = false;
            } 

            System.out.print("Do you want to order another item? (Y/N): ");
                String anotherOrder = scanner.next();
                    if(anotherOrder.equalsIgnoreCase("Y")) {
                        validItem = true;
                    } else if (anotherOrder.equalsIgnoreCase("N")) {
                        validItem = false;
                    } else {
                        System.out.println("Invalid input. Please enter Y or N.");
                    }
                System.out.println(" ");       
        }
    
    return results;
    }
}

class Main {
    public static void main(String[] args) {
        class MenueItems{};
        Canteen.MenueItems foods= new Canteen().new MenueItems();
        Canteen canteen = new Canteen();
        canteen.displayMenu();   

        double[] orderItem = canteen.OrderItem(1, 1);
        DecimalFormat df = new DecimalFormat("#0.00");
        System.out.println(" ");
        System.out.println("===== ORDER SUMMARY =====");
        System.out.println("Total items: " + (int) orderItem[2]);
        System.out.println("Total before discount: $" + df.format(orderItem[0]));
        System.out.println("Total discount: $" + df.format(orderItem[1]));
        System.out.println("Total amount: $" + df.format(orderItem[0] - orderItem[1]));
        System.out.println("Thank you for ordering!");

        
    }
}


