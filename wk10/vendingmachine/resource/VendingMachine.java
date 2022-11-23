// Single Responsibility Principle

import java.util.Scanner;

public class VendingMachine {
    private VendingMachineModelInterface vendingMachineModel;
    private VendingMachineDisplayInterface vendingMachineDisplay;
    private int selectedProduct = -1;

    //Dependency Inversion Principle
    public VendingMachine(VendingMachineModelInterface vendingMachineModel, VendingMachineDisplayInterface vendingMachineDisplay) {
        this.vendingMachineModel = vendingMachineModel;
        this.vendingMachineDisplay = vendingMachineDisplay;
    }

    public boolean selectProduct(int productNo) {
        if (productNo < 0 || productNo > vendingMachineModel.getProducts().size()) {
            vendingMachineDisplay.displayInvalidSelectionMessage();
            return false;
        } else if (productNo == 0) {
            return false;
        } else {
            this.selectedProduct = productNo - 1;
            return true;
        }
    }

    public void fulfillOrder(int selectedQuantity) {
        Product product = vendingMachineModel.getProduct(selectedProduct);

        if (selectedQuantity <= product.getQuantity()) {
            product.setQuantity(product.getQuantity() - selectedQuantity);
            vendingMachineDisplay.displayFulfillmentMessage("Message - This is your product : " + product.getName() + ". The cost is $"
                    + product.calculateTotalPrice(selectedQuantity) + " Thank you for your purchase!");
        } else {
            vendingMachineDisplay.displayFulfillmentMessage(
                    "Message - Sorry, we only have " + product.getQuantity() + " of this product. Please try again.");
        }
    }

    public void displayProducts() {
        vendingMachineDisplay.displayProducts(vendingMachineModel.getProducts());
    }

    public void askQuantity() {
        vendingMachineDisplay.askQuantity();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        VendingMachine vendingMachine = new VendingMachine(new VendingMachineModel(), new VendingMachineTextDisplay());

        int selectedProduct = -1;
        do {
            try {
                vendingMachine.displayProducts();
                selectedProduct = Integer.parseInt(scanner.nextLine());
                boolean success = vendingMachine.selectProduct(selectedProduct);

                if (success) {
                    vendingMachine.askQuantity();
                    int selectedQuantity = Integer.parseInt(scanner.nextLine());
                    vendingMachine.fulfillOrder(selectedQuantity);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        } while (selectedProduct != 0);

    }
}
