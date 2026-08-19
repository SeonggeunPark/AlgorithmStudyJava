import java.util.*;

class Solution {
    // 인덱스 기준 인접리스트 생성 (n:시작점, n+1:끝점)
    int[][] adjArr;
    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        adjArr = new int[n+2][n+2];
        
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (check(words[i], words[j])) {
                    adjArr[i][j] = 1;
                    adjArr[j][i] = 1;
                }
            }
            if (check(begin, words[i])) {
                adjArr[n][i] = 1;
                adjArr[i][n] = 1;
            }
            if (check(target, words[i])) {
                adjArr[n+1][i] = 1;
                adjArr[i][n+1] = 1;
            }
        }
        
        
        return bfs(begin, target, words, n, adjArr);
    }
    public int bfs(String begin, String target, String[] words, int n, int[][] adjArr) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        int cnt = 0;
        int size = 1;
        q.offer(n);
        
        while (!q.isEmpty()) {
            for (int i=0; i<size; i++) {
                int idx = q.poll();
                if (idx == n+1) return cnt;
                String cur = idx==n ? begin : words[idx];
                if (cur.equals(target)) return cnt;
                
                for (int j=0; j<n; j++) {
                    if (adjArr[idx][j]!=1) continue;
                    if (j==n+1) return cnt+1;
                    if (visited[j]) continue;
                    visited[j] = true;
                    q.offer(j);
                }
            }
            size = q.size();
            cnt++;
        }
        
        return 0;
    }
    public boolean check(String s1, String s2) {
        boolean flag = false;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (flag) return false;
                else flag = true;
            }
        }
        
        return true;
    }
}