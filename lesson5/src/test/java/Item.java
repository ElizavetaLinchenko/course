import java.util.Map;

public class Item implements Map.Entry<String, String> {
    private String key;
    private String value;

    Item(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String setValue(String value) {
        return value;
    }
}