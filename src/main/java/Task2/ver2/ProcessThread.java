package Task2.ver2;

import java.util.concurrent.atomic.AtomicBoolean;

public class ProcessThread extends Thread {
    private int number;
    private AtomicBoolean processed = new AtomicBoolean(true);
    private NumberCheck controller;

    public ProcessThread(NumberCheck controller) {
        this.controller = controller;
    }

    public void process(int num) {
        this.number = num;
        processed.set(false);
    }

    public boolean getProcessed() {
        return processed.get();
    }

    @Override
    public void run() {
        while (true) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            if (processed.get()) {
                continue;
            }

            controller.check(number);

            processed.set(true);
        }

    }
}