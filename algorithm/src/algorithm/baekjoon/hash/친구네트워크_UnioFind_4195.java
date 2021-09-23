package algorithm.baekjoon.hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 친구네트워크_UnioFind_4195 {

    static int[] parent;
    static int[] level;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            int tcSize = Integer.parseInt(br.readLine());
            for (int tCase = 0; tCase < tcSize; tCase++) {
                int size = Integer.parseInt(br.readLine());
                Map<String, Integer> friendNetwork = new HashMap<>();
                StringBuilder sb = new StringBuilder();
                int idx = 0;
                parent = new int[size * 2];
                level = new int[size * 2];
                for (int i = 0; i < 2 * size; i++) {
                    parent[i] = i;
                    level[i] = 1;
                }
                for (int i = 0; i < size; i++) {
                    String[] friends = br.readLine().split(" ");
                    if (!friendNetwork.containsKey(friends[0])) {
                        friendNetwork.put(friends[0], idx++);
                    }

                    if (!friendNetwork.containsKey(friends[1])) {
                        friendNetwork.put(friends[1], idx++);
                    }
                    sb.append(union(friendNetwork.get(friends[0]), friendNetwork.get(friends[1]))).append("\n");
                }
                System.out.print(sb.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
            level[x] += level[y];
        }
        return level[x];
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

}
