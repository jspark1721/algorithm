package algorithm.baekjoon.알고리즘기초_1.자료구조_201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 오큰수_17298 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(br.readLine());

            String[] array = br.readLine().split(" ");
            int[] check = new int[array.length];

            Stack<Integer> stack = new Stack<>();
            stack.push(0);

            for (int i = 1; i < array.length; i++) {
                while (!stack.isEmpty() && Integer.parseInt(array[stack.peek()]) < Integer.parseInt(array[i])) {
                    check[stack.pop()] = Integer.parseInt(array[i]);
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                check[stack.pop()] = -1;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < check.length; i++) {
                sb.append(check[i] + " ");
            }

            System.out.println(sb);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
