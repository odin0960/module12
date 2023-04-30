package Task1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

class FiveSecondTimer {

    public static void main(String[] args) {

        int runningTime = 20;   // тривалість
        int period1 = 1;   //
        int period2 = 5;   //
        int delay1 = 0;    //
        int delay2 = 5;    //

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        long start = System.currentTimeMillis();

        ScheduledFuture<?> timer1 = scheduler.scheduleAtFixedRate(() -> System.out.println(System.currentTimeMillis() - start), delay1, period1, SECONDS);
        ScheduledFuture<?> timer2 = scheduler.scheduleAtFixedRate(() -> System.out.println("Минуло " + period2 + " секунд"), delay2, period2, SECONDS);

        scheduler.schedule(() -> {
            timer1.cancel(true);
            timer2.cancel(true);
        }, runningTime, SECONDS);
    }
}
