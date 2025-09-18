import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] rowPos = new int[26];
        int[] colPos = new int[26];

        // 빙고판 입력
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                rowPos[num] = i;
                colPos[num] = j;
            }
        }

        boolean[][] check = new boolean[5][5];
        int[] rowCnt = new int[5];
        int[] colCnt = new int[5];
        int diag1 = 0, diag2 = 0;

        boolean[] rowDone = new boolean[5];
        boolean[] colDone = new boolean[5];
        boolean diag1Done = false, diag2Done = false;

        int bingo = 0;
        int callCnt = 0;

        // 사회자 숫자 입력
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                callCnt++;

                int r = rowPos[num];
                int c = colPos[num];

                if (!check[r][c]) {
                    check[r][c] = true;

                    if (++rowCnt[r] == 5 && !rowDone[r]) {
                        rowDone[r] = true;
                        bingo++;
                    }
                    if (++colCnt[c] == 5 && !colDone[c]) {
                        colDone[c] = true;
                        bingo++;
                    }
                    if (r == c) {
                        if (++diag1 == 5 && !diag1Done) {
                            diag1Done = true;
                            bingo++;
                        }
                    }
                    if (r + c == 4) {
                        if (++diag2 == 5 && !diag2Done) {
                            diag2Done = true;
                            bingo++;
                        }
                    }
                }

                if (bingo >= 3) {
                    System.out.println(callCnt);
                    return;
                }
            }
        }
    }
}
