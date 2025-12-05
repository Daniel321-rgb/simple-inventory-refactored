import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

class PerishableProduct extends Product {
    // Refactoring: Magic Number jadi Constant
    private static final int MAX_STOCK = 100;
    // Refactoring: Primitive Obsession (String -> LocalDate)
    private LocalDate expirationDate; 

    public PerishableProduct(String productID, String productName, int quantity, double price, LocalDate expirationDate){
        super(productID, productName, quantity, price);
        this.expirationDate = expirationDate;
    }
    
    @Override
    public void addStock(int amount) throws InvalidQuantityException {
        // Cek apakah negatif dulu (konsistensi dengan original flow)
        if(amount < 0){
             throw new InvalidQuantityException("Cannot enter negative number.");
        }
        // Logic limit
        if (getQuantity() + amount > MAX_STOCK) {
            System.out.println("Maximum limit exceeded.");
        } else {
            // Panggil parent untuk update dan print pesan sukses standar
            super.addStock(amount); 
        }
    }
}