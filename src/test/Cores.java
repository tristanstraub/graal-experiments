package test;

import org.graalvm.nativeimage.IsolateThread;
import org.graalvm.nativeimage.c.function.CEntryPoint;
import test.Thing;

public class Cores {
    @CEntryPoint(name = "add2")
    public static int add2(IsolateThread thread, int a, int b) {
        return test.Thing.add3(a, b);
    }
}
