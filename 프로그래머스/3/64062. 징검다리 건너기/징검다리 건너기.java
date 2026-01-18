import java.util.*;
/*
이분탐색

n명이 건널 수 있는지를 매번 체크
*/
class Solution {
    public int solution(int[] stones, int k) {
        return binarySearch(0, 200000000, stones, k);
    }
    public int binarySearch(int s, int e, int[] stones, int k) {
        if (s>e) return e;
        
        int mid = (s+e)/2;
        if (check(mid, stones, k)) {
            return binarySearch(mid+1, e, stones, k);
        } else {
            return binarySearch(s, mid-1, stones, k);
        }
    }
    // n명이 건널 수 있는지 체크
    public boolean check(int n, int[] stones, int k) {
        int cnt = 0;
        for (int i=0; i<stones.length; i++) {
            if (stones[i]-n < 0) {
                cnt += 1;
            } else {
                cnt = 0;
            }
            if (cnt >= k) {
                return false;
            }
        }
        return true;
    }
}