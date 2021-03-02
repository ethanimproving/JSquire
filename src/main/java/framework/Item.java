package framework;

public class Item {
    private String name;
    private String description;
    private int cost;

    public Item() {
    }

    public Item(String name, String description, int cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int hashCode() {
        return 31
                + ((name == null) ? 0 : name.hashCode())
                + ((description == null) ? 0 : description.hashCode())
                + cost;
    }

    @Override
    public boolean equals(Object obj) {
        return this.toString() == obj.toString();
    }
}
