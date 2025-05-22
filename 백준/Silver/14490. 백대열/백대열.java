import java.util.Scanner;

public class Main {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.next().split(":");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int g = gcd(a, b);
        System.out.println((a / g) + ":" + (b / g));
    }
}
