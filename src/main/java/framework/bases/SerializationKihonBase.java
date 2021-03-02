package framework.bases;

import framework.Item;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static framework.utility.SerializationUtility.getJsonStringFromObject;
import static framework.utility.SerializationUtility.getObjectFromJson;

public abstract class SerializationKihonBase {

    protected abstract Item deserializeJsonFile(String path);
    protected abstract String serializeJavaObject(Item item);

    @Test
    public void deserializeJsonFileTest() {
        Item item = getObjectFromJson("json/Item.json", Item.class);
        Assertions.assertEquals(item.hashCode(), deserializeJsonFile("json/Item.json").hashCode());
    }

    @Test
    public void serializeJavaObjectTest() {
        Item item = new Item("Buzz Lightyear", "My childhood made in plastic", 20);
        String logMsg = getJsonStringFromObject(item);
        Assertions.assertEquals(logMsg, serializeJavaObject(item));
    }

}
