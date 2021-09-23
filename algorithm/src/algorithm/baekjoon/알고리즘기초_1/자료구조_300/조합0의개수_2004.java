package algorithm.baekjoon.알고리즘기초_1.자료구조_300;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 조합0의개수_2004 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] con = br.readLine().split(" ");
            int n = Integer.parseInt(con[0]);
            int m = Integer.parseInt(con[1]);

            long five = 0;
            long two = 0;

            five = getFive(n);
            two = getTwo(n);

            five -= getFive(m);
            five -= getFive(n - m);

            two -= getTwo(m);
            two -= getTwo(n - m);
            System.out.println(Math.min(five, two));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long getFive(long n) {
        long cnt = 0;
        for (long i = 5; i <= n; i *= 5) {
            cnt += n / i;
        }
        return cnt;
    }

    public static long getTwo(long n) {
        long cnt = 0;
        for (long i = 2; i <= n; i *= 2) {
            cnt += n / i;
        }
        return cnt;
    }

}
