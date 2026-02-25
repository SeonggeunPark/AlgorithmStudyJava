import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> sizes = new HashMap<>();
        for (int n:tangerine) {
            sizes.put(n, sizes.getOrDefault(n, 0)+1);
        }
        int[] cnts = new int[sizes.keySet().size()];
        int idx = 0;
        for (int key : sizes.keySet()) {
            cnts[idx++] = sizes.get(key);
        }
        Arrays.sort(cnts);
        
        int answer = 0;
        int sum = 0;
        int len = cnts.length;
        for (int i=len-1; i>=0; i--) {
            sum += cnts[i];
            answer += 1;
            if (sum >= k) break;
        }
        
        return answer;
    }
}