package algorithm.baekjoon.알고리즘기초_1.자료구조_203;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후위표기식2_1935 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int[] info = new int[size];

            for (int i = 0; i < size; i++) {
                info[i] = Integer.parseInt(br.readLine());
            }
            Stack<Double> stack = new Stack<>();
            for (char word : str.toCharArray()) {
                if (word >= 'A' && word <= 'Z') {
                    stack.push((double) info[word - 65]);
                } else {
                    double num2 = stack.pop();
                    double num1 = stack.pop();
                    double result = 0;
                    if (word == '*') {
                        result = num1 * num2;
                    } else if (word == '/') {
                        result = num1 / num2;
                    } else if (word == '-') {
                        result = num1 - num2;
                    } else if (word == '+') {
                        result = num1 + num2;
                    }
                    stack.push(result);
                }
            }
            System.out.println(String.format("%.2f", stack.pop()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
