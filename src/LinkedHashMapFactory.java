import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapFactory extends MapFactory {

    @Override
    public Map<String, Product> createMap() {
        return new LinkedHashMap<>();
    }
}