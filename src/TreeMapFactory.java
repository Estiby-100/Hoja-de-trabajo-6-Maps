import java.util.Map;
import java.util.TreeMap;

public class TreeMapFactory extends MapFactory {

    @Override
    public Map<String, Product> createMap() {
        return new TreeMap<>();
    }
}
