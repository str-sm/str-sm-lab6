package edu.tucn.str.exampleslecture6.rtthreads.periodic1;

import javax.realtime.*;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

public class MainRtT1 {
    public static void main(String[] args) {
        AsyncEventHandler deadlineMissedHandler = new AsyncEventHandler() {
            public void handleAsyncEvent() {
                System.err.println("missed deadline!!!");
            }
        };

        SchedulingParameters scheduling = new PriorityParameters(10);

        ReleaseParameters releaseParams1 = new PeriodicParameters(
                new RelativeTime(), // Start at start()
                new RelativeTime(2000, 0), // 2 second period
                null, // cost
                new RelativeTime(1000, 0),// deadline=period/2
                null, // no overrun handler
                deadlineMissedHandler); // deadline miss handler

        ReleaseParameters releaseParams2 = new PeriodicParameters(
                new RelativeTime(), // Start at start()
                new RelativeTime(3000, 0), // 1 second period
                null, // cost
                new RelativeTime(1500, 0),// deadline=period/2
                null, // no overrun handler
                deadlineMissedHandler); // deadline miss handler

        RealtimeThread rtt1 =
                new MyRtThread("rtt1", scheduling, releaseParams1);
        RealtimeThread rtt2 =
                new MyRtThread("rtt2", scheduling, releaseParams2);

        rtt1.start();
        rtt2.start();
    }
}

