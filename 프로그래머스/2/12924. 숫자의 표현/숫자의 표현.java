class Solution {
    public int solution(int n) {
        int answer = 0;
        int s=1; int e=1;
        int sum = 1;
        while (s<=n) {
            if (sum > n) {
                sum -= s;
                s+=1;
            }
            else if (sum < n) {
                e+=1;
                sum += e;
            } else {
                answer += 1;
                sum -= s;
                s+=1;
            }
        }
        return answer;
    }
}