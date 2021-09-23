package algorithm.baekjoon.알고리즘기초_1.수학_301;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 진수8진수_1373 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();
            int size = str.length() - 1;
            StringBuilder sb = new StringBuilder();

            int result = 0;

            for (int i = 0; i < str.length(); i++) {
                String num = str.charAt(size - i) + "";

                if (i % 3 == 0) {
                    result = result + Integer.parseInt(num) * 1;
                } else if (i % 3 == 1) {
                    result = result + Integer.parseInt(num) * 2;
                } else if (i % 3 == 2) {
                    result = result + Integer.parseInt(num) * 2 * 2;
                    sb.append(result);
                    result = 0;
                }
            }
            if (result != 0 || sb.toString().isEmpty()) {
                sb.append(result);
            }
            System.out.println(sb.reverse());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
