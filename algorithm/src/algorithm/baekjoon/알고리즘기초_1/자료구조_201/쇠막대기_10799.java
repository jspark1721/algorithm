package algorithm.baekjoon.알고리즘기초_1.자료구조_201;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 쇠막대기_10799 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();
            int count = 0;
            int result = 0;
            boolean prev = false;
            for (char c : str.toCharArray()) {
                if (c == '(') {
                    count++;
                    prev = true;
                } else if (c == ')') {
                    count--;
                    if (prev) {
                        result = result + count;
                    } else {
                        result++;
                    }
                    prev = false;
                }
            }
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
