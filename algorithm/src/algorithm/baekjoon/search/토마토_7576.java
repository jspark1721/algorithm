package algorithm.baekjoon.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토_7576 {

    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] condition = br.readLine().split(" ");
            int row = Integer.parseInt(condition[1]);
            int col = Integer.parseInt(condition[0]);

            int[][] tomato = new int[row][col];
            int total = row * col;
            int ripe = 0;
            Queue<Tomato> q = new LinkedList<>();
            for (int i = 0; i < tomato.length; i++) {
                String[] info = br.readLine().split(" ");
                for (int j = 0; j < tomato[i].length; j++) {
                    int status = Integer.parseInt(info[j]);

                    tomato[i][j] = status;
                    if (status == -1) {
                        total--;
                    } else if (status == 1) {
                        ripe++;
                        q.add(new Tomato(i, j, 0));
                    }
                }
            }

            if (total == ripe) {
                System.out.println(0);
                return;
            }
            int result = 0;
            while (!q.isEmpty()) {
                Tomato node = q.poll();
                for (int i = 0; i < 4; i++) {
                    int x = node.x + dx[i];
                    int y = node.y + dy[i];
                    if (x >= 0 && x < row && y >= 0 && y < col) {
                        if (tomato[x][y] == 0) {
                            ripe++;
                            q.add(new Tomato(x, y, node.depth + 1));
                            result = Math.max(node.depth + 1, result);
                            tomato[x][y] = 1;
                        }
                    }
                }
            }
            if (total != ripe) {
                result = -1;
            }

            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class Tomato {

    int x;
    int y;
    int depth;

    public Tomato(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }

}