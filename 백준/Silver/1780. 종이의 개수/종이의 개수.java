import java.io.*;

public class Main {
    static int[][] paper;
    static int[] count = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(line[j]);
            }
        }

        countPaper(0, 0, n);

        for (int i = 0; i < 3; i++) {
            System.out.println(count[i]);
        }
    }

    static void countPaper(int x, int y, int size) {
        if (isSame(x, y, size)) {
            count[paper[x][y] + 1]++;
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                countPaper(x + i * newSize, y + j * newSize, newSize);
            }
        }
    }

    static boolean isSame(int x, int y, int size) {
        int value = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
