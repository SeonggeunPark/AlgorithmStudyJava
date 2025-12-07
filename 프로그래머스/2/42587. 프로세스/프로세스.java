import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> q = new ArrayDeque<>();
        for (int i=0; i<priorities.length; i++) {
            priority.offer(priorities[i]);
            q.offer(i);
        }
        int cnt = 1;
        while (!q.isEmpty()) {
            int poll = q.poll();
            if (priorities[poll] >= priority.peek()) {
                if (poll==location) break;
                priority.poll();
                cnt += 1;
            } else {
                q.offer(poll);
            }
        }
        
        return cnt;
    }
}