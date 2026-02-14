import java.util.*;
class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        
        // 단어 Map 저장
        Map<Integer, String> dict = new HashMap<>();
        // 빨리 찾기 위한 알파벳순 배열
        Map<String, Integer> indexes = new HashMap<>();
        for (int i=1; i<=26; i++) {
            dict.put(i, String.valueOf((char) ('A'+i-1)));
            indexes.put(String.valueOf((char) ('A'+i-1)), i);
        }
        int len = msg.length();
        int newIdx = 27;
        int s=0; int e=0;
        while (s<msg.length()) {
            // 현재 입력: msg
            char head = msg.charAt(0);
            // 가장 긴 일치하는 문자열 탐색
            String w = "";
            for (int i=msg.length(); i>=s; i--) {
                String tmp = msg.substring(s,i);
                if (indexes.containsKey(tmp)) {
                    w = msg.substring(s,i);
                    answer.add(indexes.get(tmp));     // 색인 기록
                    s=i;
                    break;
                }
            }
            // 사전 등록
            if (s<msg.length()) {
                String newWord = w+msg.charAt(s);
                dict.put(newIdx, newWord);
                indexes.put(newWord, newIdx++);
            }
        }
        
        int[] res = new int[answer.size()];
        for (int i=0; i<answer.size(); i++) {
            res[i]=answer.get(i);
        }
        return res;
    }
}