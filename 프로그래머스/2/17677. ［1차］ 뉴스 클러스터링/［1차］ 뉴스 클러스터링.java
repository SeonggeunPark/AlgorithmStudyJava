import java.util.*;
/*
1. 2글자씩 잘라 집합만들기
    - 문자열순회하며 끊음
    - 문자열은 Map(문자열 : 개수)
2. 자카드유사도 계산
    - 두 집합 모두 순회하며 교집합, 합집합 개수로 동시에 구함
    - 양쪽 다 있으면 개수비교, 한쪽만 있으면 합집합으로
*/
class Solution {
    public int solution(String str1, String str2) {
        // 두 집합 생성
        Map<String, Integer> A = new HashMap<>();
        Map<String, Integer> B = new HashMap<>();
        extractSet(str1, A);
        extractSet(str2, B);
        
        // 자카드유사도 계산
        return cal(A, B);
    }
    public void extractSet(String str, Map<String, Integer> set) {
        for (int i=0; i<str.length()-1; i++) {
            char first = str.charAt(i);
            char second = str.charAt(i+1);
            // 영문자 아닌경우 패스
            if (!((first>='A' && first<='Z') || (first>='a' && first<='z'))) {
                continue;
            }
            if (!((second>='A' && second<='Z') || (second>='a' && second<='z'))) {
                i+=1;
                continue;
            }
            
            String newStr = str.substring(i,i+2).toLowerCase();
            
            // 집합에 추가
            set.put(newStr, set.getOrDefault(newStr, 0)+1);
        }
    }
    public int cal(Map<String, Integer> A, Map<String, Integer> B) {
        double intersection = 0; // 교집합 개수
        double union = 0; // 합집합 개수   
        
        for (String key : A.keySet()) {
            if (B.containsKey(key)) {
                union+=Math.max(A.get(key), B.get(key));
                intersection+=Math.min(A.get(key), B.get(key));
            } else {
                union += A.get(key);
            }
        }
        for (String key : B.keySet()) {
            if (!A.containsKey(key)) 
                union += B.get(key);
        }
        return union>0 ? (int)(intersection/union*65536) : 65536;
    }
}