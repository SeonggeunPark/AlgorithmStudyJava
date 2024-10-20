import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력받을 N, M
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        
        // 2차원 배열과 누적합 배열 초기화
        int[][] arr = new int[N + 1][N + 1];
        int[][] sum = new int[N + 1][N + 1];

        // 2차원 배열 입력 받기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = scanner.nextInt();
                // 누적합 계산
                sum[i][j] = arr[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        // 쿼리 처리
        for (int k = 0; k < M; k++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            
            // 구간합 계산
            int result = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
            System.out.println(result);
        }
        
        scanner.close();
    }
}
