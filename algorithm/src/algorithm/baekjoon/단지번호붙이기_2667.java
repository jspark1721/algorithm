package algorithm.baekjoon;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 단지번호붙이기_2667 {
    static int[] xArr = { 0, 1, 0, -1 };
    static int[] yArr = { 1, 0, -1, 0 };

    public static void main(String[] args) {
	try (BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in))) {
	    int size = Integer.parseInt(br.readLine());
	    int apt[][] = new int[size][size];
	    boolean visted[][] = new boolean[size][size];
	    for (int count = 0; count < size; count++) {
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
		    apt[count][i] = str.charAt(i) - '0';
		}
	    }

//	    printMaze(apt, size, size);

	    List<Integer> aptCountList = new ArrayList<>();
	    int count = 0;
	    System.out.println(size);
	    for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
		    if (visted[i][j] || (apt[i][j] != 1)) {
			continue;
		    }
		    count++;
		    Queue<Apart> q = new LinkedList<>();
		    q.add(new Apart(i, j));
		    visted[i][j] = true;
		    int aptCount = 1;
		    while (!q.isEmpty()) {
			Apart apart = q.poll();

			for (int chk = 0; chk < 4; chk++) {
			    int moveRow = apart.row + yArr[chk];
			    int moveCol = apart.col + xArr[chk];

			    if (moveRow > -1 && moveRow < size && moveCol > -1 && moveCol < size) {
				if ((apt[moveRow][moveCol] == 1) && !visted[moveRow][moveCol]) {
				    visted[moveRow][moveCol] = true;
				    q.add(new Apart(moveRow, moveCol));
				    aptCount++;
				}
			    }
			}
		    }
		    aptCountList.add(aptCount);
		}
	    }
	    System.out.println(count);
	    aptCountList.stream().sorted().forEach(item -> {
		System.out.println(item);
	    });
//	    while (!aptCountList.isEmpty()) {
//		System.out.println(aptCountList.poll());
//	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static void printMaze(int[][] maze, int row, int col) {
	for (int i = 0; i < row; i++) {
	    for (int j = 0; j < col; j++) {
		System.out.print(maze[i][j] + ", ");
	    }
	    System.out.println();
	}
    }
}

class Apart {
    int row;
    int col;

    public Apart(int row, int col) {
	this.row = row;
	this.col = col;
    }
}
