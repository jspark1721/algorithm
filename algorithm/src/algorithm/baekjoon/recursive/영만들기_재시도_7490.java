package algorithm.baekjoon.recursive;

import java.util.Scanner;

public class 영만들기_재시도_7490 {

    public static StringBuilder retval = new StringBuilder();
    public static String[] command;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            n = sc.nextInt();
            command = new String[n + 1];
            checkFunc(2);
            retval.append("\n");
        }
        System.out.println(retval.toString());
    }

    public static void checkFunc(int num) {
        if (num > n) {
            int total = 0;
            StringBuilder sb = new StringBuilder();
            sb.append(1);
            int sign = 1;
            int prevNum = 1;

            for (int i = 2; i <= n; i++) {
                if (command[i].equals(" ")) {
                    prevNum = (prevNum * 10) + i;
                } else {
                    total = total + (sign * prevNum);
                    prevNum = i;
                    if (command[i].equals("+")) {
                        sign = 1;
                    } else if (command[i].equals("-")) {
                        sign = -1;
                    }
                }
                sb.append(command[i]);
                sb.append(i);
            }
            total = total + (sign * prevNum);

            if (total == 0) {
                retval.append(sb).append("\n");
            }
            return;
        }

        command[num] = " ";
        checkFunc(num + 1);
        command[num] = "+";
        checkFunc(num + 1);
        command[num] = "-";
        checkFunc(num + 1);

    }

}
