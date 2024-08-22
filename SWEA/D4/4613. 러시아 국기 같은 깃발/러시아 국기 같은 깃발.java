import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            // 국기 색깔 입력
            char[][] flag = new char[N][M];
            for (int i=0; i<N; i++) {
            	flag[i] = br.readLine().toCharArray();
            }
            
            // 행별 색깔 카운트 ([0:W, 1:B, 2:R][행 번호])
            int[][] cnt = new int[3][N];
            
            for (int r=0; r<N; r++) {
                for (int c=0; c<M; c++) {
                    if (flag[r][c]=='W') {
                        cnt[0][r]++;
                    } else if (flag[r][c]=='B') {
                        cnt[1][r]++;
                    } else {
                        cnt[2][r]++;
                    }
                }
            }
            
            // 맨 첫줄은 무조건 W, 맨 끝줄은 무조건 R이므로 미리 더하기
            int fixedCnt = M-cnt[0][0] + M-cnt[2][N-1];
            // 최저값 구하기 위한 변수
            int minCnt = 2100000000;
            
            // 완전탐색. B시작할 라인(Bs)과 B끝나는 라인(Be) 나누어 모든 경우의 수를 구함
            for (int Bs=1; Bs<N-1; Bs++) {
                for (int Be=Bs; Be<N-1; Be++) {
                    int needChange = 0;
                    // W Count (1행부터 B시작행 전 행까지)
                    for (int i=1; i<Bs; i++) {
                        needChange += M - cnt[0][i];
                    }
                    // B Count
                    for (int i=Bs; i<=Be; i++) {
                        needChange += M - cnt[1][i];
                    }
                    // R Count (B끝나는행 다음 행부터 N-2행까지)
                    for (int i=Be+1; i<N-1; i++) {
                        needChange += M - cnt[2][i];
                    }
                    minCnt = Math.min(needChange, minCnt);
                }
            }
            
            int ans = minCnt + fixedCnt;
            
            System.out.println("#"+t+" "+ans);
            
        }
    }

}