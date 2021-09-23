package algorithm.baekjoon.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 트로피진열_1668 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(br.readLine());
            int[] arr = new int[size];
            int max = -1;
            int count = 0;
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(br.readLine());
                if (max < arr[i]) {
                    max = arr[i];
                    count++;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(count + "\n");
            max = -1;
            count = 0;
            for (int i = size - 1; i > -1; i--) {
                if (max < arr[i]) {
                    max = arr[i];
                    count++;
                }
            }
            sb.append(count);
            System.out.println(sb.toString());
        } catch (Exception e) {

        }
    }

}
