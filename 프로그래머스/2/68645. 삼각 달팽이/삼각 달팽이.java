import java.util.*;

class Solution {
    int[] dr = {1, 0, -1};
    int[] dc = {0, 1, -1};
    public int[] solution(int n) {
        int[][] arr = new int[n+1][n+1];
        int num = 1;
        int target = n*(n+1)/2;
        int dir = 0;
        int r=1; int c=1;

        while (num <= target) {
            arr[r][c] = num++;
            int nr = r+dr[dir];
            int nc = c+dc[dir];
            if (nr<1 || nc<1 || nr>n || nc>n || arr[nr][nc]>0) 
                dir = (dir+1)%3; 
            
            r = r+dr[dir];
            c = c+dc[dir];
        }
        int[] answer = new int[target];
        num = 0;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                answer[num++]=arr[i][j];
            }
        }
        return answer;
    }
}
