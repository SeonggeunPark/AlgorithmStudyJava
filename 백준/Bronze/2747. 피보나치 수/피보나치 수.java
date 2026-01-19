import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N == 0) {
            System.out.println(0);
            return;
        }
        if (N == 1) {
            System.out.println(1);
            return;
        }

        int a = 0;
        int b = 1;
        int result = 0;

        for (int i = 2; i <= N; i++) {
            result = a + b;
            a = b;
            b = result;
        }

        System.out.println(result);
    }
}
