package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 평균_1546 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(br.readLine());
            int max = 0;
            int[] scores = new int[size];
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < size; i++) {
                int score = Integer.parseInt(str[i]);
                max = Math.max(max, score);
                scores[i] = score;
            }

            double total = 0;
            double con = 100.0 / max;

            for (int score : scores) {
                total += score * con;
            }
            System.out.println(total / size);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
