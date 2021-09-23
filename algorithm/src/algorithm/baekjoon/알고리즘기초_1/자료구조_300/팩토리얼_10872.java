package algorithm.baekjoon.알고리즘기초_1.자료구조_300;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 팩토리얼_10872 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int result = 1;
            int size = Integer.parseInt(br.readLine());
            for (int i = size; i > 0; i--) {
                result *= i;
            }
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
