package algorithm.baekjoon;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;

public class 유기농배추_1012 {


    static int[] xArr = {0, 1, 0, -1};

    static int[] yArr = {1, 0, -1, 0};

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in))) {
            int repeatCount = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for (int count = 0; count < repeatCount; count++) {
                String[] condition = br.readLine().split(" ");
                int col = Integer.parseInt(condition[0]);
                int row = Integer.parseInt(condition[1]);
                int[][] field = new int[row][col];
                boolean[][] visted = new boolean[row][col];

                for (int j = 0; j < Integer.parseInt(condition[2]); j++) {
                    String[] target = br.readLine().split(" ");
                    field[Integer.parseInt(target[1])][Integer.parseInt(target[0])] = 1;
                }

                int answer = 0;
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if (visted[i][j] || (field[i][j] != 1)) {
                            continue;
                        }
                        answer++;
                        Queue<BaeChu> q = new LinkedList<>();
                        q.add(new BaeChu(i, j));
                        visted[i][j] = true;
                        int aptCount = 1;
                        while (!q.isEmpty()) {
                            BaeChu baeChu = q.poll();

                            for (int chk = 0; chk < 4; chk++) {
                                int moveRow = baeChu.row + yArr[chk];
                                int moveCol = baeChu.col + xArr[chk];

                                if (moveRow > -1 && moveRow < row && moveCol > -1 && moveCol < col) {
                                    if ((field[moveRow][moveCol] == 1) && !visted[moveRow][moveCol]) {
                                        visted[moveRow][moveCol] = true;
                                        q.add(new BaeChu(moveRow, moveCol));
                                    }
                                }
                            }
                        }
                    }
                }
                sb.append(answer + "\n");
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class BaeChu {
        int row;

        int col;


        public BaeChu(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
