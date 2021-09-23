package algorithm.baekjoon.수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최소공배수_1934 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(tokenizer.nextToken());
                int b = Integer.parseInt(tokenizer.nextToken());
                int max = 0;
                int min = 0;
                if (a > b) {
                    max = a;
                    min = b;
                } else {
                    max = b;
                    min = a;
                }
                int temp = -1;
                while (temp != 0) {
                    temp = max % min;
                    max = min;
                    min = temp;
                }
                sb.append(a * b / max + "\n");
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
