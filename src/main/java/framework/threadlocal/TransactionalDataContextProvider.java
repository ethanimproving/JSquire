package framework.threadlocal;

import static framework.bases.ThreadKihonBase.createThreadLocalWithInitialTransactionalDataContext;

/**
 * Thread Local context is somewhere to store data that relates to a single request,
 * to distinguish it from other requests being executed in parallel.
 * @see <a href="https://www.youtube.com/watch?v=sjMe9aecW_A">ThreadLocal in Java</a>
 */
public class TransactionalDataContextProvider {
    /**
     * If this method is called from a {@link Thread} that already created a {@link TransactionalDataContext} object
     * that's local to itself, we only want to access or modify the existing context. Otherwise we want to create one.
     */
    private static ThreadLocal<TransactionalDataContext> context = createThreadLocalWithInitialTransactionalDataContext();

    public static TransactionalDataContext getInstance()
    {
        if (context.get() == null)
            context.set(new TransactionalDataContext());
        return context.get();
    }

}

