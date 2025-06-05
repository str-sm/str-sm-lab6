package edu.tucn.str.exampleslecture6.events;

import javax.realtime.AsyncEvent;
import javax.realtime.AsyncEventHandler;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

public class AehExample {

    class MyHandler implements Runnable {
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": handler is executed");
        }
    }

    public void test() {
        AsyncEventHandler h = new AsyncEventHandler(new MyHandler());
        AsyncEvent event = new AsyncEvent();

        event.addHandler(h);

        event.fire();
        event.fire();

        System.out.println(Thread.currentThread().getName() + ": is handled? " + event.handledBy(h));
    }

    public static void main(String[] args) {
        new AehExample().test();

        try {
            Thread.sleep(2000); // wait for the handler to finish
        } catch (InterruptedException e) {
        }
    }

}
