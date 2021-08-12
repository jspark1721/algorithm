package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class DFS와BFS_1260 {

    public static void main(String[] args) {
	try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

	    String[] condition = br.readLine().split(" ");
	    int nodeCount = Integer.parseInt(condition[0]) + 1;
	    int edgeCount = Integer.parseInt(condition[1]);
	    int startNum = Integer.parseInt(condition[2]);

	    Node[] nodes = new Node[nodeCount];
	    boolean[] visted = new boolean[nodeCount];

	    for (int i = 1; i < nodeCount; i++) {
		nodes[i] = new Node(i);
	    }

	    for (int i = 0; i < edgeCount; i++) {
		String[] edges = br.readLine().split(" ");
		addEdge(nodes[Integer.parseInt(edges[0])], nodes[Integer.parseInt(edges[1])]);
	    }

	    visted[startNum] = true;

	    dfs(nodes[startNum], visted);

	    System.out.println();
	    visted = new boolean[nodeCount];

	    Queue<Node> q = new LinkedList<>();
	    q.add(nodes[startNum]);
	    visted[startNum] = true;
	    while (!q.isEmpty()) {
		Node node = q.poll();
		System.out.print(node.number + " ");
		Collections.sort(node.adjacent);
		for (Node n : node.adjacent) {
		    if (!visted[n.number]) {
			visted[n.number] = true;
			q.add(n);
		    }
		}
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    static void addEdge(Node n1, Node n2) {
	if (n1 == n2) {
	    return;
	}
	if (!n1.adjacent.contains(n2)) {
	    n1.adjacent.add(n2);
	}
	if (!n2.adjacent.contains(n1)) {
	    n2.adjacent.add(n1);
	}
    }

    static void dfs(Node root, boolean[] visted) {

	System.out.print(root.number + " ");

	Collections.sort(root.adjacent);
	for (Node n : root.adjacent) {
	    if (!visted[n.number]) {
		visted[n.number] = true;
		dfs(n, visted);
	    }
	}
    }

}

class Node implements Comparable<Node> {

    int number;
    boolean mark;
    LinkedList<Node> adjacent = new LinkedList<>();

    public Node(int number) {
	this.number = number;
    }

    @Override
    public int compareTo(Node o) {
	return Integer.compare(this.number, o.number);
    }
}