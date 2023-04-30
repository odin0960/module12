package Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

public class FizzBuzzTest {

    public static void main(String[] args) {
        int num = 21;
        Map<Integer, String> res = new ConcurrentSkipListMap<>();
        FizzBuzz fizzbuzz = new FizzBuzz(num, res);

        Thread fizzCheckA = new Thread(fizzbuzz::fizz);
        Thread buzzCheckB = new Thread(fizzbuzz::buzz);
        Thread fizzBuzzCheckC = new Thread(fizzbuzz::fizzBuzz);
        Thread numberCheckD = new Thread(fizzbuzz::number);

        List<Thread> threads = new ArrayList<>();
        threads.add(fizzCheckA);
        threads.add(buzzCheckB);
        threads.add(fizzBuzzCheckC);
        threads.add(numberCheckD);

        for (Thread thread : threads) {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (!fizzCheckA.isAlive()
                && !buzzCheckB.isAlive()
                && !fizzBuzzCheckC.isAlive()
                && !numberCheckD.isAlive()) {
            System.out.println(res.keySet()
                    .stream()
                    .map(i -> res.get(i) + "")
                    .collect(Collectors.joining(", ")));
        }
    }
}

