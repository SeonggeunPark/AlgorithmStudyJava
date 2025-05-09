import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = -1;
        for (int five = n / 5; five >= 0; five--) {
            int remain = n - (five * 5);
            if (remain % 2 == 0) {
                int two = remain / 2;
                count = five + two;
                break;
            }
        }

        System.out.println(count);
    }
}
