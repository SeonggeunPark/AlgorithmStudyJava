import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점 개수
        int M = sc.nextInt(); // 간선 개수

        int[][] adjArr = new int[N + 1][N + 1]; // 인접행렬 선언
        for (int i = 1; i <= N; i++) {
            Arrays.fill(adjArr[i], 2100000000); // 최대값으로 초기화
        }

        // 인접행렬 입력
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt(); // 출발 도시
            int to = sc.nextInt();   // 도착 도시
            int cost = sc.nextInt(); // 버스 비용
            adjArr[from][to] = Math.min(adjArr[from][to], cost); // 최소 비용 저장
        }

        // 거리 배열 초기화
        int[][] dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    dist[i][j] = 0; // 자기 자신으로 가는 비용은 0
                } else {
                    dist[i][j] = adjArr[i][j]; // 거리 배열 초기화
                }
            }
        }

        // 플로이드 워셜 알고리즘
        // 각 정점 k를 중간 정점으로 사용해 경로를 최적화
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    // i에서 j로 가는 경로가 k를 거쳤을 때 더 빠르면 갱신
                    if (dist[i][k] < 2100000000 && dist[k][j] < 2100000000) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] == 2100000000) {
                    System.out.print("0 "); // 연결이 안 되어 있으면 0 출력
                } else {
                    System.out.print(dist[i][j] + " "); // 최단 거리 출력
                }
            }
            System.out.println(); // 다음 줄로
        }

        sc.close();
    }
}
