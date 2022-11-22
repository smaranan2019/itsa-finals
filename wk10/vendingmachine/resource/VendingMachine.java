import java.util.Scanner;

public class VendingMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        VendingMachineModel vendingMachine = new VendingMachineModel();

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
