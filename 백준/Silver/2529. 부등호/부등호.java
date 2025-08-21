import java.util.*;

public class Main {
    static int k;
    static char[] sign;
    static boolean[] visited = new boolean[10];
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        sign = new char[k];
        for (int i = 0; i < k; i++) {
            sign[i] = sc.next().charAt(0);
        }

        dfs("", 0);

        Collections.sort(result); // 사전순 정렬 → 숫자 크기 순서
        System.out.println(result.get(result.size() - 1)); // 최댓값
        System.out.println(result.get(0));                 // 최솟값
    }

    static void dfs(String num, int depth) {
        if (depth == k + 1) {
            result.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                if (depth == 0 || check(num.charAt(depth - 1) - '0', i, sign[depth - 1])) {
                    visited[i] = true;
                    dfs(num + i, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    static boolean check(int a, int b, char op) {
        if (op == '<') return a < b;
        else return a > b;
    }
}
