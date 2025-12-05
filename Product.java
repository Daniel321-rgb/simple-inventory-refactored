import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

abstract class Product {
    private String productID;
    private String productName;
    private int quantity;
    private double price;
    
    public Product(String productID, String productName, int quantity, double price){
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Refactoring: Logic validasi negatif dipusatkan di sini (Extract Method)
    protected void validateNegative(int amount) throws InvalidQuantityException {
        if (amount < 0) {
            throw new InvalidQuantityException("Cannot enter negative number.");
        }
    }

    // Refactoring: Logic output dikembalikan ke format lama
    public void addStock(int amount) throws InvalidQuantityException {
        validateNegative(amount);
        this.quantity += amount;
        // Output persis original
        System.out.println("Stock updated: " + getProductName() + " new quantity is " + getQuantity());
    }

    // Refactoring: Pull Up Method dari Subclass
    public void removeStock(int amount) throws InvalidQuantityException {
        validateNegative(amount);
        if (amount > this.quantity) {
            // Output persis original (Original tidak throw exception di case ini, hanya print)
            System.out.println("Impossible to remove product"); 
        } else {
            this.quantity -= amount; // Bug fix logika tetap diterapkan (+ jadi -)
            // Output persis original
            System.out.println("Stock updated: " + getProductName() + " new quantity is " + getQuantity());
        }
    }

    // Getters standard
    public String getProductID() { return productID; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
}