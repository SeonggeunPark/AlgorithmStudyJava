import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 통화 횟수
        int yTotal = 0;
        int mTotal = 0;

        for (int i = 0; i < n; i++) {
            int time = sc.nextInt();

            yTotal += (time / 30 + 1) * 10;
            mTotal += (time / 60 + 1) * 15;
        }

        if (yTotal < mTotal) {
            System.out.println("Y " + yTotal);
        } else if (mTotal < yTotal) {
            System.out.println("M " + mTotal);
        } else {
            System.out.println("Y M " + yTotal);
        }
    }
}
