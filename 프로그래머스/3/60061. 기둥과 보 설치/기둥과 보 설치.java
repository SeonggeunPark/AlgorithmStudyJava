import java.util.*;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        boolean[][] pillars = new boolean[n+1][n+1];
        boolean[][] beams = new boolean[n+1][n+1];

        for (int[] job:build_frame) {
            treat(job, pillars, beams, n);
        }

        List<int[]> res = new ArrayList<>();
        for (int r=0; r<=n; r++) {
            for (int c=0; c<=n; c++) {
                if (pillars[r][c]) res.add(new int[]{r, c, 0});
                if (beams[r][c]) res.add(new int[]{r, c, 1});
            }
        }

        int[][] answer = new int[res.size()][3];
        for (int i=0; i<res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }

    public void treat(int[] job, boolean[][] pillars, boolean[][] beams, int n) {
        int x = job[0];
        int y = job[1];
        int sType = job[2];
        int jType = job[3];

        // 삭제
        if (jType == 0) {
            // 기존 상태 저장
            boolean before;

            if (sType == 0) {
                before = pillars[x][y];
                pillars[x][y] = false; // 일단 삭제
            } else {
                before = beams[x][y];
                beams[x][y] = false; // 일단 삭제
            }

            //
            if (!isValid(pillars, beams, n)) {
                //
                if (sType == 0) pillars[x][y] = before;
                else beams[x][y] = before;
            }

        } 
        // 설치
        else {
            if (sType == 0) {
                // 🔧 기둥 설치 조건 수정 (오른쪽 보 추가)
                if (y == 0 ||
                    pillars[x][y-1] ||
                    (x > 0 && beams[x-1][y]) ||
                    beams[x][y]) {

                    pillars[x][y] = true;

                    // 🔧 설치 후 검증
                    if (!isValid(pillars, beams, n)) {
                        pillars[x][y] = false; // 롤백
                    }
                }

            } else {
                // 🔧 보 설치 조건 + 범위 체크 추가
                if ((pillars[x][y-1] || pillars[x+1][y-1]) ||
                    (x > 0 && x < n && beams[x-1][y] && beams[x+1][y])) {

                    beams[x][y] = true;

                    // 🔧 설치 후 검증
                    if (!isValid(pillars, beams, n)) {
                        beams[x][y] = false; // 롤백
                    }
                }
            }
        }
    }

    // 전체 구조 검증
    public boolean isValid(boolean[][] pillars, boolean[][] beams, int n) {
        for (int x=0; x<=n; x++) {
            for (int y=0; y<=n; y++) {

                // 기둥
                if (pillars[x][y]) {
                    if (!(y == 0 ||
                          pillars[x][y-1] ||
                          (x > 0 && beams[x-1][y]) ||
                          beams[x][y])) {
                        return false;
                    }
                }

                // 보
                if (beams[x][y]) {
                    if (!(pillars[x][y-1] ||
                          pillars[x+1][y-1] ||
                          (x > 0 && x < n && beams[x-1][y] && beams[x+1][y]))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}