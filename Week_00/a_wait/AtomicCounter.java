package a_wait;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class AtomicCounter {
    private volatile long counter = 0;
    private Unsafe unsafe;
    private long offset;


    public AtomicCounter() throws NoSuchFieldException {
        unsafe = getUnsafe();
        //获得counter字段在内存的起始地址
        offset = unsafe.objectFieldOffset(AtomicCounter.class.getDeclaredField("counter"));
    }

    public void increment() {
        long expect = counter;
        long update = counter + 1;
        while (!unsafe.compareAndSwapLong(this, offset, expect, update)) {
            expect = counter;
        }
    }

    public long getCounter() {
        return this.counter;
    }

    //反射获得 unsafe
    public static Unsafe getUnsafe() {
        try {
            Field singletonInstanceField = Unsafe.class.getDeclaredField("theUnsafe");
            singletonInstanceField.setAccessible(true);
            return (Unsafe) singletonInstanceField.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws NoSuchFieldException {
        int posIndex = 50;
        AtomicCounter ac = new AtomicCounter();
        while (posIndex-- > 0) {
            ac.increment();
            System.out.println(ac.getCounter());
        }
    }


}