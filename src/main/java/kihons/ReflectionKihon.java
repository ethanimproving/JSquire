package kihons;

import framework.Item;
import framework.bases.ReflectionKihonBase;
import framework.exceptions.NotImplementedYetException;

import static framework.utility.Reflect.setField;

public class ReflectionKihon extends ReflectionKihonBase {
    @Override
    protected void updateDescription(Item item, String newDescription) {
        throw new NotImplementedYetException();
    }

    @Override
    protected void updateName(Item item, String newName) {
        throw new NotImplementedYetException();
    }

    @Override
    protected void updateCost(Item item, int newCost) {
        throw new NotImplementedYetException();
    }
}
