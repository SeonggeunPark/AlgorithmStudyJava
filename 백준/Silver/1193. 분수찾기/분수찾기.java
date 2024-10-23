import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 분자 분모 합이 같은 경우끼리 모으면  
		// 행렬상 대각선이 됨
		// 가장 첫번째 열의 값을 부모값이라고 할 때 부모 값이 몇번째 수인지 찾음
		int p = findParent(N); // 부모 값의 분자 or 분모 값을 저장
		int pNum = p*(p-1)/2+1; // 부모 값이 몇번째 수인지 저장
		
		if (p%2 == 0) {
			System.out.println((1+N-pNum) +"/"+(p-N+pNum));
		} else {
			System.out.println((p-N+pNum) +"/"+(1+N-pNum));
		}
	
	}

	private static int findParent(int n) {
		int i=1;
		while (true) {
			// 해당 집합에서의 최대값
			int max = i*(i+1)/2;
			
			if (max >= n) {
				break;
			}
			
			i+=1;
		}
		
		// i값을 찾았다면.. N번째 분수 집합의 부모값은 i / 1 이다.
		// 부모 값은 i*(i-1)/2 + 1 번째 수
		return i;
		
		
	}

}
