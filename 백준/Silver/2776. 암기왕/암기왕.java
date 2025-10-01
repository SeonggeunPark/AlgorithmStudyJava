import java.io.*;
import java.util.*;

public class Main {
    // 빠른 입력 전용 스캐너
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) { this.in = is; }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do { c = read(); } while (c <= ' '); // skip spaces
            if (c == '-') { sign = -1; c = read(); }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = fs.nextInt();
        while (T-- > 0) {
            int N = fs.nextInt();
            // 초기 용량을 넉넉히 잡아 리사이즈 비용 감소
            HashSet<Integer> note1 = new HashSet<>(Math.max(16, N * 2));

            for (int i = 0; i < N; i++) {
                note1.add(fs.nextInt());
            }

            int M = fs.nextInt();
            for (int i = 0; i < M; i++) {
                int x = fs.nextInt();
                sb.append(note1.contains(x) ? 1 : 0).append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}
