import java.util.*;
/*
우선순위 큐,
맨 앞 값이 K보다 높을 때까지 연산.
*/

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int s : scoville) {
            pq.offer(s);
        }
        
        while (pq.size()>1) {
            int s1 = pq.poll();
            if (s1>=K) break;
            int s2 = pq.poll();
            
            pq.offer(s1+s2*2);
            
            answer+=1;
        }
        return answer = pq.peek()>=K ? answer : -1;
    }
}