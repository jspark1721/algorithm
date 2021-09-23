package algorithm.baekjoon.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 문제집_1766 {

    public static StringBuilder sb = new StringBuilder();
    public static List<List<Integer>> list = new ArrayList<>();
    public static int[] indegree;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] conditions = br.readLine().split(" ");
            int size = Integer.parseInt(conditions[0]);
            int infoCount = Integer.parseInt(conditions[1]);

            indegree = new int[size + 1];
            for (int i = 0; i < size + 1; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < infoCount; i++) {
                String[] info = br.readLine().split(" ");
                int pre = Integer.parseInt(info[0]);
                int target = Integer.parseInt(info[1]);

                list.get(pre).add(target);
                indegree[target]++;
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i = 1; i < size + 1; i++) {
                if (indegree[i] == 0) {
                    pq.add(i);
                }
            }
            while (!pq.isEmpty()) {
                int node = pq.poll();
                for (int i : list.get(node)) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        pq.add(i);
                    }
                }
                sb.append(node + " ");
            }

            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
