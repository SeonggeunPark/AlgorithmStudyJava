import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] operators = new char[25];
		int op_cnt = 0;
		
		int[] nums = new int[25];
		int num_cnt = 0;
		
		String str = "";
		int sum = 0;
		char[] input = br.readLine().toCharArray();
		for (int i=0; i<input.length; i++) {
			char c = input[i];
			
			if (c == '+') {
				sum += Integer.valueOf(str);
				str = "";
			} else if (c == '-') {
				sum += Integer.valueOf(str);
				nums[num_cnt++] = sum;
				str = "";
				sum = 0;
			}
			else {
				str += c;
				if (i == input.length-1) {
					sum += Integer.valueOf(str);
					nums[num_cnt++] = sum;
				}
			}
		}
		
		int ans = nums[0];
		for (int i=1; i<nums.length ; i++) {
			ans -= nums[i];
		}
		System.out.println(ans);
		
	}
}
