package framework.threadlocal;

import lombok.Data;

@Data
public class OrderRequest {
    private String name;
    private String description;
    private int cost;

    public OrderRequest() {
    }

    public OrderRequest(String name, String description, int cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }
}
