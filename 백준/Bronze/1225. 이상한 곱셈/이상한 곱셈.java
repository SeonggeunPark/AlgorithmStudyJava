import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();
        long sum = 0;

        for (int i = 0; i < A.length(); i++) {
            int digitA = A.charAt(i) - '0';
            for (int j = 0; j < B.length(); j++) {
                int digitB = B.charAt(j) - '0';
                sum += (long) digitA * digitB;
            }
        }

        System.out.println(sum);
    }
}
