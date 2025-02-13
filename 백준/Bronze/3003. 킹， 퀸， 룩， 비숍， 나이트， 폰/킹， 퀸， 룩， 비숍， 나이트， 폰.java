import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = {1, 1, 2, 2, 2, 8};
		
		for (int i=0; i<6; i++) {
			System.out.print(arr[i]-sc.nextByte()+" ");
		}
		
	}
}
