package algorithm.baekjoon.알고리즘기초_1.자료구조_203;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 후위표기식_1918 {

    public static void getPostFix(Stack<String> word, Stack<String> operation) {
        String num2 = word.pop();
        String num1 = word.pop();
        String op = operation.pop();
        word.push(num1 + num2 + op);
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            Stack<String> operation = new Stack<>();
            Map<String, Integer> check = new HashMap<>();
            check.put("+", 1);
            check.put("-", 1);
            check.put("*", 2);
            check.put("/", 2);
            check.put("(", 0);

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    sb.append(c);
                } else {
                    if (c == '(') {
                        operation.push(String.valueOf(c));
                    } else if (c == ')') {
                        while (!operation.isEmpty() && !operation.peek().equals("(")) {
                            sb.append(operation.pop());
                        }
                        operation.pop();
                    } else {
                        while (!operation.isEmpty() && check.get(operation.peek() + "") >= check.get(c + "")) {
                            sb.append(operation.pop());
                        }
                        operation.push(String.valueOf(c));
                    }
                }
            }
            while (!operation.isEmpty()) {
                sb.append(operation.pop());
            }
            System.out.println(sb);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
