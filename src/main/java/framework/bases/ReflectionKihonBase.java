package framework.bases;

import framework.Item;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public abstract class ReflectionKihonBase {

    protected abstract void updateDescription(Item item, String newDescription);
    protected abstract void updateName(Item item, String newName);
    protected abstract void updateCost(Item item, int newCost);

    @Test
    public void updateDescriptionTest() {
        Item item = new Item("Bubbles", "Old description", 45);
        updateDescription(item, "Updated description");
        Assertions.assertEquals("Updated description", item.getDescription());
    }

    @Test
    public void updateNameTest() {
        Item item = new Item("Bubbles", "Old description", 45);
        updateName(item, "Updated description");
        Assertions.assertEquals("Updated description", item.getName());
    }

    @Test
    public void updateCostTest() {
        Item item = new Item("Bubbles", "Old description", 45);
        updateCost(item, 50);
        Assertions.assertEquals(50, item.getCost());
    }

}
