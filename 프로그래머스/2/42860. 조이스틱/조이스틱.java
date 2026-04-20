import java.util.*;

class Solution {
    public int solution(String name) {
        int cur = 0;
        int len = name.length();
        String curName = "A".repeat(len);
        int answer = 0;
        
        // 문자 변경 비용 계산
        for (int i=0; i<len; i++) {
            int num = name.charAt(i) - 'A';
            if (num != 0) {
                answer += Math.min(num, 26-num);
            }
        }
        
        // 커서 이동 비용 계산
        int min = len-1;
        for (int i=0; i<len; i++) {
            int next = i+1;
            while (next<len && name.charAt(next)=='A') {
                next+=1;
            }
            if (next>=len) {
                min = Math.min(min, i);
            } else {
                min = Math.min(min, i*2+(len-next));
                min = Math.min(min, (len-next)*2+i);
            }
        }
        answer += min;
        
        return answer;
    }
}