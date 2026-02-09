import java.util.*;

class Solution {
    public int[] solution(String s) {
        int converted = 0; // 변환 횟수
        int removed = 0; // 제거된 0 개수
        
        int len = s.length();
        
        while (s.length()>1) {
            // 1. 모든 0 제거
            s = s.replaceAll("0","");
            removed += len-s.length(); // 제거된 0 개수 누적
            len = s.length(); // s 길이 갱신
            
            // 2. s 길이를 2진법 변환
            String tmp = "";
            for (int i=1; i <= len; i = i << 1) {
                if ((len & i) == i) {
                    tmp = "1"+tmp;
                } else {
                    tmp = "0"+tmp;
                }
            }
            s = tmp;
            len = s.length(); // s 길이 갱신
            
            converted+=1;
        }
        
        int[] answer = {};
        return new int[]{converted, removed};
    }
}