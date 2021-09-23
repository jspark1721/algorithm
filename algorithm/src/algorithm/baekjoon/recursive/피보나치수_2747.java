package algorithm.baekjoon.recursive;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 피보나치수_2747 {

    public static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
//        int[] fibo = new int[size + 1];
//        fibo[0] = 0;
//        fibo[1] = 1;
//
//        for (int i = 2; i < fibo.length; i++) {
//            fibo[i] = fibo[i - 1] + fibo[i - 2];
//        }
//        System.out.println(fibo[size]);
        cache.put(0, 0);
        cache.put(1, 1);
        System.out.println(calFibo(size));

    }

    public static int calFibo(int x) {
        Integer cacheVal = cache.get(x);
        if (cacheVal != null) {
            return cacheVal;
        }

        int retVal = calFibo(x - 1) + calFibo(x - 2);
        cache.put(x, retVal);
        return retVal;
    }

}
