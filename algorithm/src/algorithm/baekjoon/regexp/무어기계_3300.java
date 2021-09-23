package algorithm.baekjoon.regexp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class 무어기계_3300 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                String regex = br.readLine();
                String target = br.readLine();
                if (Pattern.matches(regex, target)) {
                    sb.append("_\n");
                } else if (Pattern.matches(regex.replace("_", "."), target)) {
                    for (int j = 'A'; j <= 'Z'; j++) {
                        if (Pattern.matches(regex.replace("_", (char) j + ""), target)) {
                            sb.append((char) j + "\n");
                            break;
                        }
                    }
                } else {
                    sb.append("!\n");
                }
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
