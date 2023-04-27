package Task1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

class FiveSecondTimer {

    public static void main(String[] args) {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        long start = System.currentTimeMillis();

        scheduler.scheduleAtFixedRate(() -> System.out.println((System.currentTimeMillis() - start)), 0, 1, SECONDS);
        scheduler.scheduleAtFixedRate(() -> System.out.println("Минуло 5 секунд"), 5, 5, SECONDS);

    }
}
