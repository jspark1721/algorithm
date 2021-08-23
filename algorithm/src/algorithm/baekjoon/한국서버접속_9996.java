package algorithm.baekjoon;

import java.io.BufferedReader;
import java.util.regex.Pattern;

public class 한국서버접속_9996 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in))) {
            int fileCount = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String pattern = "^" + str.replace("*", "\\w*") + "$";

            Pattern pt = Pattern.compile(pattern.toString());
            for (int i = 0; i < fileCount; i++) {
                if (pt.matches(pattern.toString(), br.readLine())) {
                    System.out.println("DA");
                } else {
                    System.out.println("NE");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
