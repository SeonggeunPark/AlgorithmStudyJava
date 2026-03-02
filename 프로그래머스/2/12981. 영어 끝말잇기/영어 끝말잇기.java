import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Map<String, Boolean> check = new HashMap<>();
        int[] answer = {0, 0};
        char prefix = words[0].charAt(words[0].length()-1);
        check.put(words[0], true);
        for (int i=1; i<words.length; i++) {
            String word = words[i];
            if (check.containsKey(word) || word.charAt(0)!=prefix) {
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;
            }
            check.put(word, true);
            prefix = word.charAt(word.length()-1);
        }
        
        return answer;
    }
}