import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        String answer = null;

        // i, j는 split 지점
        for (int i = 1; i < word.length() - 1; i++) {
            for (int j = i + 1; j < word.length(); j++) {
                String part1 = new StringBuilder(word.substring(0, i)).reverse().toString();
                String part2 = new StringBuilder(word.substring(i, j)).reverse().toString();
                String part3 = new StringBuilder(word.substring(j)).reverse().toString();

                String combined = part1 + part2 + part3;

                if (answer == null || combined.compareTo(answer) < 0) {
                    answer = combined;
                }
            }
        }

        System.out.println(answer);
    }
}
