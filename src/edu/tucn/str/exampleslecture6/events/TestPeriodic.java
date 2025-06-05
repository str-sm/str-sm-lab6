package edu.tucn.str.exampleslecture6.events;

import javax.realtime.*;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

public class TestPeriodic {

    class MyHandler implements Runnable {
        public void run() {
            System.out.println("Handler is executed executed on thread: "
                    + Thread.currentThread().getName());
        }
    }

    public void test() {
        AsyncEventHandler handler = new AsyncEventHandler(new MyHandler());

        PeriodicTimer timer = new PeriodicTimer(new AbsoluteTime(
                Clock.getRealtimeClock()), new RelativeTime(2000, 0), handler);

        System.out.println("is timer enabled? " + timer.isRunning());
        timer.start();
        System.out.println("is timer enabled? " + timer.isRunning());
    }

    public static void main(String[] args) {
        new TestPeriodic().test();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
    }
}
