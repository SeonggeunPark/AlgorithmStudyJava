import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;
        Arrays.sort(citations);
        
        for (int i=len-1; i>=0; i--) {
            if (len-i <= answer) break;
            int cnt = Math.min(len-i, citations[i]);
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
}