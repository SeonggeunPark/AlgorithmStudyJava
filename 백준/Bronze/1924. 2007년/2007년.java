import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 월별 일 수 배열 (1월부터 12월까지)
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        // 요일 배열
        String[] daysOfWeek = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };

        Scanner scanner = new Scanner(System.in);

        // 입력받기
        int month = scanner.nextInt();
        int day = scanner.nextInt();

        // 1월 1일부터 x월 y일까지의 총 일수 계산
        int totalDays = 0;

        // 이전 달까지의 일수 더하기
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonth[i];
        }

        // 현재 달의 일수 더하기
        totalDays += day;

        // 요일 계산 (1월 1일이 월요일이므로 0부터 시작)
        String resultDay = daysOfWeek[(totalDays - 1) % 7];

        // 결과 출력
        System.out.println(resultDay);

        scanner.close();
    }
}
