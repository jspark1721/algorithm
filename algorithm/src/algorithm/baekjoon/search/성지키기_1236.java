package algorithm.baekjoon.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 성지키기_1236 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            int[] row = new int[n];
            int rm = 0;
            int cm = 0;
            int[] col = new int[m];

            int[][] arr = new int[n][m];

            for (int i = 0; i < n; i++) {
                String s1 = br.readLine();
                for (int j = 0; j < s1.length(); j++) {
                    if (s1.charAt(j) == 'X') {
                        if (row[i] == 0) {
                            row[i] = 1;
                            rm++;
                        }
                        if (col[j] == 0) {
                            col[j] = 1;
                            cm++;
                        }
                    }
                }
            }
            System.out.println(Math.max(n - rm, m - cm));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
