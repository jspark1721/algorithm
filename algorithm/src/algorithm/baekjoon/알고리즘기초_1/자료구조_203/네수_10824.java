package algorithm.baekjoon.알고리즘기초_1.자료구조_203;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 네수_10824 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] array = br.readLine().split(" ");
            BigInteger bi1 = new BigInteger(array[0] + array[1]);
            BigInteger bi2 = new BigInteger(array[2] + array[3]);
            System.out.println(bi1.add(bi2).toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
