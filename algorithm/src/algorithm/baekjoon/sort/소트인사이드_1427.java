package algorithm.baekjoon.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class 소트인사이드_1427 {

    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            String str = br.readLine();
            Integer[] value = Stream.of(str.split("")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
            Arrays.sort(value, Collections.reverseOrder());
            Arrays.stream(value).forEach(item -> {
                System.out.print(item);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
