import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        Set<Integer>[] dp = new Set[9];
        for (int i=1; i<9; i++) {
            dp[i] = new HashSet<>();
        }
        for (int i=1; i<=5; i++) {
            int num = makeNum(N,i);
            if (num==number) return i;
            dp[i].add(num);
        }
        
        if (N==number) return 1;
        
        // 시작
        for (int i=2; i<=8; i++) {
            for (int j=1; j<i; j++) {
                if (cal(i, j, i-j, dp, number)) {
                    return i;
                }
            }
        }

        return -1;
    }
    private int makeNum(int n, int cnt) {
        int res = 0;
        while (cnt>0) {
            res += n;
            n*=10;
            cnt-=1;
        }
        return res;
    }
    private boolean cal (int target, int l, int r, Set<Integer>[] dp, int number) {
        // 사칙연산
        for (int lv : dp[l]) {
            for (int rv: dp[r]) {
                if (lv+rv == number) return true;
                dp[target].add(lv+rv);
                
                if (lv-rv == number) return true;
                dp[target].add(lv-rv);
                
                if (lv*rv == number) return true;
                dp[target].add(lv*rv);
                
                if (rv>0){
                    if (lv/rv == number) return true;
                    dp[target].add(lv/rv);
                }
            }
        }
        return false;
    }
}
