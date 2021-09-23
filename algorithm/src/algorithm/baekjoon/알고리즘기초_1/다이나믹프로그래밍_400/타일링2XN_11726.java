package algorithm.baekjoon.알고리즘기초_1.다이나믹프로그래밍_400;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 타일링2XN_11726 {

    public static int[] counts;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(br.readLine());
            counts = new int[size + 1];

            counts[1] = 1;
            if (size > 1) {
                counts[2] = 2;
            }

            for (int i = 3; i <= size; i++) {
                int result = counts[i - 1] + counts[i - 2];

                counts[i] = result % 10007;
            }
            System.out.println(counts[size]);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
