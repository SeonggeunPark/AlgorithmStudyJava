import java.util.*;
/*
    모든 경우의 수 구하기
*/

class Solution {
    int[] reverseSum;
    int len, answer;
    public int solution(int[] numbers, int target) {
        len = numbers.length;
        reverseSum = new int[len];
        for (int i=len-1; i>=0; i--) {
            if (i==len-1) reverseSum[i] = numbers[i];
            else reverseSum[i] = reverseSum[i+1] + numbers[i];
        }
        answer = 0;
        
        dfs(0, 0, numbers,  target);
        
        return answer;
    }
    public void dfs(int idx, int sum, int[] numbers, int target) {
        if (idx>=len) {
            answer = (sum==target) ? (answer+1) : answer;
            return;
        }
        
        if (sum+reverseSum[idx] >= target) {
            dfs(idx+1, sum+numbers[idx], numbers, target);
        }
        if (sum-reverseSum[idx] <= target) {
            dfs(idx+1, sum-numbers[idx], numbers, target);
        }
    }
}