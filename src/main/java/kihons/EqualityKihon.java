package kihons;

import framework.Item;
import framework.bases.EqualityKihonBase;
import framework.exceptions.NotImplementedYetException;

public class EqualityKihon extends EqualityKihonBase {

    @Override
    protected boolean checkIfObjectReferencesAreIdentical(String string1, String string2) {
        throw new NotImplementedYetException();
    }

    @Override
    protected boolean checkIfObjectValuesAreEqual(String string1, String string2) {
        throw new NotImplementedYetException();
    }

    @Override
    protected boolean checkIfPrimitiveTypesAreEqual(int value1, int value2) {
        throw new NotImplementedYetException();
    }

    @Override
    protected boolean checkObjectEqualityUsingHashCode(Item item1, Item item2) {
        throw new NotImplementedYetException();
    }
}
