import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
// 방법 1
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        // 배열을 -1로 초기화 하지 않으면 값이 0으로 자동 초기화됨.
        // 그렇게 될 경우 나머지가 0인 상황에서 중복되는 값으로 인식되어
        // 카운트되지 않는 오류가 발생.
		int[] arr = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		int cnt = 0;
		
		out: for (int i=0; i<10; i++) {
			int n = sc.nextInt() % 42;
			
			for (int j=0; j<=i-1; j++) {
				if (arr[j] == n) {
					continue out;
				}
			}
			arr[i] = n;
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
// 방법 2 : Set 자료형을 이용해 중복을 거를 수 있다.
// 실행속도가 4ms정도 더 빨랐으나, 유의미한 차이는 아닌 것으로 보임 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Integer> set = new HashSet<>();
		
		out: for (int i=0; i<10; i++) {
			set.add(sc.nextInt() % 42);
		}
		
		System.out.println(set.size());
	}
}
