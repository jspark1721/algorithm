package algorithm.baekjoon.알고리즘기초_1.수학_301;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 진수2진수_1212 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            int num = Integer.parseInt(str.charAt(0) + "");
            if (num == 0) {
                sb.append(0);
            } else {
                while (num != 0) {
                    sb.append(num % 2);
                    num = num / 2;
                }
                sb.reverse();
            }

            for (int i = 1; i < str.length(); i++) {
                num = Integer.parseInt(str.charAt(i) + "");
                StringBuilder word = new StringBuilder();
                int count = 3;
                while (count-- > 0) {
                    word.append(num % 2);
                    num = num / 2;
                }
                sb.append(word.reverse());
            }
            System.out.println(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
