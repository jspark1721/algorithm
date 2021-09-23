package algorithm.baekjoon;

import java.util.Scanner;

public class 음계_2920 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int d = 8;

        boolean isAsc = true;
        boolean isDec = true;

        for (int i = 1; i <= 8; i++) {
            int num = sc.nextInt();
            if (isAsc && num != i) {
                isAsc = false;
            }
            if (isDec && num != (8 - i) + 1) {
                isDec = false;
            }
            if (!isAsc && !isDec) {
                break;
            }
        }
        String str = "mixed";
        if (isAsc) {
            str = "ascending";
        } else if (isDec) {
            str = "descending";
        }
        System.out.println(str);
    }

}
