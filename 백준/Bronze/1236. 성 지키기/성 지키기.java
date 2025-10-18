import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            // 공백 없이 들어옴: 예) "..X."
            for (int j = 0; j < M; j++) map[i][j] = line.charAt(j);
        }

        // 경비원(X)이 전혀 없는 행/열 개수 계산
        int emptyRows = 0, emptyCols = 0;

        // 행 검사
        for (int i = 0; i < N; i++) {
            boolean hasGuard = false;
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'X') { hasGuard = true; break; }
            }
            if (!hasGuard) emptyRows++;
        }

        // 열 검사
        for (int j = 0; j < M; j++) {
            boolean hasGuard = false;
            for (int i = 0; i < N; i++) {
                if (map[i][j] == 'X') { hasGuard = true; break; }
            }
            if (!hasGuard) emptyCols++;
        }

        System.out.println(Math.max(emptyRows, emptyCols));
    }
}
