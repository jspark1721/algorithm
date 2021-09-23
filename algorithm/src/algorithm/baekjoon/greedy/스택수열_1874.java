package algorithm.baekjoon.greedy;

import java.util.Scanner;
import java.util.Stack;

public class 스택수열_1874 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int condition = sc.nextInt();
        int num = 1;
        for (int i = 1; i <= condition; i++) {
            int target = sc.nextInt();
            while (num <= target) {
                stack.push(num++);
                sb.append("+\n");
            }
            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                sb = new StringBuilder("NO");
                break;
            }
        }
        System.out.println(sb.toString());
    }

}
