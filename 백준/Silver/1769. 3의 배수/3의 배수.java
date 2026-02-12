import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();  // 숫자 입력 받기
        int count = 0;  // 반복 횟수
        
        // 반복적으로 자릿수 합을 계산
        while (number.length() > 1) {
            int sum = 0;
            // 각 자릿수 합 구하기
            for (int i = 0; i < number.length(); i++) {
                sum += number.charAt(i) - '0';  // 각 자릿수를 정수로 변환하여 더함
            }
            number = Integer.toString(sum);  // 합을 다시 문자열로 변환
            count++;  // 반복 횟수 증가
        }
        
        // 최종 합이 3의 배수인지 확인
        if (Integer.parseInt(number) % 3 == 0) {
            System.out.println(count);
            System.out.println("YES");
        } else {
            System.out.println(count);
            System.out.println("NO");
        }
        
        sc.close();
    }
}
