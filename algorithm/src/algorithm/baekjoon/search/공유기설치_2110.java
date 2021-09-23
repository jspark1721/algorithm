package algorithm.baekjoon.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 공유기설치_2110 {


    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String condition[] = br.readLine().split(" ");
            int size = Integer.parseInt(condition[0]);
            int count = Integer.parseInt(condition[1]);

            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);
            int minGap = 1;
            int maxGap = arr[size - 1] - arr[0];

            int result = 1;

            while (minGap <= maxGap) {
                int target = arr[0];
                int check = 1;
                int min = Integer.MAX_VALUE;
                int gap = (maxGap + minGap) / 2;
                for (int j = 1; j < size; j++) {
                    if (arr[j] - target >= gap) {
                        check++;
                        if (min > arr[j] - target) {
                            min = arr[j] - target;
                        }
                        target = arr[j];
                    }
                }
                if (check >= count) {
                    if (result < min) {
                        result = min;
                    }
                }
                if (maxGap == minGap) {
                    break;
                }
                if (check >= count) {
                    minGap = gap + 1;
                } else {
                    maxGap = gap - 1;
                }
            }
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
