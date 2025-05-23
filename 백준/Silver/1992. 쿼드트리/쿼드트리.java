import java.util.*;

public class Main {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        compress(0, 0, N);
        System.out.println(sb.toString());
    }

    static void compress(int x, int y, int size) {
        if (isSame(x, y, size)) {
            sb.append(arr[x][y]);
            return;
        }

        sb.append("(");
        int newSize = size / 2;
        compress(x, y, newSize);                      // 왼쪽 위
        compress(x, y + newSize, newSize);            // 오른쪽 위
        compress(x + newSize, y, newSize);            // 왼쪽 아래
        compress(x + newSize, y + newSize, newSize);  // 오른쪽 아래
        sb.append(")");
    }

    static boolean isSame(int x, int y, int size) {
        int value = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
