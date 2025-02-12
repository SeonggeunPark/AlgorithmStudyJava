import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[] submitted = new boolean[31]; // 1~30번 학생 (0번은 사용X)

        // 28명의 제출 학생 번호 입력
        for (int i = 0; i < 28; i++) {
            int student = scanner.nextInt();
            submitted[student] = true; // 제출한 학생 체크
        }
        scanner.close();

        // 과제 안 낸 학생 출력
        for (int i = 1; i <= 30; i++) {
            if (!submitted[i]) {
                System.out.println(i);
            }
        }
    }
}
