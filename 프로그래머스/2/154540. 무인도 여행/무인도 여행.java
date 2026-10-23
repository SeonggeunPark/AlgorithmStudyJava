import java.util.*;

class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    int R, C;
        List<Integer> days = new ArrayList<>();
    public int[] solution(String[] maps) {
        R = maps.length;
        C = maps[0].length();
        for (int r=0;r<R; r++) {
            for (int c=0; c<C; c++) {
                if ('X'==(maps[r].charAt(c))) continue;
                days.add(search(r, c, 0, maps));
            }
        }
        
        if (days.size()<=0) return new int[]{-1};
        
        int[] answer = new int[days.size()];
        for (int i=0; i<days.size(); i++) {
            answer[i] = days.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    public int search(int r, int c, int count, String[] maps) {
        count += maps[r].charAt(c) - '0';
        maps[r] = maps[r].substring(0,c)+"X"+maps[r].substring(c+1,C);
        for (int dir = 0 ; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            
            if (nr>=R || nr<0 || nc>=C || nc<0 || 'X'==maps[nr].charAt(nc)) continue;
            
            count += search(nr, nc, 0, maps);
        }
        
        return count;
    }
}