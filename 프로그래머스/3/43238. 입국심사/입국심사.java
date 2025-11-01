import java.util.*;
/*

*/
class Solution {
    public long solution(int n, int[] times) {
        // 시간 기준 이분탐색
        // 최대시간 -> 가장 빠른 심사관이 혼자 다 처리할 경우의 시간
        int min = 1000000000;
        for (int i=0; i<times.length; i++) {
            min = Math.min(min, times[i]);
        }
        long maxTime = (long) min*n;
        
        long answer = binarySearch(1, maxTime, n, times, Long.MAX_VALUE);
        
        return answer;
    }
    private long binarySearch(long min, long max, int n, int[] times, long ans) {
        if (min > max) {
            return ans;
        }
        
        long mid = (min+max)/2;
        long res = 0;
        // 총 시간이 min일때 처리할 수 있는 사람 수 구하기
        for (int i=0; i<times.length; i++) {
            res += mid/times[i];
        }
        
        if (res>=n) {
            ans = Math.min(ans, mid);
            return binarySearch(min, mid-1, n, times, ans);
        } else {
            return binarySearch(mid+1, max, n, times, ans);
        }
    }
}