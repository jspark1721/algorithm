package algorithm.baekjoon.알고리즘기초_1.다이나믹프로그래밍_400;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 쉬운계단수_10844 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            long[] counts = new long[N + 1];
            counts[1] = 9;
            for (int i = 2; i < N + 1; i++) {

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Node {

        int count;
        int nineCount;


    }

}
