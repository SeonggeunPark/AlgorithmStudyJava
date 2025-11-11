import java.util.*;

class Solution {
    public long[] solution(long k, long[] room_number) {
        int size = room_number.length;
        long[] answer = new long[size];
        int idx = 0;
        Map<Long, Long> p = new HashMap<Long, Long>();
        
        for (long r : room_number) {
            long assigned = find(r,p);
            answer[idx++] = assigned;
            p.put(assigned, find(assigned+1,p));
        }
        
        return answer;
    }
    public long find(long x, Map<Long, Long> p) {
        if (p.get(x)== null) {
            return x;
        }
        long parent = find(p.get(x), p);
        p.put(x, parent);
        return parent;
    }
}