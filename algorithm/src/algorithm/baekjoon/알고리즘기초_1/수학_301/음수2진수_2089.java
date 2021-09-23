package algorithm.baekjoon.알고리즘기초_1.수학_301;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 음수2진수_2089 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            if (num == 0) {
                sb.append(num);
            }
            while (num != 0) {
                int mod = num % -2;
                if (mod < 0) {
                    mod = mod * -1;
                }
                num -= mod;
                sb.append(mod);
                num = num / -2;
            }
            System.out.println(sb.reverse());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
