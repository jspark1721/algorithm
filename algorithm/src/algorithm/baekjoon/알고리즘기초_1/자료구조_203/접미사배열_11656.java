package algorithm.baekjoon.알고리즘기초_1.자료구조_203;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 접미사배열_11656 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();

            PriorityQueue<String> pq = new PriorityQueue<>();
            pq.add(str);
            for (int i = 1; i < str.length(); i++) {
                pq.add(str.substring(i));
            }
            StringBuilder sb = new StringBuilder();
            while (!pq.isEmpty()) {
                sb.append(pq.poll() + "\n");
            }
            System.out.println(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
