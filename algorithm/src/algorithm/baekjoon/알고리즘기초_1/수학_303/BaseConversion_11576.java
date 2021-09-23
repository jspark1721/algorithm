package algorithm.baekjoon.알고리즘기초_1.수학_303;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BaseConversion_11576 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] radixs = br.readLine().split(" ");
            int radixA = Integer.parseInt(radixs[0]);
            int radixB = Integer.parseInt(radixs[1]);

            int size = Integer.parseInt(br.readLine());

            String[] numbers = br.readLine().split(" ");

            int result = 0;
            for (int i = 0; i < size; i++) {
                result += Math.pow(radixA, size - 1 - i) * Integer.parseInt(numbers[i]);
            }
            List<Integer> bValue = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            if (result == 0) {
                sb.append(0);
            }
            while (result != 0) {
                bValue.add(result % radixB);
                result /= radixB;
            }
            for (int i = bValue.size() - 1; i >= 0; i--) {
                sb.append(bValue.get(i) + " ");
            }
            System.out.println(sb);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
