class Solution {
    public int solution(int n) {
        int stdCnt = countOne(n);
        int answer = n+1;
        while (answer<=1000000) {
            if (countOne(answer)==stdCnt) return answer;
            answer+=1;
        }
        return answer;
    }
    public int countOne(int n) {
        int cnt = 0;
        for (int i=1; i<=n; i = i << 1) {
            if ((n&i) == i) cnt += 1;
        }
        return cnt;
    }
}