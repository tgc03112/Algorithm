package BOJ1806_부분합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main2 {	//정올2216
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
         
        int[] arr = new int[N];
         
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
         
        while(end<N) {
            if(sum>=S) {
                sum = sum - arr[start++];
                res = Math.min(res, (end-start)+1);
            }
            else {
                sum = sum + arr[end++];
            }
        }
        if(res==Integer.MAX_VALUE)
            res=0;
        System.out.println(res);
    }
}