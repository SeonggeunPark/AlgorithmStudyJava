/*
- 1, -1 순서 바꿔 곱한 수열 2개 생성
- 부분합 최대 찾기
*/
import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        int len = sequence.length;
        long[] s1 = new long[len];
        long[] s2 = new long[len];
        
        int p = -1;
        s1[0] = sequence[0];
        s2[0] = sequence[0]*-1;
        for (int i=1; i<len; i++) {
            s1[i] = s1[i-1]+sequence[i] * p;
            s2[i] = s2[i-1]+sequence[i] * p * -1;
            p *= -1;
        }
        
        long answer = Math.max(findMaxSum(s1,len), findMaxSum(s2,len));
        return answer;
    }
    public long findMaxSum(long[] s, int len) {
        long sum = s[0];
        long min = 0;
        for (int i=0; i<len; i++) {
            sum = Math.max(sum, s[i]-min);
            min = Math.min(min, s[i]);
        }
        return sum;
    }
}