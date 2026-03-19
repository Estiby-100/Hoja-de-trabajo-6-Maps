import java.util.Map;

public abstract class MapFactory {

    public abstract Map<String, Product> createMap();
    public static MapFactory getFactory(int choice) {
        switch (choice) {
            case 1:
                return new HashMapFactory();
            case 2:
                return new TreeMapFactory();
            case 3:
                return new LinkedHashMapFactory();
            default:
                throw new IllegalArgumentException("Invalid choice");
        }
    }
}