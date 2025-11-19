import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        int[] pick = new int[banned_id.length];
        boolean[] visited = new boolean[user_id.length];
        Set<String> banned_set = new HashSet<>();
        dfs(0, user_id, banned_id, pick, banned_set, visited);
        
        return banned_set.size();
    }
    public void dfs(int bIdx, String[] user_id, String[] banned_id, int[] pick, Set<String> banned_set, boolean[] visited) {
        if (bIdx >= banned_id.length) {
            String banned_list = "";
            for (int i=0; i<visited.length; i++) {
                if (visited[i]) {
                    banned_list+=i;
                }
            }
            banned_set.add(banned_list);
            return;
        }
             for (int u=0; u<user_id.length; u++) {
                 String bId = banned_id[bIdx];
                 String uId = user_id[u];

                 if (bId.length() != uId.length()) continue;
                 if (!check(bId, uId)) continue;
                 if (visited[u]) continue;
                 visited[u] = true;
                 dfs(bIdx+1, user_id, banned_id, pick, banned_set, visited);
                 visited[u] = false;
             }
    }
    public boolean check(String bId, String uId) {
        int len = bId.length();
        for (int i=0; i<len; i++){
            if (bId.charAt(i)=='*') continue;
            if (bId.charAt(i) != uId.charAt(i)) return false;
        }
        return true;
    }
}