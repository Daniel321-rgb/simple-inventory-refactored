interface InventoryService {
    void addProduct(Product product);
    void removeProduct(String productID) throws InsufficientStockException;
}