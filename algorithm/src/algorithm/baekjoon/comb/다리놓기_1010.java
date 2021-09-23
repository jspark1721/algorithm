package algorithm.baekjoon.comb;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 다리놓기_1010 {

    private static int[][] dp = new int[31][31];

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < T; i++) {
                String[] con = br.readLine().split(" ");

                int N = Integer.parseInt(con[0]);
                int M = Integer.parseInt(con[1]);
                sb.append(com(M, N) + "\n");
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int com(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }
        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }
        return dp[n][r] = com(n - 1, r - 1) + com(n - 1, r);
    }

}
