package algorithm.baekjoon;

import java.io.BufferedReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 바이러스_2606 {

    public static void main(String[] args) {
	try (BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in))) {
	    int size = Integer.parseInt(br.readLine()) + 1;
	    int[][] computerMap = new int[size][size];
	    boolean[][] isCheck = new boolean[size][size];

	    int count = Integer.parseInt(br.readLine());

	    for (int i = 0; i < count; i++) {
		String[] edge = br.readLine().split(" ");
		int edge1 = Integer.parseInt(edge[0]);
		int edge2 = Integer.parseInt(edge[1]);

		computerMap[edge1][edge2] = 1;
		computerMap[edge2][edge1] = 1;
	    }

	    Set<Integer> virusList = new HashSet<>();
	    Queue<Integer> q = new LinkedList<>();
	    q.add(1);
	    isCheck[1][1] = true;

	    while (!q.isEmpty()) {
		int comNum = q.poll();
		isCheck[comNum][comNum] = true;
		for (int i = 2; i < size; i++) {
		    if (!isCheck[comNum][i] && (computerMap[comNum][i] == 1)) {
			isCheck[comNum][i] = true;
			isCheck[i][comNum] = true;
			q.add(i);
			virusList.add(i);

		    }

		}
	    }

	    System.out.println(virusList.size());

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
