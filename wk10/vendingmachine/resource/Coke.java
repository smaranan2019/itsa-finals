// open/closed principle
// Liskov Substitution Principle

public class Coke extends Product {

    public Coke(String name, int selectionNumber, double price, int quantity, String promoMessage) {
        super(name,selectionNumber,price,quantity,promoMessage);
    }
}
