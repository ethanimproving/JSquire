package framework.bases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Stack memory is allocated to an individual {@link Thread} and is basically a list of all the currently active methods.
 *
 * @see <a href="https://www.youtube.com/watch?v=Q2sFmqvpBe0">The Call Stack</a>
 * @see <a href="https://www.youtube.com/watch?v=2IXxLqRU9Mc">Java Call Stack</a>
 * @see <a href="https://www.youtube.com/watch?v=pkVREpwyrp0">Learn Java Programming - Exception Handling: The Call Stack</a>
 */
public abstract class CallStackKihonBase {

    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalErr = System.err;
    private final String STACKTRACE_REGEX = ".*at framework.bases.CallStackKihonBase.method\\d\\(CallStackKihonBase.java:\\d*\\).*";


    protected abstract void dumpStackTrace();

    @BeforeEach
    public void beforeEachTest() {
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void afterEachTest() {
        System.setOut(originalErr);
    }

    @Test
    public void dumpStackTraceTest() {
        String result = method1().replace("\r\n", "");
        Assertions.assertTrue(result.matches(STACKTRACE_REGEX));
    }

    private String method1() {
        System.out.println("method1");
        String method2 = method2();
        System.out.println("method1");
        return method2;
    }

    private String method2() {
        System.out.println("method1->method2");
        String method3 = method3();
        System.out.println("method1<-method2");
        return method3;
    }

    private String method3() {
        System.out.println("method1->method2->method3");
        String method4 = method4();
        System.out.println("method1<-method2<-method3");
        return method4;
    }

    private String method4() {
        System.out.println("method1->method2->method3->method4");
        this.dumpStackTrace();
        System.out.println(errContent);
        return errContent.toString();
    }

    private void printCallStack() {
        String callStack = Arrays.stream(Thread.currentThread().getStackTrace())
                .filter(ste -> ste.getClassName().contains("CallStack"))
                .map(StackTraceElement::getMethodName)
                .filter(name -> !name.equals("printCallStack") && !name.equals("dumpStackTraceTest"))
                .sorted(Comparator.comparing(Object::toString))
                .reduce((accumulator, currentValue) -> String.format("%s->%s", accumulator, currentValue)).orElse("method1");
        System.out.println(callStack);
    }

}
