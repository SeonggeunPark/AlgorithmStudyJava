import java.util.*;
/*
규칙 준수 체크
- P인 곳 좌표 기록
- 맨해튼 거리 이내 체크 (BFS)
*/

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int idx = 0;
        for (String[] place : places) {
            answer[idx++] = check(place);
        }
        
        return answer;
    }
    public int check(String[] place) {
        // 사람 기록
        List<int[]> applicants = new ArrayList<>();
        for (int i=0; i<place.length; i++) {
            for (int j=0; j<place[0].length(); j++) {
                char c = place[i].charAt(j);
                if (c=='P') {
                    applicants.add(new int[]{i,j});
                }
            }
        }
        
        for (int[] applicant : applicants) {
            int r = applicant[0];
            int c = applicant[1];
            
            if (!bfs(r, c, place)) return 0;
        }
        
        return 1;
    }
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public boolean bfs (int sr, int sc, String[] place) {
        int R = place.length;
        int C = place[0].length();
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        boolean[][] visited = new boolean[R][C];
        visited[sr][sc]=true;
        
        int size = 1;
        int cnt = 0;
        while (!q.isEmpty() && cnt < 2) {
            for (int i=0; i<size; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                
                // 4방향 탐색
                for (int dir = 0; dir < 4; dir++) {
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];
                    // 범위 체크
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc]) continue;
                    
                    char pos = place[nr].charAt(nc);
                    if (pos=='P') return false; // 사람 있으면 규정 위반
                    if (pos=='X') continue; // 파티션 있으면 패스
                    // 테이블이면 큐에 삽입
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
            size = q.size();
            cnt+=1;
        }
        return true;
    }
}