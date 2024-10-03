import java.util.Scanner;

public class Main {
    static int N;
    static int[][] adjMatrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        adjMatrix = new int[N][N];

        // 인접 행렬 입력
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                adjMatrix[r][c] = sc.nextInt();
            }
        }

        // 플로이드-워셜 알고리즘 적용
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (adjMatrix[i][k] == 1 && adjMatrix[k][j] == 1) {
                        adjMatrix[i][j] = 1;
                    }
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sb.append(adjMatrix[r][c]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
