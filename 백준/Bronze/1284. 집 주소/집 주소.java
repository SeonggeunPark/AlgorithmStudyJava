import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String num = sc.next();
            if (num.equals("0")) break;

            int width = 1; // 맨 앞 여백
            for (char c : num.toCharArray()) {
                if (c == '1') width += 2;
                else if (c == '0') width += 4;
                else width += 3;
                width += 1; // 숫자 사이 여백
            }
            System.out.println(width);
        }
    }
}
