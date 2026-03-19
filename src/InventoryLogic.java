import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class InventoryLogic {

    private final Map<String, Product> inventoryByProduct;
    private final Map<Category, List<Product>> inventoryByCategory;
    private final Map<String, Integer> userElections;

    public InventoryLogic(Map<String, Product> inventoryMap) {
        this.inventoryByProduct = inventoryMap;
        this.inventoryByCategory = new HashMap<>();
        this.userElections = new HashMap<>();
    }

    public void loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length != 2) continue;
                String categoryText = parts[0].trim(), productName = parts[1].trim();
                Category category = Category.fromString(categoryText);
                Product product = new Product(productName, category);
                inventoryByProduct.put(productName, product);
                if (!inventoryByCategory.containsKey(category)) inventoryByCategory.put(category, new ArrayList<>());
                inventoryByCategory.get(category).add(product);
            }
        } catch (IOException e) { System.out.println("Error reading file: " + e.getMessage()); }
    }

    public void addProductToUser(String categoryText, Scanner sc) {

    try {
        Category category = Category.fromString(categoryText);
        List<Product> products = inventoryByCategory.get(category);

        if (products == null || products.isEmpty()) {
            System.out.println("No products in that category");
            return;
        }

        System.out.println("Select a product:");

        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).getName());
        }

        int option = sc.nextInt();
        sc.nextLine();

        Product selected = products.get(option - 1);
        String name = selected.getName();

        if (userElections.containsKey(name))
            userElections.put(name, userElections.get(name) + 1);
        else
            userElections.put(name, 1);

        System.out.println("Product added: " + name);

    } catch (IllegalArgumentException e) {
        System.out.println("Invalid category");
    }
}
    

    public void showProductCategory(String productName) {
        Product product = inventoryByProduct.get(productName);
        if (product == null) System.out.println("Product not found");
        else System.out.println("Category: " + product.getCategory().getnombreCategoria());
    }

    public void showUserCollection() {
        for (String name : userElections.keySet()) {
            Product p = inventoryByProduct.get(name);
            int quantity = userElections.get(name);
            System.out.println(name + " | " + p.getCategory().getnombreCategoria() + " | Quantity: " + quantity);
        }
    }

    public void showUserCollectionByCategory() {
        for (Category c : inventoryByCategory.keySet()) {
            System.out.println("Category: " + c.getnombreCategoria());
            for (Product p : inventoryByCategory.get(c)) {
                String name = p.getName();
                if (userElections.containsKey(name)) {
                    int quantity = userElections.get(name);
                    System.out.println(name + " | Quantity: " + quantity);
                }
            }
        }
    }

    public void showInventorySorted() {
        Map<Category, List<Product>> sorted = new TreeMap<>(inventoryByCategory);
        for (Category c : sorted.keySet()) {
            System.out.println("Category: " + c.getnombreCategoria());
            for (Product p : sorted.get(c)) System.out.println(p.getName());
        }
    }
}