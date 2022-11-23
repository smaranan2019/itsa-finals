// Interface Segregation Principle

import java.util.ArrayList;
public interface VendingMachineModelInterface {
    public Product getProduct(int productNo);
    public ArrayList<Product> getProducts();
}
