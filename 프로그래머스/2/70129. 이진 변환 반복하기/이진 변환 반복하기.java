import java.util.*;

class Solution {
    public int[] solution(String s) {
        int converted = 0; // 변환 횟수
        int removed = 0; // 제거된 0 개수
        
        while (s.length()>1) {
            int cntOne = 0;
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i)=='1') cntOne += 1;
                else removed+=1;
            }
            
            s = Integer.toBinaryString(cntOne);
            
            converted+=1;
        }
        
        return new int[]{converted, removed};
    }
}