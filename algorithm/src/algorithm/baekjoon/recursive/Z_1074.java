package algorithm.baekjoon.recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Z_1074 {

    public static int[] dx = {0, 1, 0, 1};
    public static int[] dy = {0, 0, 1, 1};
    public static int r;
    public static int c;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            String[] s = br.readLine().split(" ");
            int N = (int) Math.pow(2, Integer.parseInt(s[0]));
            r = Integer.parseInt(s[1]);
            c = Integer.parseInt(s[2]);

            getZ(N, 0, 0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void getZ(int N, int row, int col, int cnt) {
        if (row > r || row + N <= r || col > c || col + N <= c) return;
        if (N == 2) {
            for (int i = 0; i < 4; i++) {
                if ((row + dy[i] == r) && (col + dx[i] == c)) {
                    System.out.println(cnt + i);
                    System.exit(0);
                }
            }
            return;
        }
        int newN = N / 2;
        getZ(newN, row, col, cnt);
        getZ(newN, row, col + newN, cnt + (newN * newN));
        getZ(newN, row + newN, col, cnt + (newN * newN * 2));
        getZ(newN, row + newN, col + newN, cnt + (newN * newN * 3));
    }


}
