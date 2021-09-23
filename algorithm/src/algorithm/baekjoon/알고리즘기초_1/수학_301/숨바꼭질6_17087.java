package algorithm.baekjoon.알고리즘기초_1.수학_301;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 숨바꼭질6_17087 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] con = br.readLine().split(" ");
            int S = Integer.parseInt(con[1]);
            int N = Integer.parseInt(con[0]);

            String[] numbers = br.readLine().split(" ");
            int[] distance = new int[N];
            for (int i = 0; i < numbers.length; i++) {
                distance[i] = Math.abs(Integer.parseInt(numbers[i]) - S);
            }

            Arrays.sort(distance);

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(distance[0]);

            for (int i = 1; i < distance.length; i++) {
                int min = distance[0];
                int max = distance[i];

                int temp = -1;
                while (temp != 0) {
                    temp = max % min;
                    max = min;
                    min = temp;
                }
                pq.add(max);
            }

            System.out.println(pq.poll());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
