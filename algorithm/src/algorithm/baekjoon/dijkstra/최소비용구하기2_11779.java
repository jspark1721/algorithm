package algorithm.baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 최소비용구하기2_11779 {

    public static final int INF = Integer.MAX_VALUE;
    public static List<Edge>[] adj;
    public static int[] distance;
    public static boolean[] visited;
    public static int[] prevNode;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            adj = new List[n + 1];
            for (int i = 1; i < adj.length; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                String[] con = br.readLine().split(" ");
                adj[Integer.parseInt(con[0])].add(new Edge(Integer.parseInt(con[1]), Integer.parseInt(con[2])));
            }
            distance = new int[n + 1];
            visited = new boolean[n + 1];
            prevNode = new int[n + 1];
            Arrays.fill(distance, INF);
            String[] info = br.readLine().split(" ");

            int start = Integer.parseInt(info[0]);
            int end = Integer.parseInt(info[1]);

            calcShort(start);
            StringBuilder sb = new StringBuilder();
            sb.append(distance[end]).append("\n");
            int count = 1;
            int startNode = end;
            Stack<Integer> stack = new Stack<>();
            while (startNode != start) {
                count++;
                stack.push(startNode);
                startNode = prevNode[startNode];
            }
            stack.push(start);
            sb.append(count).append("\n");
            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
            System.out.println(sb);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void calcShort(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(start, 0));
        distance[start] = 0;
        prevNode[start] = start;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int node = edge.dst;

            if (visited[node]) {
                continue;
            }
            visited[node] = true;

            for (Edge adj : adj[node]) {
                if (distance[adj.dst] > distance[node] + adj.weight) {
                    distance[adj.dst] = distance[node] + adj.weight;
                    pq.add(new Edge(adj.dst, distance[adj.dst]));
                    prevNode[adj.dst] = node;
                }
            }
        }


    }

    static class Edge implements Comparable<Edge> {

        public int dst;
        public int weight;

        public Edge(int dst, int weight) {
            this.dst = dst;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }

    }

}
