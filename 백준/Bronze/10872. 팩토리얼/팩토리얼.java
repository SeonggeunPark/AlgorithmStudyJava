import java.util.Scanner;

public class Main {
    public static int factorial(int n) {
        if (n == 0) return 1; // 종료 조건 (0! = 1)
        return n * factorial(n - 1); // 재귀 호출
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        System.out.println(factorial(N)); // 재귀 함수 호출
    }
}
