import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right-left+1)];
        int idx = 0;
        for (long i=left; i<=right; i++) {
            answer[idx++] = treat(i, n);
        }
        return answer;
    }
    public int treat(long num, int n) {
        int r = (int)(num/n);
        int c = (int)(num%n);
        return Math.max(r,c)+1;
    }
}