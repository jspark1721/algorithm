package algorithm.baekjoon.recursive;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 영만들기_7490 {

    public static StringBuilder retval = new StringBuilder();
    public static String[] command;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Map<String, String> test = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            n = sc.nextInt();
            command = new String[n + 1];
            checkFunc(1);
            retval.append("\n");
        }
        System.out.println(retval.toString());
    }

    public static void checkFunc(int num) {
        if (num == n) {
            StringBuilder sb = new StringBuilder();
            int value = 1;
            int temp = 1;
            String mem = "";
            sb.append(1);
            for (int i = 2; i < command.length; i++) {
                if (command[i] == " ") {
                    temp = temp * 10 + i;
                } else {
                    temp = temp != 1 ? temp : i;
                    if (mem != "") {
                        value = calc(value, temp, mem);
                        temp = i;
                    }
                    mem = command[i];
                }
                sb.append(command[i] + i);
            }
            value = calc(value, temp, mem);
            if (value == 0) {
                retval.append(sb.toString()).append("\n");
            }
            return;
        }
        int nextNum = num + 1;
        command[nextNum] = " ";
        checkFunc(nextNum);
        command[nextNum] = "+";
        checkFunc(nextNum);
        command[nextNum] = "-";
        checkFunc(nextNum);
    }

    public static int calc(int value, int target, String com) {
        switch (com) {
            case "+":
                value = value + target;
                break;
            case "-":
                value = value - target;
                break;
            case "":
                value = target;
                break;
            default:
                break;
        }
        return value;

    }

}
