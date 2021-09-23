package algorithm.baekjoon.알고리즘기초_1.자료구조_201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 오등큰수_17299 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(br.readLine());
            int[] counts = new int[size + 1];
            int[] result = new int[size];

            String[] array = br.readLine().split(" ");

            for (String number : array) {
                counts[Integer.parseInt(number)]++;
            }

            Stack<Integer> stack = new Stack<>();
            stack.push(0);

            for (int i = 1; i < array.length; i++) {
                while (!stack.isEmpty() && counts[Integer.parseInt(array[stack.peek()])] < counts[Integer.parseInt(array[i])]) {
                    result[stack.pop()] = Integer.parseInt(array[i]);
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                result[stack.pop()] = -1;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                sb.append(result[i] + " ");
            }
            System.out.println(sb);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
