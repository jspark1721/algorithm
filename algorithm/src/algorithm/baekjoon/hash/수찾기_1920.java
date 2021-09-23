package algorithm.baekjoon.hash;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 수찾기_1920 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        Map<Integer, Integer> cache = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            cache.put(sc.nextInt(), 1);
//        }
//        int m = sc.nextInt();
//        for (int i = 0; i < m; i++) {
//            if (cache.containsKey(sc.nextInt())) {
//                System.out.println(1);
//            } else {
//                System.out.println(0);
//            }
//        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> cache = new HashSet<>();
        for (int i = 0; i < n; i++) {
            cache.add(sc.nextInt());
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            if (cache.add(sc.nextInt())) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }
    }

}
