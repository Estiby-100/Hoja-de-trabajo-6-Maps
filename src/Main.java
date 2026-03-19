import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Select Map implementation:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");

        int choice = sc.nextInt();
        sc.nextLine();

        MapFactory factory = MapFactory.getFactory(choice);
        Map<String, Product> inventoryMap = factory.createMap();

        InventoryLogic logic = new InventoryLogic(inventoryMap);
        logic.loadFromFile("ListadoProducto.txt");

        int option = -1;

        while (option != 0) {

            System.out.println("\nMENU");
            System.out.println("1. Add product by category");
            System.out.println("2. Show product category");
            System.out.println("3. Show user collection");
            System.out.println("4. Show user collection by category");
            System.out.println("5. Show inventory (sorted)");
            System.out.println("0. Exit");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1:
                    System.out.println("Enter category:");
                    String category = sc.nextLine();
                    logic.addProductToUser(category, sc);
                    break;

                case 2:
                    System.out.println("Enter product name:");
                    logic.showProductCategory(sc.nextLine());
                    break;

                case 3:
                    logic.showUserCollection();
                    break;

                case 4:
                    logic.showUserCollectionByCategory();
                    break;

                case 5:
                    long start = System.nanoTime();
                    logic.showInventorySorted();
                    long end = System.nanoTime();
                    System.out.println("Tiempo: " + (end - start) + " ns  |  " + (end - start) / 1_000_000.0 + " ms");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }

        sc.close();
    }
}
