import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt(); 
        for (int t = 1; t <= K; t++) {
            int N = sc.nextInt();  
            int[] scores = new int[N];

            for (int i = 0; i < N; i++) {
                scores[i] = sc.nextInt();
            }

            Arrays.sort(scores);

            int maxGap = 0;
            for (int i = N - 1; i > 0; i--) {
                maxGap = Math.max(maxGap, scores[i] - scores[i - 1]);
            }

            System.out.println("Class " + t);
            System.out.println("Max " + scores[N - 1] + ", Min " + scores[0] + ", Largest gap " + maxGap);
        }

        sc.close();
    }
}
