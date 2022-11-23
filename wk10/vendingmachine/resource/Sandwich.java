// open/closed principle

public class Sandwich extends Product {

    public Sandwich(String name, int selectionNumber, double price, int quantity, String promoMessage) {
        super(name,selectionNumber,price,quantity,promoMessage);
    }

    public double calculateTotalPrice(int selectedQuantity) {
        if (selectedQuantity >= 2) {
            return (super.getPrice() * selectedQuantity) * 0.9;
        } else {
            return super.getPrice() * selectedQuantity;
        }    
    }
}
