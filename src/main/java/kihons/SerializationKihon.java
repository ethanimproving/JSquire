package kihons;

import framework.Item;
import framework.bases.SerializationKihonBase;
import framework.exceptions.NotImplementedYetException;

import static framework.utility.SerializationUtility.getJsonStringFromObject;
import static framework.utility.SerializationUtility.getObjectFromJson;

public class SerializationKihon extends SerializationKihonBase {
    @Override
    protected Item deserializeJsonFile(String path) {
        throw new NotImplementedYetException();
    }

    @Override
    protected String serializeJavaObject(Item item) {
        throw new NotImplementedYetException();
    }
}
