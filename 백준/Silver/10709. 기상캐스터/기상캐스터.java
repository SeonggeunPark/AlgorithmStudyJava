import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();

        for (int i = 0; i < H; i++) {
            String row = sc.next();
            int cloudDistance = -1; 
            for (int j = 0; j < W; j++) {
                char current = row.charAt(j);

                if (current == 'c') {
                    cloudDistance = 0;
                } else if (cloudDistance != -1) {
                    cloudDistance++;
                }

                System.out.print(cloudDistance + " ");
            }
            System.out.println();
        }
    }
}