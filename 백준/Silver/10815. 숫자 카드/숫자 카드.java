import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		boolean[] exist = new boolean[20000000];	// 해당 숫자 존재 여부 저장
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			exist[Integer.parseInt(st.nextToken())+10000000] = true;	//숫자 입력 받아 존재 체크
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<M; i++) {
			if (exist[Integer.parseInt(st.nextToken())+10000000]) {
				sb.append('1').append(' ');
			} else {
				sb.append('0').append(' ');
			}
		}
		
		System.out.println(sb);
	}
}
