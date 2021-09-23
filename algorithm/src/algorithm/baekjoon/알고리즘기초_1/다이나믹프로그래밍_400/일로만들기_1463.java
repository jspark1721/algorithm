package algorithm.baekjoon.알고리즘기초_1.다이나믹프로그래밍_400;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 일로만들기_1463 {

    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(br.readLine());

            makeOne(num, 0);
            System.out.println(min);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void makeOne(int num, int count) {
        if (num == 1) {
            min = Math.min(min, count);
            return;
        }

        if (min <= count) {
            return;
        }
        if (num % 3 == 0) {
            makeOne(num / 3, count + 1);
        }
        if (num % 2 == 0) {
            makeOne(num / 2, count + 1);
        }

        makeOne(num - 1, count + 1);

    }

}
