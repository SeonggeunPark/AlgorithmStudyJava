import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville)  pq.offer(s);
        while (pq.size() > 1 && pq.peek()<K)    pq.offer(pq.poll()+pq.poll()*2);
        return pq.peek()>=K ? scoville.length-pq.size() : -1;
    }
}