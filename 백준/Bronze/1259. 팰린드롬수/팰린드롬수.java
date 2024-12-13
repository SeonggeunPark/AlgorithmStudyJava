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

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] arr = br.readLine().toCharArray();
		out: while (arr[0] != '0') {
			
			for (int i = 0; i<arr.length/2; i++) {
				if (arr[i] != arr[arr.length-1-i]) {
					sb.append("no").append('\n');
					arr = br.readLine().toCharArray();
					continue out;
				}
			}
			
			sb.append("yes").append('\n');
			arr = br.readLine().toCharArray();
		}
		
		System.out.println(sb);
	}
}
