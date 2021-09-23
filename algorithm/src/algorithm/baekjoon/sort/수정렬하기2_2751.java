package algorithm.baekjoon.sort;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 수정렬하기2_2751 {

    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            q.add(sc.nextInt());
        }
        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            sb.append(q.poll()).append("\n");
        }
        System.out.println(sb.toString());
    }

}
