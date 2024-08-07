import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());
            
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());
            
            // 두 직사각형이 겹치지 않는 경우 (d)
            if (p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1) {
                System.out.println("d");
            }
            // 두 직사각형이 점에서 만나는 경우 (c)
            else if ((p1 == x2 && q1 == y2) || (p1 == x2 && y1 == q2) ||
                     (x1 == p2 && q1 == y2) || (x1 == p2 && y1 == q2)) {
                System.out.println("c");
            }
            // 두 직사각형이 선분에서 만나는 경우 (b)
            else if (p1 == x2 || x1 == p2 || q1 == y2 || y1 == q2) {
                System.out.println("b");
            }
            // 두 직사각형이 직사각형에서 만나는 경우 (a)
            else {
                System.out.println("a");
            }
        }
    }
}