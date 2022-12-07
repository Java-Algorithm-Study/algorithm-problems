package boj;

import java.util.*;
import java.io.*;

public class boj_2003 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int result = 0;
        int sum = arr[0];
        int s = 0, e = 0;
        while(e<n){
            if(sum <= m){
                if(sum==m) result++;
                if(e+1>=n) break;
                sum += arr[++e];
            }
            else{
                sum -= arr[s++];
            }
        }
        System.out.println(result);

    }

}
