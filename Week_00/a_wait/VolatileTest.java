package a_wait;

import java.nio.charset.StandardCharsets;

public class VolatileTest {
    private static int COUNTER = 0;


    public static void main(String[] args) {


//        new ChangeListener().start();
//        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {

        @Override
        public void run() {
            int value = 0;
            while (value < 5) {
                if (value != COUNTER) {
                    System.out.println("changed! " + COUNTER);
                    value = COUNTER;

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    static class ChangeMaker extends Thread {
        @Override
        public void run() {
            while (COUNTER < 10) {

                synchronized (ChangeMaker.class) {
                    COUNTER++;
                    System.out.println("increment!  " + (COUNTER));
                }
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
