import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] x = new int[3];
        int[] y = new int[3];

        for (int i = 0; i < 3; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int fourthX, fourthY;

        // x 좌표 중 두 개가 같으면 나머지 하나가 네 번째 점의 x
        if (x[0] == x[1]) fourthX = x[2];
        else if (x[0] == x[2]) fourthX = x[1];
        else fourthX = x[0];

        // y 좌표도 동일한 방식
        if (y[0] == y[1]) fourthY = y[2];
        else if (y[0] == y[2]) fourthY = y[1];
        else fourthY = y[0];

        System.out.println(fourthX + " " + fourthY);
    }
}
