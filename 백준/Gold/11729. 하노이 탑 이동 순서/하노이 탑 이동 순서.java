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
	static int N, moveCount;
	static Stack<Integer>[] towers;
	static StringBuilder result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		moveCount = 0;
		result = new StringBuilder();
		
		moveDisks(N, 1, 3, 2);

		System.out.println(moveCount);
		System.out.println(result);
	}

	private static void moveDisks(int diskCount, int start, int end, int sub) {
		if (diskCount == 1) {
			moveCount += 1;
			result.append(start).append(' ').append(end).append('\n');
			return;
		}
		// 보조기둥으로 diskCount-1개만큼 옮기기
		moveDisks(diskCount-1, start, sub, end);
		// 남은 1개 원판을 목표기둥으로 옮기기
		moveCount+=1;
		result.append(start).append(' ').append(end).append('\n');
		// 보조기둥의 원판들을 목표기둥으로 옮기기
		moveDisks(diskCount-1, sub, end, start);
	}
}
