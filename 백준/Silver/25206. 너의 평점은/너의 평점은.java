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

import org.w3c.dom.Node;

public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double cntPoint = 0;	// 평점 총합
		double sumTotal = 0; // 과목평졈*학점 총합
		for (int i=0; i<20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String subject = st.nextToken();	// 과목명
			double point = Double.parseDouble(st.nextToken());	// 학점
			char[] grade = st.nextToken().toCharArray();	// 등급
			
			// 과목 수 카운트
			if (grade[0]!='P') {
				cntPoint += point;
				sumTotal += point * convertToNum(grade);
			}
		}
		
		System.out.println(sumTotal / cntPoint);
		
	}
	private static double convertToNum(char[] grade) {
		double result = 69 - grade[0];
		
		if (result < 0) return 0;
		result += (double)(48-grade[1]) / 10;
		return result;
	}
}
