import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Inventory inventory = new Inventory();

		// Data Setup (Refactoring: Pakai LocalDate)
		PerishableProduct apple = new PerishableProduct("P001", "Apple", 50, 0.5, LocalDate.of(2024, 12, 31));
		NonPerishableProduct rice = new NonPerishableProduct("NP001", "Rice", 200, 1.0, 365);

		inventory.addProduct(apple);
		inventory.addProduct(rice);

		// Case 3: Updating Stock Normal
		processAddStock(apple, 30);

		// Case 4: Limit Exceeded
		processAddStock(apple, 30); // 50+30=80, +30=110 (Fail)

		// Case 5: Removing Products Successfully
		try {
			inventory.removeProduct("P001");
		} catch (InsufficientStockException e) {
			System.out.println(e.getMessage());
		}

		// Case 6: Removing More than Available
		// (Note: Apple sudah dihapus di atas, agar test ini valid sesuai logika object,
		// kita test pakai Rice atau Apple lagi jika objectnya masih ada di memori
		// variable 'apple')
		processRemoveStock(apple, 1000);

		// Case 7: Invalid Quantity Update (Negatif)
		processAddStock(apple, -10);
	}

	// Helper Method agar Main bersih dari try-catch berulang
	// TAPI, System.out.print "[CMD]" saya hapus agar outputnya murni pesan dari
	// class Product
	private static void processAddStock(Product p, int amount) {
		try {
			p.addStock(amount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void processRemoveStock(Product p, int amount) {
		try {
			p.removeStock(amount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}