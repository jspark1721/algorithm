package algorithm.baekjoon.자료구조_200;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 단어뒤집기_9093 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            while (size-- > 0) {
                StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
                while (tokenizer.hasMoreTokens()) {
                    StringBuilder token = new StringBuilder(tokenizer.nextToken());
                    sb.append(token.reverse() + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
