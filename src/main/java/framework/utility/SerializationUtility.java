package framework.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import framework.bases.SerializationKihonBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

public class SerializationUtility {

    protected static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false);
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    /**
     * @param path file path to a JSON.
     * @param objClassName class type of the object to be returned.
     * @return a java object deserialized from a JSON file.
     */
        public static <T> T getObjectFromJson(String path,
                                          Class<T> objClassName) {
        InputStream inputStream;
        T value;
        try {
            ClassLoader classLoader = SerializationKihonBase.class.getClassLoader();
            inputStream = classLoader != null ? classLoader.getResourceAsStream(path) : new FileInputStream(path);
            value = mapper.readValue(inputStream, objClassName);
            if (inputStream != null)
                inputStream.close();
        } catch (IOException e) {
            throw new SerializationUtilityException(e);
        }
        return value;
    }

    /**
     * Returns a {@link String} representation of a Java Object in JSON format. Primarily used for logging.
     */
    public static String getJsonStringFromObject(Object obj) {
        try {
            return mapper.writerWithDefaultPrettyPrinter() != null ? mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj) : null;
        } catch (JsonProcessingException e) {
            throw new SerializationUtilityException(e);
        }
    }

    public static < T, S, K extends Collection> List< T > mapCollection(Collection< S > collection,
                                                                        Class< K > collectionType,
                                                                        Class clazz) {
        ObjectReader reader = mapper.reader();
        ObjectWriter writer = mapper.writer();

        try {
            return reader.forType(mapper.getTypeFactory()
                    .constructCollectionType(collectionType,
                            clazz))
                    .readValue(writer.writeValueAsBytes(collection));
        } catch (IOException e) {
            throw new SerializationUtilityException(e);
        }
    }

    /**
     * This is to map objects with the same fields that exist in different packages.
     */
    public static <T> T mapObject(Object object,
                                  Class<T> clazz) {
        ObjectReader reader = mapper.readerFor(clazz);
        ObjectWriter writer = mapper.writer();
        try {
            return reader.readValue(writer.writeValueAsBytes(object));
        } catch (IOException e) {
            throw new SerializationUtilityException(e);
        }
    }

    public static class SerializationUtilityException extends RuntimeException {
        public SerializationUtilityException(IOException e) {
            super(e);
        }
    }
}
