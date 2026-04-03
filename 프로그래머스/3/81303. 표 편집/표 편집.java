import java.util.*;
class Solution {
    int cur;
    int[] next;
    int[] prev;
    boolean[] deleted;
    Stack<int[]> st;
    public String solution(int n, int k, String[] cmd) {
        cur = k;
        next = new int[n];
        prev = new int[n];
        deleted = new boolean[n];
        st = new Stack<>();
        // 1. 초기 표 생성
        prev[0] = -1;
        next[n-1] = -1;
        for (int i=0; i<n; i++) {
            if (i<n-1) {
                next[i] = i+1;
            }
            if (i>0) {
                prev[i] = i-1;
            }
        }
        
        // 2. 명령어 처리
        for (String com : cmd) {
            treat(com, n);
        }
        
        // 3. 결과 생성
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (deleted[i]) res.append('X');
            else res.append('O');
        }
        
        return res.toString();
    }
    public void treat(String com, int n) {
        String[] coms = com.split(" ");
        if (coms[0].equals("D")) {
            int num = Integer.parseInt(coms[1]);
            for (int i=0; i<num; i++) {
                cur = next[cur];
            }
        } else if (coms[0].equals("U")) {
            int num = Integer.parseInt(coms[1]);
            for (int i=0; i<num; i++) {
                cur = prev[cur];
            }
        } else if (coms[0].equals("C")) {
            deleted[cur] = true;
            st.push(new int[]{cur, prev[cur], next[cur]});
            // 연결끊기
            if (next[cur] != -1) prev[next[cur]] = prev[cur];
            if (prev[cur] != -1) next[prev[cur]] = next[cur];
            
            if (next[cur] == -1) cur = prev[cur];
            else cur = next[cur];
        } else {
            int[] poped = st.pop();
            deleted[poped[0]] = false;
            
            if (poped[2]!=-1) prev[poped[2]] = poped[0];
            if (poped[1]!=-1) next[poped[1]] = poped[0];
        }
    }
}