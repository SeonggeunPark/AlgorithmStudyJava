import java.io.*;
import java.util.*;

public class Main {
	static int[] A, B, C, D;
	static int N;
	static long ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        C = new int[N];
        D = new int[N];

        	for (int i=0; i<N; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		A[i] = Integer.parseInt(st.nextToken());
        		B[i] = Integer.parseInt(st.nextToken());
        		C[i] = Integer.parseInt(st.nextToken());
        		D[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	int[] AB = new int[N*N];
        	int[] CD = new int[N*N];
        	int aIdx = 0, bIdx = 0;
        	for (int i=0; i<N; i++) {
        		for (int j=0; j<N; j++) {
        			int sumA = A[i]+B[j];
        			int sumB = C[i]+D[j];
        			AB[aIdx++]=sumA;
        			CD[bIdx++]=sumB;
        		}
        	}
        	
        	Arrays.sort(AB);
        	Arrays.sort(CD);
        	int l = 0;
        	int r = CD.length-1;
        	
        	while (l<AB.length && r >=0) {
        		int lVal = AB[l];
        		int rVal = CD[r];
        		long sum = (long) lVal+rVal;
        		if (sum==0) {
        			// 중복 탐색
        			long cntA = 0;
        			long cntC = 0;
        			while (l<AB.length && AB[l] == lVal) {
        				l+=1;
        				cntA+=1;
        			}
        			while (r>=0 && CD[r] == rVal) {
        				r-=1;
        				cntC+=1;
        			}
        			ans += (long)cntA*cntC;
        		} else if (sum>0) {
        			r-=1;
        		} else {
        			l+=1;
        		}
        	}
        	
        	
        	System.out.println(ans);
    }
}
