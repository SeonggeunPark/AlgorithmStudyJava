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
		
		int[] count = new int[26];
		
		String input = br.readLine();
		for (int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			// 대문자일 때
			if (c < 97) {
				count[c-65] += 1;
			}
			// 소문자일 때
			else {
				count[c-97] += 1;
			}
		}
		int max = 0;
		int maxIdx = -1;
		boolean isOne = true;
		for (int i=0; i<=25; i++) {
			if (max < count[i]) {
				max = count[i];
				maxIdx = i;
				isOne = true;
			} else if (max == count[i]) {
				isOne = false;
			}
		}
		
		System.out.println(isOne ? (char)(maxIdx+65) : '?');
	}
}
