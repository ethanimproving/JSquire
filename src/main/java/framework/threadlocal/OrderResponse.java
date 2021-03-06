package framework.threadlocal;

import framework.Item;
import lombok.Data;

@Data
public class OrderResponse {
    private Item orderItemResponse;

    public OrderResponse(Item orderItemResponse) {
        this.orderItemResponse = orderItemResponse;
    }
}
