package algorithm.baekjoon.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소힙_1927 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> q = new PriorityQueue<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                int input = Integer.parseInt(br.readLine());
                if (input == 0) {
                    if (q.isEmpty()) {
                        sb.append("0\n");
                    } else {
                        sb.append(q.poll() + "\n");
                    }
                } else {
                    q.add(input);
                }
            }
            System.out.println(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
