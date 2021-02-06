package a_wait;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    public static void main(String[] args) {
        int posIndex = 10;
        AtomicInteger atomicIntegerTest = new AtomicInteger();
        while (posIndex-- > 0)
            atomicIntegerTest.getAndIncrement();
        System.out.println(atomicIntegerTest.get());

    }
}
