/*
1 2 3 / 4 5
1 2 / 3 4 5
1 / 2 / 3 / 4 5
1 
분할정복?
*/

import java.util.*;
class Solution {
    public int solution(int[] a) {
        int n = a.length;
        // 양 옆에서 시작해 가장 최소값을 저장하는 배열 생성
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = a[0];
        dp2[n-1] = a[n-1];
        for (int i=1; i<n; i++) {
            dp1[i] = Math.min(dp1[i-1], a[i]);
            dp2[n-1-i] = Math.min(dp2[n-i], a[n-1-i]);
        }
        // 탐색
        int answer = 0;
        for (int i=0; i<n; i++) {
            if (a[i] > dp1[i] && a[i] > dp2[i]) continue;
            answer+=1;
        }
        return answer;
    }
}