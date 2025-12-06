import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

class Inventory implements InventoryService {
    // Refactoring: Feature Envy (Pakai HashMap)
    private Map<String, Product> productMap = new HashMap<>(); 
    
    @Override
    public void addProduct(Product product){
        productMap.put(product.getProductID(), product);
        // Output persis original
        System.out.println("Product added " + product.getProductName() + 
        " with quantity " + product.getQuantity());
    }

    @Override
    public void removeProduct(String productID) throws InsufficientStockException {
        // Refactoring: Cek ID langsung ke Map (efisien) tapi output/error sama
        if (productMap.containsKey(productID)) {
            productMap.remove(productID);
            // Output persis original
            System.out.println("Product " + productID + " removed successfully.");
        } else {
            // Error message persis original
            throw new InsufficientStockException("Cannot find the ID");
        }
    }
}