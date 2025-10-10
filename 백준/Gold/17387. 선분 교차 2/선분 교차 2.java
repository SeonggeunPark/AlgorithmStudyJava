import java.io.*;
import java.util.*;

public class Main {
    static class P implements Comparable<P> {
        long x, y;
        P(long x, long y) { this.x = x; this.y = y; }
        @Override public int compareTo(P o) {
            if (x != o.x) return Long.compare(x, o.x);
            return Long.compare(y, o.y);
        }
    }

    static long ccw(P a, P b, P c) {
        long v = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        return Long.compare(v, 0);  // -1, 0, 1
    }

    static boolean between(P a, P b, P c) {
        long minX = Math.min(a.x, b.x), maxX = Math.max(a.x, b.x);
        long minY = Math.min(a.y, b.y), maxY = Math.max(a.y, b.y);
        return (minX <= c.x && c.x <= maxX) && (minY <= c.y && c.y <= maxY);
    }

    static boolean intersect(P a, P b, P c, P d) {
        long ab_c = ccw(a, b, c);
        long ab_d = ccw(a, b, d);
        long cd_a = ccw(c, d, a);
        long cd_b = ccw(c, d, b);

        if (ab_c * ab_d < 0 && cd_a * cd_b < 0) return true;

        if (ab_c == 0 && between(a, b, c)) return true;
        if (ab_d == 0 && between(a, b, d)) return true;
        if (cd_a == 0 && between(c, d, a)) return true;
        if (cd_b == 0 && between(c, d, b)) return true;

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long x3 = Long.parseLong(st.nextToken());
        long y3 = Long.parseLong(st.nextToken());
        long x4 = Long.parseLong(st.nextToken());
        long y4 = Long.parseLong(st.nextToken());

        P A = new P(x1, y1), B = new P(x2, y2);
        P C = new P(x3, y3), D = new P(x4, y4);

        System.out.println(intersect(A, B, C, D) ? 1 : 0);
    }
}
