package algorithm.baekjoon.hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 친구네트워크_4195 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            int tcSize = Integer.parseInt(br.readLine());
            for (int tCase = 0; tCase < tcSize; tCase++) {
                int size = Integer.parseInt(br.readLine());
                Map<String, Friend> friendNetwork = new HashMap<>();
                for (int i = 0; i < size; i++) {
                    String[] friends = br.readLine().split(" ");
                    if (!friendNetwork.containsKey(friends[0])) {
                        friendNetwork.put(friends[0], new Friend(friends[0]));
                    }

                    if (!friendNetwork.containsKey(friends[1])) {
                        friendNetwork.put(friends[1], new Friend(friends[1]));
                    }
                    Friend friend1 = friendNetwork.get(friends[0]);
                    Friend friend2 = friendNetwork.get(friends[1]);
                    addFriend(friend1, friend2);
                    int count = 0;
                    Queue<Friend> q = new LinkedList<>();
                    q.add(friend1);
                    friend1.visited = true;

                    while (!q.isEmpty()) {
                        Friend f = q.poll();
                        count++;
                        if (f.adj.size() != 0) {
                            for (Friend adj : f.adj) {
                                if (!adj.visited) {
                                    q.add(adj);
                                    adj.visited = true;
                                }
                            }
                        }
                    }
                    System.out.println(count);
                    friendNetwork.values().stream().forEach(node -> {
                        node.visited = false;
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addFriend(Friend friend1, Friend friend2) {
        friend1.adj.add(friend2);
        friend2.adj.add(friend1);
    }

}

class Friend implements Comparable<Friend> {

    String name;
    boolean visited;
    List<Friend> adj = new ArrayList<>();

    public Friend(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Friend o) {
        return 0;
    }

}