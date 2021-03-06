package framework.bases;

import framework.Item;
import framework.threadlocal.OrderRequest;
import framework.threadlocal.OrderResponse;
import framework.threadlocal.TransactionalDataContext;
import framework.threadlocal.TransactionalDataContextProvider;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * A {@link Thread} is the path followed when executing the program for a single request.
 * The number of active Threads are the number of tasks being handled in parallel.
 */
public class ThreadKihonBase {

    protected ExecutorService returnNewThreadPoolWithMaxOf2ConcurrentThreads() {
        return Executors.newFixedThreadPool(2);
    }
    public static ThreadLocal<TransactionalDataContext> createThreadLocalWithInitialTransactionalDataContext() {
        return ThreadLocal.withInitial(TransactionalDataContext::new);
    }

    @Test
    public void returnNewThreadPoolWithMaxOf2ConcurrentThreadsTest() {
        ExecutorService executorService = returnNewThreadPoolWithMaxOf2ConcurrentThreads();
        List<Future<String>> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Future<String> future = executorService.submit(new Processor(i + 1));
            list.add(future);
        }

        for (var future : list) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }

    @Test
    public void createThreadLocalWithInitialTransactionalDataContextTest() {

        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        String[] names = new String[] {"Bananas", "Apples", "Blueberries", "Tomatoes", "Lettuce", "Tacos", "Mariana is hot", "Gorditas"};
        String[] descriptions = new String[] {"Delicious yellow fruit", "Apples", "Blueberries", "Tomatoes", "Lettuce", "Tacos", "Mariana is hot", "Gorditas"};
        int[] costs = new int[] { 1,2,3,4,5,6,7,8 };

        Random r = new Random();

        for (int i = 0; i < 100; i++) {
            int j = r.nextInt(8);
            sendRequest(names[j], descriptions[j], costs[j]);
            threadPool.submit(() -> {
                sendRequest(names[j], descriptions[j], costs[j]);
                System.out.println(TransactionalDataContextProvider.getInstance().getOrderResponse().getOrderItemResponse().getName());
            });
        }
    }

    private void sendRequest(String name, String description, int cost) {
        OrderRequest orderRequest = new OrderRequest(name, description, cost);
        Service1 service = new Service1();
        service.process(orderRequest);
        Assertions.assertEquals(new Item(name, description, cost).hashCode(), TransactionalDataContextProvider.getInstance().getOrderResponse().getOrderItemResponse().hashCode());
    }


    class Processor implements Callable {

        private int id;

        public Processor(int id) {
            this.id = id;
        }

        @Override
        public Object call() throws Exception {
            Thread.sleep(1000);
            return "Id: " + id;
        }
    }

    // ===================================================================================
    // Thread Local
    // ===================================================================================

    class Service1 {

        Service2 service2 = new Service2();

        public void process(OrderRequest orderRequest) {
            TransactionalDataContext context = TransactionalDataContextProvider.getInstance();
            context.setOrderRequest(orderRequest);
            service2.process();
        }
    }

    class Service2 {
        public void process() {
            TransactionalDataContext context = TransactionalDataContextProvider.getInstance();
            OrderRequest req = context.getOrderRequest();
            context.setOrderResponse(new OrderResponse(new Item(req.getName(), req.getDescription(), req.getCost())));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

