package framework.bases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class StackMemoryKihonBase {

    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalErr = System.err;
    private final String STACKTRACE_REGEX = ".*at framework.bases.StackMemoryKihonBase.method\\d\\(StackMemoryKihonBase.java:\\d*\\).*";


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

}
