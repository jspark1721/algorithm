package algorithm.baekjoon.수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대공약수와최소공배수_2609 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int min = Math.min(a, b);
            int max = Math.max(a, b);
            int temp = -1;
            while (temp != 0) {
                temp = max % min;
                max = min;
                min = temp;
            }

            System.out.println(max);
            System.out.println(a * b / max);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
