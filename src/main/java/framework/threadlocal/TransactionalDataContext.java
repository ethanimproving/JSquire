package framework.threadlocal;

import lombok.Data;

@Data
public class TransactionalDataContext {
    private OrderRequest orderRequest;
    private OrderResponse orderResponse;
    private long beginTime;
}

