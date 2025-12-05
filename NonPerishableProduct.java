import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


class NonPerishableProduct extends Product {
    private int shelfLife; 

    public NonPerishableProduct(String productID, String productName, int quantity, double price, int shelfLife){
        super(productID, productName, quantity, price);
        this.shelfLife = shelfLife;
    }
}