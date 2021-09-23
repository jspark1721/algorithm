package algorithm.baekjoon.알고리즘기초_1.다이나믹프로그래밍_400;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드구매하기2_16194 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            int[] price = new int[N + 1];
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i < N + 1; i++) {
                price[i] = Integer.parseInt(tokenizer.nextToken());
            }

            for (int i = 2; i < N + 1; i++) {
                int min = price[i];
                int start = 1;
                int end = i - 1;
                for (int j = 0; j < i / 2; j++) {
                    int target = price[start + j] + price[end - j];
                    min = Math.min(min, target);
                }
                price[i] = min;
            }

            System.out.println(price[N]);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
