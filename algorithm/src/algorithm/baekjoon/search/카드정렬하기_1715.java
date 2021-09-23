package algorithm.baekjoon.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬하기_1715 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> q = new PriorityQueue<>();
            int result = 0;
            for (int i = 0; i < size; i++) {
                int input = Integer.parseInt(br.readLine());
                q.add(input);
            }
            while (q.size() != 1) {
                int cardList1 = q.poll();
                int cardList2 = q.poll();
                result += cardList1 + cardList2;
                q.add(cardList1 + cardList2);
            }
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
