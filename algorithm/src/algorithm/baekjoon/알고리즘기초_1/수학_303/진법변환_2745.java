package algorithm.baekjoon.알고리즘기초_1.수학_303;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 진법변환_2745 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] con = br.readLine().split(" ");
            String target = con[0];
            int radix = Integer.parseInt(con[1]);
            int result = 0;
            for (int i = 0; i < target.length(); i++) {
                int num = (int) target.charAt(target.length() - 1 - i) - '0';
                if (num >= 17) {
                    num = num - 7;
                }
                result += (Math.pow(radix, i) * num);
            }
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
