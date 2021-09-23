package algorithm.baekjoon.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 새_1568 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int size = n;
            int count = 1;
            int retVal = 0;
            while (n != 0) {
                if (count > n) {
                    count = 1;
                }
                n -= count++;
                retVal++;

            }
            System.out.println(retVal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
