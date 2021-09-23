package algorithm.baekjoon.자료구조_200;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택수열_1874 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(br.readLine());
            int num = 1;
            Stack<Integer> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            stack.peek();
            while (size-- > 0) {
                int target = Integer.parseInt(br.readLine());
                while (num <= target) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                if (stack.isEmpty() || stack.peek() < target) {
                    sb = new StringBuilder("NO");
                    break;
                } else {
                    while (stack.peek() != target) {
                        stack.pop();
                        sb.append("-\n");
                    }
                    stack.pop();
                    sb.append("-\n");
                }
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
