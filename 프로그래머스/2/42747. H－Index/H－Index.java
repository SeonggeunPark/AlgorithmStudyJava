// 0 3 5 6 9
// 0 - 5
// 4 - 4
// 5 - 3
// 6 - 2
import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        
        int answer =0;
        for (int i=0; i<n; i++) {
            int cnt = citations[i];
            if (cnt > n-i) {
                answer = Math.max(n-i, answer);
                break;
            }
            answer = cnt;
        }
        return answer;
    }
}