package edu.tucn.str.exampleslecture6.events;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.Interruptible;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

public class AtcExample {
    public static void main(String[] args) {
        Target target = new Target();
        Killer killer = new Killer(target);
        target.start();
        killer.start();
    }
}

class Target extends Thread {
    AsynchronouslyInterruptedException aie = new AsynchronouslyInterruptedException();

    public void run() {
        aie.doInterruptible(new TargetActivity());
    }

    public AsynchronouslyInterruptedException getAie() {
        return aie;
    }
}

class TargetActivity implements Interruptible {
    volatile int counter = 0;

    public void interruptAction(AsynchronouslyInterruptedException arg0) {
        System.out.println("I lived just " + counter + " seconds!");
    }

    public void run(AsynchronouslyInterruptedException arg0)
            throws AsynchronouslyInterruptedException {
        while (true) { //do nothing; just sleep
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            counter++;
        }
    }
}

class Killer extends Thread {
    Target target;

    public Killer(Target target) {
        this.target = target;
    }

    public void run() {
        boolean dismissed = false;
        BufferedReader scanner = new BufferedReader(new InputStreamReader(
                System.in));
        while (!dismissed) {
            System.out.println("Input message:");
            try {
                if (scanner.readLine().equals("kill")) {
                    target.getAie().fire();
                    dismissed = true;
                    System.err.println("...target cleared!");
                } else {
                    System.err.println("...waiting for the green light");
                }
            } catch (Exception e) {
            }
        }
    }
}
