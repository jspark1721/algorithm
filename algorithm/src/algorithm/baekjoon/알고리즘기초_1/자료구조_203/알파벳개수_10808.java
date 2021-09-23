package algorithm.baekjoon.알고리즘기초_1.자료구조_203;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 알파벳개수_10808 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String word = br.readLine();
            int[] counts = new int[26];
            for (char c : word.toCharArray()) {
                counts[c - 97]++;
            }

            StringBuilder sb = new StringBuilder();
            for (int count : counts) {
                sb.append(count + " ");
            }
            System.out.println(sb.toString());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
