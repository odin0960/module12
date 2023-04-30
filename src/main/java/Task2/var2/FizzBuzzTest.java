package Task2.var2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FizzBuzzTest {
    public static void main(String[] args) {
        int num = 21;
        List<String> res = new ArrayList<>();

        var fizzThread = new ProcessThread(n -> {
            if (n % 3 == 0 && n % 5 != 0) {
//                System.out.print("fizz, ");
                res.add("fizz");
            }
        });

        var buzzThread = new ProcessThread((n) -> {
            if (n % 3 != 0 && n % 5 == 0) {
//                System.out.print("buzz, ");
                res.add("buzz");
            }
        });

        var fizzBuzzThread = new ProcessThread(n -> {
            if (n % 15 == 0) {
//                System.out.print("fizzbuzz, ");
                res.add("fizzbuzz");
            }
        });

        var numberThread = new ProcessThread((n) -> {
            if (n % 3 != 0 && n % 5 != 0) {
//                System.out.print(n + ", ");
                res.add("" + n);
            }
        });

        List<ProcessThread> threads = new ArrayList<>();
        threads.add(fizzThread);
        threads.add(buzzThread);
        threads.add(fizzBuzzThread);
        threads.add(numberThread);

        for (ProcessThread thread : threads) {
            thread.start();
        }

        for (int i = 1; i <= num; i++) {
            for (ProcessThread thread : threads) {
                thread.process(i);
            }
            while (true) {
                int processedCount = 0;
                for (ProcessThread thread : threads) {
                    if (thread.getProcessed()) {
                        processedCount++;
                    }
                }
                if (processedCount == threads.size()) {
                    break;
                }
            }
        }

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> System.out.println(String.join(", ", res)));

//        System.out.println(String.join(", ", res));

//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            String command = scanner.nextLine();
//            if (command.equals("")) {
//        System.out.println(String.join(", ", res));
//                System.exit(0);
//            }
//        }
    }
}