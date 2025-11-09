import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, visited, 0);
        
        return answer==Integer.MAX_VALUE ? 0 : answer;
    }
    public void dfs (String cur, String target, String[] words, boolean[] visited, int cnt) {
        if (cur.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }
        if (cnt >= visited.length) {
            return;
        }
        // 단어 비교하며 한단어만 차이나면 재귀 수행
        out:
        for (int j = 0; j < words.length; j++) {
            String word = words[j];
            int missCnt = 0;
            for (int i=0; i<word.length(); i++) {
                if (cur.charAt(i) == word.charAt(i)) continue;
                if (missCnt >= 1) continue out;
                missCnt += 1;
            }
            if (missCnt!=1 || visited[j]) continue out;
            System.out.println(cur +" -> "+word + "    "+missCnt);
            visited[j] = true;
            dfs(word, target, words, visited, cnt+1);
            visited[j] = false;
        }
    }
}