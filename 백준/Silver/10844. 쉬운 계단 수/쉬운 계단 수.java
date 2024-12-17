import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력: N 값
        int N = sc.nextInt();
        
        // DP 배열 선언: dp[i][j]는 i자리 수에서 끝자리가 j인 계단 수의 개수
        long[][] dp = new long[N + 1][10];
        
        // 초기 상태 설정 (길이가 1인 계단 수는 1부터 9까지 각각 1개씩)
        for (int j = 1; j <= 9; j++) {
            dp[1][j] = 1;
        }
        
        // DP 배열 채우기
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j > 0) dp[i][j] += dp[i - 1][j - 1];  // 이전 자리가 j-1
                if (j < 9) dp[i][j] += dp[i - 1][j + 1];  // 이전 자리가 j+1
                dp[i][j] %= 1000000000;  // 1,000,000,000으로 나눈 나머지
            }
        }
        
        // 결과 계산 (N자리 수의 계단 수의 합)
        long result = 0;
        for (int j = 0; j <= 9; j++) {
            result += dp[N][j];
        }
        
        // 결과 출력
        System.out.println(result % 1000000000);
    }
}
