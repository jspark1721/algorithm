package algorithm.baekjoon.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 좌표정렬하기_11650 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] map = new int[size][2];
        for (int i = 0; i < size; i++) {
            map[i][0] = sc.nextInt();
            map[i][1] = sc.nextInt();
        }
        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int retVal = o1[0] - o2[0];
                if (retVal == 0) {
                    retVal = o1[1] - o2[1];
                }
                return retVal;
            }
        });
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.append(map[i][0] + " " + map[i][1]).append("\n");
        }
        System.out.println(sb.toString());
    }

}
