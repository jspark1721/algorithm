package algorithm.baekjoon.알고리즘기초_1.다이나믹프로그래밍_400;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 일이삼더하기_9095 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(br.readLine());
            int[] tCase = new int[size];
            int max = -1;
            for (int i = 0; i < size; i++) {
                tCase[i] = Integer.parseInt(br.readLine());
                max = Math.max(max, tCase[i]);
            }

            int[] counts = new int[max + 1];
            for (int i = 1; i < counts.length; i++) {
                int num;
                if (i == 1) {
                    num = 1;
                } else if (i == 2) {
                    num = 2;
                } else if (i == 3) {
                    num = 4;
                } else {
                    num = counts[i - 1] + counts[i - 2] + counts[i - 3];
                }
                counts[i] = num;
            }
            StringBuilder sb = new StringBuilder();
            for (int num : tCase) {
                sb.append(counts[num]).append("\n");
            }
            System.out.println(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
