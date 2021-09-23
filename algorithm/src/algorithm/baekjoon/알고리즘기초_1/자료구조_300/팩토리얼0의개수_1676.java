package algorithm.baekjoon.알고리즘기초_1.자료구조_300;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 팩토리얼0의개수_1676 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            BigInteger result = new BigInteger("1");
            int size = Integer.parseInt(br.readLine());
            for (int i = size; i > 0; i--) {
                result = result.multiply(new BigInteger(i + ""));
            }
            int count = 0;
            String str = result.toString();
            for (int i = str.length() - 1; i > -1; i--) {
                if (str.charAt(i) != '0') {
                    break;
                }
                count++;
            }
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
