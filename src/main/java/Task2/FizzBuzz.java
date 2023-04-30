package Task2;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class FizzBuzz {
    private int num;
    private Map<Integer, String> res;

    public FizzBuzz(int num, Map<Integer, String> res) {
        this.num = num;
        this.res = res;
    }


    void fizz() {
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                res.put(i, "fizz");
            }
        }
    }

    void buzz() {
        for (int i = 1; i <= num; i++) {
            if (i % 3 != 0 && i % 5 == 0) {
                res.put(i, "buzz");
            }
        }
    }

    void fizzBuzz() {
        for (int i = 1; i <= num; i++) {
            if (i % 15 == 0) {
                res.put(i, "fizzBuzz");
            }
        }
    }

    void number() {
        for (int i = 1; i <= num; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                res.put(i, String.valueOf(i));
            }
        }
    }
}
