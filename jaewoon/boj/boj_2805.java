package boj;

import java.io.*;
import java.util.*;

public class boj_2805 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        int tree_max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            tree_max = Math.max(tree_max, arr[i]);
        }

        if(m==0) {
            System.out.println(tree_max);
            return;
        }

        int max_h = 0;
        int left = 0, right = tree_max;
        int mid = tree_max/2;
        while(left<=right){
            long sum = cut_func(mid, arr);

            if(sum >= m){
                left = mid+1;
                max_h = Math.max(mid, max_h);
            }
            else{
                right = mid-1;
            }
            mid = (left+ right)/2;

        }

        System.out.println(max_h);
    }

    static long cut_func(int mid, int[] arr){
        long sum = 0;
        for(int i=0; i<arr.length; i++){
            if(mid<arr[i]) sum+= (arr[i]-mid);
        }
        return sum;
    }
}
