# Simple Inventory System - Refactoring Project

This repository contains the **refactored version** of a legacy Simple Inventory System application. The project aims to improve code quality, maintainability, and adhere to proper Object-Oriented Design principles by eliminating identified **Code Smells**.

## 📂 Original Source (Legacy Code)

The original code served as a case study for this refactoring project. The codebase suffered from poor design choices and several "Code Smells." The primary issues identified were **Refused Bequest**, **Feature Envy**, and **Primitive Obsession**.

* **Original Repository:** [SimpleInventoryManagement_System_By_FivePesos](https://github.com/FivePesos/SimpleInventoryManagement-System-/tree/main)
* **Target File (Smelly Code):** [`Main.java` (Permalink)]

## 🛠️ Refactoring Changes

The original code underwent structural changes to resolve the identified issues. Below are the key improvements:

### Key Improvements:

1.  **Extract Subclass (Polymorphism):**
    * **Problem:** *Refused Bequest*. The generic `Product` class likely contained behaviors or attributes not applicable to all items.
    * **Solution:** Created specific subclasses, `PerishableProduct.java` and `NonPerishableProduct.java`. This ensures each class only contains relevant logic and adheres better to the Liskov Substitution Principle.

2.  **Extract Class / Move Method:**
    * **Problem:** *Feature Envy*. The logic for managing inventory was likely tightly coupled within the data classes or a monolithic main class.
    * **Solution:** Extracted business logic into a dedicated `InventoryService.java`. This separates the responsibility of *storing data* (Product) from *managing operations* (Service).

3.  **Replace Primitive with Custom Exceptions:**
    * **Problem:** *Primitive Obsession*. The legacy code likely used simple integers or boolean flags to handle errors (e.g., returning `-1` for errors).
    * **Solution:** Implemented custom exceptions such as `InsufficientStockException.java` and `InvalidQuantityException.java`. This provides more explicit, robust, and readable error handling.

4. **Rename & Extract Interface:**
    * **Problem:** Ambiguous naming and tight coupling.
    * **Solution:** Renamed `Inventory` and extracted an interface to clarify the code's *intent* and strictly define class responsibilities.

## 🚀 Project Structure

The refactored project structure is organized as follows:

* `Product.java`: Abstract parent class.
* `PerishableProduct.java` / `NonPerishableProduct.java`: Specialized implementations.
* `InventoryService.java`: Handles business logic (add, remove, check stock).
* `Main.java`: Application entry point.
* `InsufficientStockException.java`: Custom error handling for stock issues.

