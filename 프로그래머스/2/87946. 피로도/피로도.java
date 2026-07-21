import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        return dfs(k, 0, 0, dungeons);
    }
    public int dfs(int k, int cnt, int visit, int[][] dungeons) {
        if (cnt >= dungeons.length) return cnt;
        if (k <= 0) return cnt;
        
        int res = 0;
        for (int i=0; i<dungeons.length; i++) {
            if (((1<<i) & visit) == (1<<i)) continue;
            if (k<dungeons[i][0]) continue;
            
            res = Math.max(res, dfs(k-dungeons[i][1], cnt+1, (visit|(1<<i)), dungeons));
        }
        return Math.max(res, cnt);
    }
}