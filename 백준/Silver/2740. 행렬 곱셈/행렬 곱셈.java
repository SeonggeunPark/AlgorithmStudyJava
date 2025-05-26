import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] A = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                A[i][j] = sc.nextInt();

        int m2 = sc.nextInt(); 
        int k = sc.nextInt();
        int[][] B = new int[m2][k];
        for (int i = 0; i < m2; i++)
            for (int j = 0; j < k; j++)
                B[i][j] = sc.nextInt();

        int[][] C = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < m; l++) {
                    C[i][j] += A[i][l] * B[l][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
