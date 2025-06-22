import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= B.length() - A.length(); i++) {
            int diff = 0;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(i + j)) {
                    diff++;
                }
            }
            min = Math.min(min, diff);
        }

        System.out.println(min);
    }
}
