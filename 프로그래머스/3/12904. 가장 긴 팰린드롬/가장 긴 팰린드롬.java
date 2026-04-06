class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // 1. 홀수 길이 팰린드롬 체크
            answer = Math.max(answer, expand(s, i, i));
            
            // 2. 짝수 길이 팰린드롬 체크
            answer = Math.max(answer, expand(s, i, i + 1));
        }

        return answer;
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}