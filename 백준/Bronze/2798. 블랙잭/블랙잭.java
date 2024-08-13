import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int card[] = new int[N];
        for(int i=0;i<N;i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for(int i=0;i<N-2;i++){
            for(int j=i+1;j<N-1;j++){
                for(int z=j+1;z<N;z++){
                    int x = card[i]+card[j]+card[z];
                    if(x<=M){
                        max = Math.max(max,x);
                    }
                }
            }
        }
        System.out.println(max);
    }
}