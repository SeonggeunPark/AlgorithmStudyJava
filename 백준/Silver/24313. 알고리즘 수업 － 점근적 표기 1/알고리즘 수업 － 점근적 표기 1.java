import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a1 = sc.nextInt();
        int a0 = sc.nextInt();
        int c = sc.nextInt();
        int n0 = sc.nextInt();

        boolean conditionHolds = true;

        for (int n = n0; n <= n0 + 100; n++) {
            int fn = a1 * n + a0;
            int cn = c * n;
            if (fn > cn) {
                conditionHolds = false;
                break;
            }
        }

        System.out.println(conditionHolds ? 1 : 0);
    }
}
