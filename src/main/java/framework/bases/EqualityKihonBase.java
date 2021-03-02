package framework.bases;

import framework.Item;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * We can use == operators for reference comparison (address comparison)
 * and .equals() method for content comparison. In simple words, == checks
 * if both objects point to the same memory location whereas .equals() evaluates to the comparison of values in the objects.
 *
 * https://www.geeksforgeeks.org/difference-equals-method-java/
 */
public abstract class EqualityKihonBase {

    protected abstract boolean checkIfObjectReferencesAreIdentical(String string1, String string2);
    protected abstract boolean checkIfObjectValuesAreEqual(String string1, String string2);
    protected abstract boolean checkIfPrimitiveTypesAreEqual(int value1, int value2);
    protected abstract boolean checkObjectEqualityUsingHashCode(Item item1, Item item2);

    @Test
    public void checkIfObjectReferencesAreIdenticalTest() {
        // Arrange
        String string1 = new String("This is a unique object.");
        String string2 = new String("This is a unique object.");

        // Assert
        Assertions.assertFalse(checkIfObjectReferencesAreIdentical(string1, string2));
        Assertions.assertTrue(checkIfObjectReferencesAreIdentical(string1, string1));
    }

    /**
     * Strings go inside something called the "String pool." If you have 2 strings
     * created which are the same, Java will store the reference to an
     * existing one in that variable.
     */
    @Test
    public void checkThatTwoEqualStringsShareTheSameReferenceInTheJavaStringPool() {
        // Arrange
        String string1 = "This object lives in the String Pool.";
        String string2 = "This object lives in the String Pool.";
        String string3 = "This object has a different reference.";

        // Assert
        Assertions.assertTrue(checkIfObjectReferencesAreIdentical(string1, string2));
        Assertions.assertFalse(checkIfObjectReferencesAreIdentical(string1, string3));
    }

    @Test
    public void checkIfObjectValuesAreEqualTest() {
        // Arrange
        String string1 = new String("IntelliJ is better than Visual Studio Community!!!");
        String string2 = new String("IntelliJ is better than Visual Studio Community!!!");
        String string3 = new String("And it's dark theme is better too.");

        // Assert
        Assertions.assertTrue(checkIfObjectValuesAreEqual(string1, string2));
        Assertions.assertFalse(checkIfObjectValuesAreEqual(string1, string3));
    }

    @Test
    public void checkIfPrimitiveTypesAreEqualTest() {
        // Arrange
        int value1 = 1;
        int value2 = 1;
        int value3 = 2;

        // Assert
        Assertions.assertTrue(checkIfPrimitiveTypesAreEqual(value1, value2));
        Assertions.assertFalse(checkIfPrimitiveTypesAreEqual(value1, value3));
    }

    @Test
    public void checkObjectEqualityUsingHashCodeTest() {
        // Arrange
        Item item1 = new Item("Bowling Ball", "Super heavy, super fun", 50);
        Item item2 = new Item("Bowling Ball", "Super heavy, super fun", 50);
        Item item3 = new Item("Bowling Ball", "Super light, super lame", 25);

        // Assert
        Assertions.assertTrue(checkObjectEqualityUsingHashCode(item1, item2));
        Assertions.assertFalse(checkObjectEqualityUsingHashCode(item1, item3));
    }

}
