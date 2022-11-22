import java.util.ArrayList;

public class VendingMachineModel {

    private int selectedProduct;
    ArrayList<Product> products = new ArrayList<Product>();

    public VendingMachineModel() {
        products.add(new Product("Coke", 1, 1.50, 100, ""));
        products.add(new Product("Fries", 2, 1.00, 200, ""));
        products.add(new Product("Sandwich", 3, 2.00, 300, "(Buy 2 or more to get a 10% discount)"));
    }

    public void displayProducts() {
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

    public boolean selectProduct(int productNo) {
        if (productNo < 0 || productNo > products.size()) {
            displayInvalidSelectionMessage();
            return false;
        } else if (productNo == 0) {
            return false;
        } else {
            this.selectedProduct = productNo - 1;
            return true;
        }
    }

    public void askQuantity() {
        System.out.print(" Please enter the quantity: ");
    }

    public void displayInvalidSelectionMessage() {
        System.out.println("                                              ");
        System.out.println(" Message - Invalid selection. Please try again.");
    }

    public void fulfillOrder(int selectedQuantity) {
        Product product = products.get(selectedProduct);

        if (selectedQuantity <= product.getQuantity()) {
            product.setQuantity(product.getQuantity() - selectedQuantity);
            displayFulfillmentMessage("Message - This is your product : " + product.getName() + ". The cost is $"
                    + product.calculateTotalPrice(selectedQuantity) + " Thank you for your purchase!");
        } else {
            displayFulfillmentMessage(
                    "Message - Sorry, we only have " + product.getQuantity() + " of this product. Please try again.");
        }
    }

    public void displayFulfillmentMessage(String message) {
        System.out.println("                                              ");
        System.out.println(message);
    }

}
