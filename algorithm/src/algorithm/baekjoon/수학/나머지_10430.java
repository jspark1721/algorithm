package algorithm.baekjoon.수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나머지_10430 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            System.out.println((A + B) % C);
            System.out.println(((A % C) + (B % C)) % C);
            System.out.println((A * B) % C);
            System.out.println(((A % C) * (B % C)) % C);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
