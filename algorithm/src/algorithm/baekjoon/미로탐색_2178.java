package algorithm.baekjoon;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탐색_2178 {

    static int[] xArr = { 0, 1, 0, -1 };
    static int[] yArr = { 1, 0, -1, 0 };

    public static void main(String[] args) {
	try (BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in))) {
	    String[] size = br.readLine().split(" ");
	    int n = Integer.parseInt(size[0]);
	    int m = Integer.parseInt(size[1]);
	    int maze[][] = new int[n][m];
	    boolean visted[][] = new boolean[n][m];
	    String str = "";
	    for (int count = 0; count < n; count++) {
		str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
		    maze[count][i] = str.charAt(i) - '0';
		}
	    }
//	    printMaze(maze, n, m);

	    Queue<Point> q = new LinkedList<>();

	    q.add(new Point(0, 0, 1));

	    while (!q.isEmpty()) {
		Point node = q.poll();

		if ((node.row + 1 == n) && (node.col + 1 == m)) {
		    System.out.println(node.depth);
		    break;

		}

		for (int i = 0; i < 4; i++) {
		    int moveRow = node.row + yArr[i];
		    int moveCol = node.col + xArr[i];

		    if (moveRow > -1 && moveRow < n && moveCol > -1 && moveCol < m) {
			if ((maze[moveRow][moveCol] == 1) && !visted[moveRow][moveCol]) {
			    visted[moveRow][moveCol] = true;
			    q.add(new Point(moveRow, moveCol, node.depth + 1));
			}
		    }

		}
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

//    public static void printMaze(int[][] maze, int row, int col) {
//	for (int i = 0; i < row; i++) {
//	    for (int j = 0; j < col; j++) {
//		System.out.print(maze[i][j]);
//	    }
//	    System.out.println();
//	}
//    }

}

class Point {
    int row;
    int col;
    int depth;

    public Point(int row, int col, int depth) {
	this.row = row;
	this.col = col;
	this.depth = depth;
    }
}
