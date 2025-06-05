package edu.tucn.str.exampleslecture6.events;

import javax.realtime.AsyncEventHandler;
import javax.realtime.Clock;
import javax.realtime.OneShotTimer;
import javax.realtime.RelativeTime;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

public class TestOneShot {
    class MyHandler implements Runnable {
        public void run() {
            System.out.println("Handler is executed on thread: " + Thread.currentThread().getName());
        }
    }

    public void test() {
        AsyncEventHandler handler = new AsyncEventHandler(new MyHandler());
        OneShotTimer timer = new OneShotTimer(new RelativeTime(2000, 0, Clock.getRealtimeClock()), handler);
        timer.start();
        System.out.println("Timer started. Will trigger the event handler in 2 sec.");
    }

    public static void main(String[] args) {
        new TestOneShot().test();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
    }
}
