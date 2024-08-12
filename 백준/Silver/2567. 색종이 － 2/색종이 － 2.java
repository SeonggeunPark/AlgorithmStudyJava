import java.util.Scanner;
/*
 * 처음엔 연산을 줄이기 위해 종이가 붙었던 좌표를 저장하여
 * 해당 구간을 탐색하면 효율적인 코드가 될 것이라 생각했으나,
 * 그렇게 처리하면 테두리가 겹칠 때 중복으로 처리가 되는 것을 뒤늦게 발견.
 * => 100*100 배열을 모두 1번씩 돌며 true일 때만 탐색하는 방식이
 * 	  정확한 답을 출력할 수 있음
 */
public class Main {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int nr, nc;
        int cnt = 0;
        boolean[][] papers = new boolean[100][100];
        int[][] pos = new int[N][2];
        
        // 색종이 붙이기 : 좌표부터 행 열 각각 +10만큼 true로 변환 &&
        // 색종이 붙은 부분만 탐색하기 위해 pos 배열에 담아둠 => 잘못된 방법
        for (int t=0; t<N; t++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
//            pos[t][0] = r;
//            pos[t][1] = c;
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
//        for (int t=0; t<N; t++) {
//            int y = pos[t][0];
//            int x = pos[t][1];
//            
//            for (int r = y; r < y+10; r++) {
//                for (int c = x; c < x+10; c++) {
//                	
//                	// 상하좌우 탐색하여 빈공간 카운트
//                    for (int idx=0; idx<4; idx++) {
//                    	nr = r+dr[idx];
//                    	nc = c+dc[idx];
//                    	
//                    	// 배열 범위 이내이면 탐색 후 빈공간일 때 카운트 +1
//                    	if (0<=nr && nr<100 && 0<=nc && nc<100) {
//                    		if (papers[nr][nc] == false) {
//                        		cnt++;
//                        	}
//                    		// 범위 밖이면 무조건 빈공간이므로 카운트 +1
//                    	} else cnt++;     	
//                    }
//                	// 첫행과 마지막 행 제외하고, 행의 양 끝 열만 탐색 (사각형 테두리만 탐색)
//                	if (r!=y && r!= y+9 && c==x) c+=8;
//                }
//            }
//        }
//        
//        System.out.println(cnt);
    }
}