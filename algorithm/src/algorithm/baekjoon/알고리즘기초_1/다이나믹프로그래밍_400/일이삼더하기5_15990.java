package algorithm.baekjoon.알고리즘기초_1.다이나믹프로그래밍_400;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 일이삼더하기5_15990 {

    public static Node[] nodes;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(br.readLine());

            int max = -1;
            int[] numbers = new int[size];

            for (int i = 0; i < size; i++) {
                int num = Integer.parseInt(br.readLine());
                numbers[i] = num;
                max = Math.max(max, num);
            }
            nodes = new Node[max + 1];
            for (int i = 0; i < max + 1; i++) {
                nodes[i] = new Node();
            }
            if (max > 1) {
                nodes[1].setCount(1, 0, 0);
            }
            if (max > 2) {
                nodes[2].setCount(0, 1, 0);
            }
            if (max > 3) {
                nodes[3].setCount(1, 1, 1);
            }

            for (int i = 4; i < max + 1; i++) {
                nodes[i].setCount(getCount(nodes[i - 1], 1), getCount(nodes[i - 2], 2), getCount(nodes[i - 3], 3));
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numbers.length; i++) {
                sb.append(nodes[numbers[i]].count).append("\n");
            }
            System.out.println(sb);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long getCount(Node node, int condition) {
        long result = 0L;

        for (int i = 0; i < 3; i++) {
            if (i == (condition - 1)) {
                continue;
            }
            result += node.lastNum[i];
        }
        return result % 1000000009L;
    }

    static class Node {

        long count;
        long[] lastNum = new long[3];


        public void setCount(long n1, long n2, long n3) {
            lastNum[0] = n1;
            lastNum[1] = n2;
            lastNum[2] = n3;

            count = (n1 + n2 + n3) % 1000000009L;
        }

    }


}
