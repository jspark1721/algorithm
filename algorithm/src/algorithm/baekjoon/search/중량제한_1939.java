package algorithm.baekjoon.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 중량제한_1939 {

    public static Map<Integer, Island> islandMap = new HashMap<>();
    public static boolean[] visited;
    public static int start;
    public static int end;
    public static int islandCount;
    public static int result = -1;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String condition[] = br.readLine().split(" ");
            islandCount = Integer.parseInt(condition[0]);
            int bridgeCount = Integer.parseInt(condition[1]);
            int min = Integer.MAX_VALUE;
            int max = -1;
            for (int i = 1; i < islandCount + 1; i++) {
                islandMap.put(i, new Island(i));
            }
            for (int i = 0; i < bridgeCount; i++) {
                String map[] = br.readLine().split(" ");
                addBridge(Integer.parseInt(map[0]), Integer.parseInt(map[1]), Integer.parseInt(map[2]));
                min = Math.min(min, Integer.parseInt(map[2]));
                max = Math.max(max, Integer.parseInt(map[2]));
            }
            String goal[] = br.readLine().split(" ");
            start = Integer.parseInt(goal[0]);
            end = Integer.parseInt(goal[1]);

            while (min <= max) {
                int mid = (max + min) / 2;
                if (dfs(mid)) {
                    result = mid;
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }

            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void addBridge(int island1, int island2, int weight) {
        Island i1 = islandMap.get(island1);
        Island i2 = islandMap.get(island2);
        i1.adj.add(new Bridge(weight, i2));
        i2.adj.add(new Bridge(weight, i1));
    }

    public static boolean dfs(int weight) {
        Queue<Island> q = new LinkedList<>();
        q.add(islandMap.get(start));
        visited = new boolean[islandCount + 1];
        visited[start] = true;

        while (!q.isEmpty()) {
            Island island = q.poll();
            if (island.num == end) {
                break;
            }
            for (Bridge bridge : island.adj) {
                if (!visited[bridge.dest.num] && bridge.weight >= weight) {
                    visited[bridge.dest.num] = true;
                    q.add(islandMap.get(bridge.dest.num));
                }
            }
        }
        return visited[end];
    }

}

class Island {

    public int num;
    public LinkedList<Bridge> adj;

    public Island(int num) {
        this.num = num;
        this.adj = new LinkedList<>();
    }


}

class Bridge {

    public int weight;
    public Island dest;

    public Bridge(int weight, Island dest) {
        this.weight = weight;
        this.dest = dest;
    }

}
