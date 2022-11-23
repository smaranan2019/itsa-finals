public class Product {

    private int selectionNumber;
    private double price;
    private String name;
    private int quantity;
    private String promoMessage;

    Product(String name, int selectionNumber, double price, int quantity, String promoMessage) {
        this.name = name;
        this.selectionNumber = selectionNumber;
        this.price = price;
        this.quantity = quantity;
        this.promoMessage = promoMessage;
    }

    public int getSelectionNumber() {
        return selectionNumber;
    }

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPromoMessage() {
        return promoMessage;
    }

    public double calculateTotalPrice(int selectedQuantity) {
        return price * selectedQuantity;
    }
}
