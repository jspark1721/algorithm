package algorithm.baekjoon.알고리즘기초_1.자료구조_203;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 문자열분석_10820 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = "";
            StringBuilder sb = new StringBuilder();
            while (!(str = br.readLine()).isEmpty()) {
                int upper = 0;
                int lower = 0;
                int num = 0;
                int space = 0;
                for (char c : str.toCharArray()) {
                    if (c >= 'a' && c <= 'z') {
                        lower++;
                    } else if (c >= 'A' && c <= 'Z') {
                        upper++;
                    } else if (c >= '0' && c <= '9') {
                        num++;
                    } else {
                        space++;
                    }
                }
                sb.append(lower + " " + upper + " " + num + " " + space + "\n");
            }
            System.out.println(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
