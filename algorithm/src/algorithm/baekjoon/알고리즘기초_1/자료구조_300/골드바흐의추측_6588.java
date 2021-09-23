package algorithm.baekjoon.알고리즘기초_1.자료구조_300;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 골드바흐의추측_6588 {

    static boolean[] primes = new boolean[1000001];

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            primes[0] = true;
            primes[1] = true;

            for (int i = 2; i <= Math.sqrt(1000000); i++) {
                if (primes[i]) {
                    continue;
                }
                for (int j = i * 2; j <= 1000000; j += i) {
                    primes[j] = true;
                }
            }

            String line = "";
            StringBuilder sb = new StringBuilder();

            while (!(line = br.readLine()).equals("0")) {
                int target = Integer.parseInt(line);
                int min = 3;
                int max = getMaxPrime(target, min);
                int total = min + max;
                while (target != total) {
                    if (total > target) {
                        max = getMaxPrime(max - 1, min);
                    } else if (total < target) {
                        min = getMinPrime(min + 1, max);
                    }
                    if (max == -1 || min == -1) {
                        break;
                    }
                    total = min + max;
                }
                if (target != total) {
                    sb.append("Goldbach's conjecture is wrong.\n");
                } else {
                    sb.append(target + " = " + min + " + " + max + "\n");
                }
            }
            System.out.println(sb);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getMinPrime(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (!primes[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int getMaxPrime(int start, int end) {
        for (int i = start; i >= end; i--) {
            if (!primes[i]) {
                return i;
            }
        }
        return -1;
    }

}
