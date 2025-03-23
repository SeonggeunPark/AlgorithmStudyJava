import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()); // 출발점 x
            int y1 = Integer.parseInt(st.nextToken()); // 출발점 y
            int x2 = Integer.parseInt(st.nextToken()); // 도착점 x
            int y2 = Integer.parseInt(st.nextToken()); // 도착점 y

            int n = Integer.parseInt(br.readLine()); // 행성계 개수
            int count = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken()); // 원 중심 x
                int cy = Integer.parseInt(st.nextToken()); // 원 중심 y
                int r = Integer.parseInt(st.nextToken());  // 반지름

                // 출발점이 해당 원 내부인지 판단
                boolean startIn = isInside(x1, y1, cx, cy, r);
                boolean endIn = isInside(x2, y2, cx, cy, r);

                // 둘 중 하나만 원 내부인 경우 → 경계 통과
                if (startIn != endIn) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    // 점 (x, y)가 원 (cx, cy, r)의 내부에 있는지 판별
    private static boolean isInside(int x, int y, int cx, int cy, int r) {
        int dx = x - cx;
        int dy = y - cy;
        return dx * dx + dy * dy < r * r;
    }
}
