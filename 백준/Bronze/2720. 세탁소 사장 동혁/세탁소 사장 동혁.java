import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int change = sc.nextInt();

            int q = change / 25;
            change %= 25;

            int d = change / 10;
            change %= 10;

            int n = change / 5;
            change %= 5;

            int p = change;

            System.out.println(q + " " + d + " " + n + " " + p);
        }

        sc.close();
    }
}
