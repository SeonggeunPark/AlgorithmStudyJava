import java.util.*;
class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];
        Map<Character, Integer> mapper = new HashMap<>();
        mapper.put('U', 0);
        mapper.put('D', 1);
        mapper.put('L', 2);
        mapper.put('R', 3);
        
        int r = 5;
        int c = 5;
        for (int i=0; i<dirs.length(); i++) {
            int dir = mapper.get(dirs.charAt(i));
            int nr = r+dr[dir];
            int nc = c+dc[dir];
            // 범위 체크
            if (nr<0||nr>10||nc<0||nc>10) continue;
            if (!visited[nr][nc][dir]) {
                visited[nr][nc][dir] = true;
                visited[r][c][(dir==0||dir==2) ? dir+1 : dir-1] = true;
                answer+=1;
            }
            r = nr;
            c = nc;
        }
        
        return answer;
    }
}