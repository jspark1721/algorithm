package algorithm.baekjoon.자료구조_200;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 괄호_9012 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            while (size-- > 0) {
                String[] str = br.readLine().split("");
                int left = 0;
                int right = 0;
                int count = str.length;
                boolean isVPS = true;
                for (String target : str) {
                    if (target.equals("(")) {
                        left++;
                    } else {
                        right++;
                    }
                    count--;
                    if (right > left || left > right + count) {
                        isVPS = false;
                        break;
                    }
                }
                if (isVPS && right == left) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
