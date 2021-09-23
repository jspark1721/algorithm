package algorithm.baekjoon.알고리즘기초_1.수학_303;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 진법변환2_11005 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] con = br.readLine().split(" ");
            int num = Integer.parseInt(con[0]);
            int radix = Integer.parseInt(con[1]);
            StringBuilder sb = new StringBuilder();
            if (num == 0) {
                sb.append(0);
            }
            while (num != 0) {
                int mod = num % radix;
                if (mod > 9) {
                    sb.append((char) (mod + 55));
                } else {
                    sb.append(mod);
                }
                num /= radix;
            }
            System.out.println(sb.reverse());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
