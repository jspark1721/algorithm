package algorithm.baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 최소비용구하기_1916 {

    public static List<Edge>[] adjs;
    public static int N;
    public static int M;
    public static int[] distance;


    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            adjs = new List[N + 1];
            for (int i = 1; i < N + 1; i++) {
                adjs[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                String[] con = br.readLine().split(" ");
                adjs[Integer.parseInt(con[0])].add(new Edge(Integer.parseInt(con[1]), Integer.parseInt(con[2])));
            }

            String[] info = br.readLine().split(" ");
            int start = Integer.parseInt(info[0]);
            int end = Integer.parseInt(info[1]);
            calcShort(start);
            System.out.println(distance[end]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void calcShort(int start) {
        boolean[] visited = new boolean[N + 1];
        distance = new int[N + 1];
        Arrays.fill(distance, 100000001);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (visited[edge.dst]) {
                continue;
            }
            visited[edge.dst] = true;

            for (Edge adj : adjs[edge.dst]) {
                if (distance[adj.dst] > distance[edge.dst] + adj.weight) {
                    distance[adj.dst] = distance[edge.dst] + adj.weight;
                    pq.add(new Edge(adj.dst, distance[adj.dst]));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {

        int dst;
        int weight;

        public Edge(int dst, int weight) {
            this.dst = dst;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }

    }

}
