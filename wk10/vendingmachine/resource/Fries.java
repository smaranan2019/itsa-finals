// open/closed principle
// Liskov Substitution Principle

public class Fries extends Product {

    public Fries(String name, int selectionNumber, double price, int quantity, String promoMessage) {
        super(name,selectionNumber,price,quantity,promoMessage);
    }

}
