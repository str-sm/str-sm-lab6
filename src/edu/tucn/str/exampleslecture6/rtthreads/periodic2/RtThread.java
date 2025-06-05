package edu.tucn.str.exampleslecture6.rtthreads.periodic2;

import javax.realtime.RealtimeThread;
import javax.realtime.ReleaseParameters;
import javax.realtime.SchedulingParameters;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

public class RtThread extends RealtimeThread {

    public RtThread(String name, SchedulingParameters sched, ReleaseParameters release) {
        super(sched, release);
        this.setName(name);
    }

    public void run() {
        RealtimeThread me = currentRealtimeThread();
        int T = 0;
        do {
            System.out.println(this.getName() + " is in period " + T++);

            for (int i = 0; i < 99000; i++) {
                i++;
                i--;
            }

            //simulate heavy computation in order to miss the deadline
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
        } while (me.waitForNextPeriod());
    }
}