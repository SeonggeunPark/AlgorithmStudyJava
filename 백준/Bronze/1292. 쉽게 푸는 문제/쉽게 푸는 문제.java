import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int[] arr = new int[1001];
        int idx = 1;

        for (int i = 1; idx <= 1000; i++) {
            for (int j = 0; j < i && idx <= 1000; j++) {
                arr[idx++] = i;
            }
        }

        int sum = 0;
        for (int i = A; i <= B; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}
