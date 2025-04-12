import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = sc.nextInt();
        }

        int answer = 1;
        while (true) {
            int count = 0;

            for (int i = 0; i < 5; i++) {
                if (answer % nums[i] == 0) {
                    count++;
                }
            }

            if (count >= 3) {
                System.out.println(answer);
                break;
            }

            answer++;
        }

        sc.close();
    }
}
