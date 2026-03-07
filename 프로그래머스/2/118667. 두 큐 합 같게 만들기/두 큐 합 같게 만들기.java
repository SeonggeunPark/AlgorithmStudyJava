class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int len = queue1.length;
        long target = 0;
        long[] comb = new long[len*2];
        for (int i=0; i<len; i++ ) {
            comb[i] = queue1[i];
            target += queue1[i];
        }
        
        long sum = target;
        
        for (int i=len; i<len*2; i++ ) {
            comb[i] = queue2[i-len];
            target += queue2[i-len];
        }
        
        if (target%2!=0) return -1;
        
        target /= 2;
        int answer = 0;
        int s = 0;
        int e = len-1;
        while (sum!=target) {
            if (s>e) return -1;
            if (sum<target) {
                e += 1;
                if (e>=len*2) return -1;
                sum += comb[e];
                answer += 1;
            }
            else if (sum > target) {
                sum -= comb[s];
                s += 1;
                answer += 1;
            }
        }
        
        return answer;
    }
}
