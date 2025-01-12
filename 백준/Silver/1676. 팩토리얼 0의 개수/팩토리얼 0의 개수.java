import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 숫자 끝에 0이 붙으려면 어떤 수에 10을 곱해야 함
 * 팩토리얼 에서 10이 곱해지는 경우는 2*5뿐임
 * 따라서 N!에서 0의 개수는 1부터 N까지 모든 수를 소인수분해했을 때
 * 2,5 짝의 개수를 구하면 됨.
 * 
 * 여기서 2의 개수는 2, 4, 8 ... 로 5의 개수보다 확실히 많으므로,
 * => 결국 5의 개수를 세면 된다.
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int zeroCount = 0;
		
		for (int i=5; i<=N; i+=5) {
			// 5로 나눠지는 횟수만큼 0 개수 추가
			zeroCount += countFive(i);
		}
		
		System.out.println(zeroCount);
	}

	private static int countFive(int i) {
		int count = 0;
		while (i % 5 == 0) {
			i /= 5;
			count += 1;
		}
		return count;
	}
}
