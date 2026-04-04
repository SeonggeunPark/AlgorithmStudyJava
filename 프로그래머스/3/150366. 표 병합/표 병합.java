import java.util.*;

class Solution {
    int[][][] p = new int[51][51][2];
    String[][] table;
    List<String> prints;
    public String[] solution(String[] commands) {
        table = new String[51][51];
        for (int r=1; r<=50; r++) {
            for (int c=1; c<=50; c++) {
                table[r][c] = "";
            }
        }
        prints = new ArrayList<>();
        // 1. 부모배열 초기화
        for (int r=1; r<51; r++) {
            for (int c=1; c<51; c++) {
                p[r][c][0] = r;
                p[r][c][1] = c;
            }
        }
        
        // 2. 명령어 처리
        for (String command : commands) {
            treat(command);
        }
        
        // 3. 응답 생성
        String[] answer = new String[prints.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = prints.get(i);
        }        
        return answer;
    }
    public void treat(String command) {
        String[] coms = command.split(" ");
        switch (coms[0]) {
            case "UPDATE" : {
                if (coms.length == 4) {
                    int r1 = Integer.parseInt(coms[1]);
                    int c1 = Integer.parseInt(coms[2]);
                    int[] pos = find(r1, c1);
                    table[pos[0]][pos[1]] = coms[3];
                    break;
                }
                else if (coms.length == 3) {
                    for (int r=1; r<=50; r++) {
                        for (int c=1; c<=50; c++ ) {
                            int[] pos = find(r, c);
                            if (table[pos[0]][pos[1]].equals(coms[1])) {
                                table[pos[0]][pos[1]]=coms[2];
                            }
                        }
                    }
                    break;
                }
                break;
            }
            case "MERGE" : {
                int r1 = Integer.parseInt(coms[1]);
                int c1 = Integer.parseInt(coms[2]);
                int r2 = Integer.parseInt(coms[3]);
                int c2 = Integer.parseInt(coms[4]);
                int[] p1 = find(r1, c1);
                int[] p2 = find(r2, c2);
                
                if (p1[0]==p2[0] && p1[1]==p2[1]) break;
                
                if (table[p1[0]][p1[1]].length()<=0) {
                    table[p1[0]][p1[1]] = table[p2[0]][p2[1]];
                }
                
                union(r1, c1, r2, c2);
                break;
            }
            case "UNMERGE" : {
                int r1 = Integer.parseInt(coms[1]);
                int c1 = Integer.parseInt(coms[2]);
                // 해당 좌표와 같은 우두머리를 갖고있는 경우 초기화
                int[] p1 = find(r1, c1);
                String value = table[p1[0]][p1[1]];
                List<int[]> members = new ArrayList<>();
                for (int r=1; r<=50; r++) {
                    for (int c=1; c<=50; c++ ) {
                        int[] p2 = find(r, c);
                        if (p2[0]==p1[0] && p2[1]==p1[1]) {
                            members.add(new int[]{r, c});
                        }
                    }
                }
                // 표, 부모배열 초기화
                for (int[] pos : members) {
                    table[pos[0]][pos[1]] = "";
                    p[pos[0]][pos[1]][0] = pos[0];
                    p[pos[0]][pos[1]][1] = pos[1];
                }
                table[r1][c1] = value;
                break;
            }
            case "PRINT" : {
                int r1 = Integer.parseInt(coms[1]);
                int c1 = Integer.parseInt(coms[2]);
                int[] p1 = find(r1, c1);
                prints.add(table[p1[0]][p1[1]].equals("") ? "EMPTY" : table[p1[0]][p1[1]]);
                break;
            }
            default : {
                break;
            }
        }
    }
    // 대표셀 조회
    public int[] find(int r, int c) {
        if (p[r][c][0] == r && p[r][c][1] == c) {
            return new int[]{r, c};
        }
        int[] parent = find(p[r][c][0], p[r][c][1]);
        p[r][c][0] = parent[0];
        p[r][c][1] = parent[1];
        return parent;
    }
    // 셀 병합 (r1, c1)이 더 높은 지위
    public void union (int r1, int c1, int r2, int c2) {
        int[] p1 = find(r1, c1);
        int[] p2 = find(r2, c2);
        
        if (p1[0]==p2[0] && p1[1]==p2[1]) return;
        p[p2[0]][p2[1]][0] = p1[0];
        p[p2[0]][p2[1]][1] = p1[1];
    }
}