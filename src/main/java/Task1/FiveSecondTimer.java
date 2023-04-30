package Task1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

class FiveSecondTimer {

    public static void main(String[] args) {

        int runningTime = 20;   // загальна тривалість, секунд
        int period1 = 1;   // секунд
        int period2 = 5;   // секунд
        int delay1 = 1;    // секунд
        int delay2 = 5;    // секунд

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        long start = System.currentTimeMillis();

        ScheduledFuture<?> timer1 = scheduler.scheduleAtFixedRate(() -> System.out.println((System.currentTimeMillis() - start) / 1000 + " сек."), delay1, period1, SECONDS);
        ScheduledFuture<?> timer2 = scheduler.scheduleAtFixedRate(() -> System.out.println("Минуло " + period2 + " секунд"), delay2, period2, SECONDS);

        scheduler.schedule(() -> {
            timer1.cancel(true);
            timer2.cancel(true);
        }, runningTime, SECONDS);
    }
}
