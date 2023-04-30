package Task1.var2;

import java.util.Scanner;

class FiveSecondTimerOld {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        new Thread(() -> {
            try {
                while (true) {
                    System.out.println(System.currentTimeMillis() - start);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            try {
                while (true) {
//        while(!Thread.currentThread().isInterrupted())
                    Thread.sleep(5000);
                    System.out.println("Минуло 5 сек.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
//        Thread.currentThread().interrupt()
            }
        }).start();


        Scanner scanner = new Scanner(System.in);  //натиснути Enter, щоб зупинити программу
        while (true) {
            String command = scanner.nextLine();
            if (command.equals(""))
                System.exit(0);
        }
    }
}
