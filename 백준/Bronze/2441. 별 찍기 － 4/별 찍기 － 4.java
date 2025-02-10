import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 입력 값 N

        for (int i = 0; i < N; i++) {
            // 공백 출력 (i 개수만큼)
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // 별 출력 (N - i 개수만큼)
            for (int j = 0; j < (N - i); j++) {
                System.out.print("*");
            }
            System.out.println(); // 줄바꿈
        }
        scanner.close();
    }
}
