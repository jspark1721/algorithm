package algorithm.baekjoon.알고리즘기초_1.자료구조_300;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 소수구하기_1929 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] con = br.readLine().split(" ");
            int max = Integer.parseInt(con[1]);
            boolean[] primes = new boolean[max + 1];
            primes[0] = true;
            primes[1] = true;

            for (int i = 2; i <= Math.sqrt(max); i++) {
                if (primes[i]) {
                    continue;
                }
                for (int j = i + i; j <= max; j += i) {
                    primes[j] = true;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = Integer.parseInt(con[0]); i <= max; i++) {
                if (!primes[i]) {
                    sb.append(i + "\n");
                }
            }
            System.out.println(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
