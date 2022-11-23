// Single Responsibility Principle
// Dependency Inversion Principle

import java.util.ArrayList;
public class VendingMachineTextDisplay implements VendingMachineDisplayInterface{
    public void displayInvalidSelectionMessage() {
        System.out.println("                                              ");
        System.out.println(" Message - Invalid selection. Please try again.");
    }

    public void askQuantity() {
        System.out.print(" Please enter the quantity: ");
    }

    public void displayFulfillmentMessage(String message) {
        System.out.println("                                              ");
        System.out.println(message);
    }

    public void displayProducts(ArrayList<Product> products) {
        System.out.println("                                              ");
        System.out.println(" *********************************************");
        System.out.println("     WELCOME TO THE VENDING MACHINE           ");
        System.out.println(" *********************************************");
        System.out.println("            Products available:               ");
        System.out.println("                                              ");
        for (Product product : products) {
            System.out.println("     " + product.getSelectionNumber() + "  " + product.getName() + " - Price: $"
                    + product.getPrice() + " - Quantity: "
                    + product.getQuantity() + "  " + product.getPromoMessage() + "   ");
        }
        System.out.println("                                              ");
        System.out.print(" Please select your product (0 to exit): ");
    }
}
