import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int N = sc.nextInt();  // 수열의 길이
        int M = sc.nextInt();  // 목표 합

        int[] arr = new int[N];  // 수열 저장 배열
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;      // 합이 M인 부분 수열의 개수
        int sum = 0;        // 현재 부분합
        int start = 0;      // 시작 포인터

        // end 포인터를 오른쪽으로 이동하면서 탐색
        for (int end = 0; end < N; end++) {
            sum += arr[end];  // 현재 값을 부분합에 추가

            // 부분합이 M보다 크면 start 포인터를 이동하며 sum을 줄임
            while (sum > M) {
                sum -= arr[start++];
            }

            // 부분합이 정확히 M이면 카운트 증가
            if (sum == M) {
                count++;
            }
        }

        System.out.println(count);
    }
}
