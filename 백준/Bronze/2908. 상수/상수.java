import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 두 개의 숫자 입력받기
        int A = sc.nextInt();
        int B = sc.nextInt();

        // 숫자를 뒤집는 함수 호출
        int reversedA = reverseNumber(A);
        int reversedB = reverseNumber(B);

        // 더 큰 숫자 출력
        System.out.println(Math.max(reversedA, reversedB));

        sc.close();
    }

    // 숫자를 뒤집는 함수
    public static int reverseNumber(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }
}
