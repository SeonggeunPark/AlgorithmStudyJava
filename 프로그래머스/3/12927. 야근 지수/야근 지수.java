import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.offer(work);
        }
        
        while (!pq.isEmpty() && n>0) {
            int work = pq.poll();
            work -= 1;
            if (work>0) pq.offer(work);
            n-=1;
        }
        
        long answer = 0;
        while (!pq.isEmpty()) {
            answer+=Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}