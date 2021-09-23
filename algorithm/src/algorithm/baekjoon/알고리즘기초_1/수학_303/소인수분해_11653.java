package algorithm.baekjoon.알고리즘기초_1.수학_303;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 소인수분해_11653 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int number = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i * i <= number; i++) {
                while (number % i == 0) {
                    sb.append(i).append("\n");
                    number /= i;
                }
            }

            if (number != 1) {
                sb.append(number);
            }

            System.out.println(sb);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
