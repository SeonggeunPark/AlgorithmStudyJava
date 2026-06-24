import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int[] pcCnt = new int[10];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            pcCnt[priorities[i]]++;
            q.offer(i);
        }
        
        int cnt = 1;
        
        out:
        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int i=9; i>priorities[cur]; i--) {
                if (pcCnt[i]>0) {
                    q.offer(cur);
                    continue out;
                } 
            }
            if (cur==location) return cnt;
            cnt++;
            pcCnt[priorities[cur]]-=1;
        }
        
        return priorities.length;
    }
}