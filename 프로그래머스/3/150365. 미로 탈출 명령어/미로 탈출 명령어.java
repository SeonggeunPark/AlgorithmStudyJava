class Solution {
    int[] dr = {1, 0, 0, -1};
    int[] dc = {0, -1, 1, 0};
    char[] dir = {'d', 'l', 'r', 'u'};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dist = Math.abs(x - r) + Math.abs(y - c);
        if (dist > k) return "impossible";
        if ((k - dist) % 2 != 0) return "impossible";

        StringBuilder sb = new StringBuilder();
        int cr = x, cc = y;

        for (int i = 0; i < k; i++) {
            int remain = k - i - 1;
            boolean moved = false;

            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if (nr < 1 || nr > n || nc < 1 || nc > m) continue;

                int d2 = Math.abs(nr - r) + Math.abs(nc - c);
                if (d2 > remain) continue;
                if ((remain - d2) % 2 != 0) continue;

                sb.append(dir[d]);
                cr = nr;
                cc = nc;
                moved = true;
                break;
            }

            if (!moved) return "impossible";
        }

        return sb.toString();
    }
}
