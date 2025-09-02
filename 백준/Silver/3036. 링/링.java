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

        int n = sc.nextInt();
        int[] rings = new int[n];

        for (int i = 0; i < n; i++) {
            rings[i] = sc.nextInt();
        }

        int first = rings[0];
        for (int i = 1; i < n; i++) {
            int g = gcd(first, rings[i]);
            System.out.println((first / g) + "/" + (rings[i] / g));
        }
    }
}
