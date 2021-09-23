package algorithm.baekjoon.알고리즘기초_1.자료구조_300;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수찾기_1978 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            boolean[] isPrime = new boolean[1001];
            isPrime[0] = true;
            isPrime[1] = true;

            for (int i = 2; i <= Math.sqrt(1000); i++) {
                if (isPrime[i]) {
                    continue;
                }
                for (int j = i + i; j <= 1000; j += i) {
                    isPrime[j] = true;
                }
            }

            br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            int count = 0;
            while (tokenizer.hasMoreTokens()) {
                if (!isPrime[Integer.parseInt(tokenizer.nextToken())]) {
                    count++;
                }
            }
            System.out.println(count);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
