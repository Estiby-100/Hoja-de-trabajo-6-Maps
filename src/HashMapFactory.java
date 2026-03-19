import java.util.HashMap;
import java.util.Map;

public class HashMapFactory extends MapFactory {

    @Override
    public Map<String, Product> createMap() {
        return new HashMap<>();
    }
}