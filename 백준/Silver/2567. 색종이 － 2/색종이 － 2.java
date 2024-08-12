import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int nr, nc;
        int cnt = 0;
        boolean[][] papers = new boolean[100][100];
        
        // 색종이 붙이기 : 좌표부터 행 열 각각 +10만큼 true로 변환
        for (int t=0; t<N; t++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            for (int i = r; i < r+10; i++) {
                for (int j = c; j < c+10; j++) {
                    papers[i][j] = true;
                }
            }
        }
        
        // 모든 좌표를 탐색하며 테두리 계산
        for (int r = 0; r < 100; r++) {
            for (int c = 0; c < 100; c++) {
                // 색종이가 붙어 있는 좌표일 때만
                if (papers[r][c]) {
                    // 상하좌우 탐색하여 빈공간(흰색 도화지)을 찾음
                    for (int idx = 0; idx < 4; idx++) {
                        nr = r + dr[idx];
                        nc = c + dc[idx];
                        
                        // 배열 범위 이내이면 탐색 후 빈공간일 때 카운트 +1
                        if (0 <= nr && nr < 100 && 0 <= nc && nc < 100) {
                            if (!papers[nr][nc]) {
                                cnt++;
                            }
                        // 범위 밖이면 무조건 빈공간이므로 카운트 +1
                        } else cnt++;
                    }
                }
            }
        }
        
        System.out.println(cnt);
    }
}
