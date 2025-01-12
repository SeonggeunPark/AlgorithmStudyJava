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
