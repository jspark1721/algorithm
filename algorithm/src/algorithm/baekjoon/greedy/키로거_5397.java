package algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 키로거_5397 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            int size = Integer.parseInt(br.readLine());
            for (int i = 0; i < size; i++) {
                String command = br.readLine();
                int idx = 0;
                Stack<Character> password = new Stack<Character>();
                Stack<Character> candidate = new Stack<Character>();
                for (char c : command.toCharArray()) {
                    if (c == '<') {
                        if (!password.isEmpty()) {
                            candidate.add(password.pop());
                        }
                    } else if (c == '>') {
                        if (!candidate.isEmpty()) {
                            password.add(candidate.pop());
                        }
                    } else if (c == '-') {
                        if (!password.isEmpty()) {
                            password.pop();
                        }
                    } else {
                        password.add(c);
                    }
                }
                while (!candidate.isEmpty()) {
                    password.add(candidate.pop());
                }
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < password.size(); j++) {
                    sb.append(password.elementAt(j));
                }
                System.out.println(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
