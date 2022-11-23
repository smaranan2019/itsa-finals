// Single Responsibility Principle
// Dependency Inversion Principle

import java.util.ArrayList;

public class VendingMachineModel implements VendingMachineModelInterface{

    private int selectedProduct;
    ArrayList<Product> products = new ArrayList<Product>();

    public VendingMachineModel() {
        products.add(new Coke("Coke", 1, 1.50, 100, ""));
        products.add(new Fries("Fries", 2, 1.00, 200, ""));
        products.add(new Sandwich("Sandwich", 3, 2.00, 300, "(Buy 2 or more to get a 10% discount)"));
    }

    public Product getProduct(int productNo) {
        return products.get(productNo);
    }
    public ArrayList<Product> getProducts() {
        return products;
    }
}
