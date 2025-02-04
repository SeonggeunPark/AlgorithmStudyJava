import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정수 입력 받기
        int A = sc.nextInt();
        int B = sc.nextInt();

        // 결과 출력
        System.out.println(A + B);

        sc.close();
    }
}
