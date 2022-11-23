// Interface Segregation Principle

import java.util.ArrayList;

public interface VendingMachineDisplayInterface {
    public void displayInvalidSelectionMessage();
    public void askQuantity();
    public void displayFulfillmentMessage(String message);
    public void displayProducts(ArrayList<Product> products);
}
