package algorithm.baekjoon.알고리즘기초_1.수학_301;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class GCD합_9613 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(br.readLine());
            while (size-- > 0) {
                String[] str = br.readLine().split(" ");
                int[] array = new int[str.length - 1];
                for (int i = 0; i < str.length - 1; i++) {
                    array[i] = Integer.parseInt(str[i + 1]);
                }
                Arrays.sort(array);
                BigInteger result = new BigInteger("0");
                for (int i = 0; i < array.length - 1; i++) {
                    for (int j = i + 1; j < array.length; j++) {
                        int min = array[i];
                        int max = array[j];
                        int temp = -1;

                        while (temp != 0) {
                            temp = max % min;
                            max = min;
                            min = temp;
                        }
                        result = result.add(new BigInteger(max + ""));
                    }

                }
                System.out.println(result.toString());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
