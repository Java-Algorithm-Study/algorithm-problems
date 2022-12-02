package boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2621 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        char crr[] = new char[5];
        int arr[] = new int[5];

        for(int i=0; i<5; i++){
            String s = br.readLine();
            crr[i] = s.charAt(0);
            arr[i] = s.charAt(2)-'0';
        }

        for(int i=0; i<5; i++) tmp[arr[i]]++;
        sort = arr.clone(); Arrays.sort(sort);

        if(one(crr, arr));
        else if(two(crr, arr));
        else if(three(crr, arr));
        else if(four(crr, arr));
        else if(five(crr, arr));
        else if(six(crr, arr));
        else if(seven(crr, arr));
        else if(eight(crr, arr));
        else result = sort[4]+100;

        System.out.println(result);
    }

    static int[] tmp = new int[10];
    static int[] sort = new int[5];
    static int result = 0;
    static Boolean one(char crr[], int arr[]){
        for(int i=0; i<4; i++){
            if(crr[i] != crr[i+1] || sort[i+1] - sort[i] !=1 ) return false;
        }
        result = 900 + sort[4];
        return true;
    }
    static Boolean two(char crr[], int arr[]){
        for(int i=1; i<=9; i++){
            if(tmp[i]>=4){
                result = 800 + i;
                return true;
            }
        }
        return false;
    }
    static Boolean three(char crr[], int arr[]){
        int a = -1, b = -1;
        for(int i=1; i<=9; i++){
            if(tmp[i] == 3) a= i;
            if(tmp[i] == 2) b= i;
        }

        if(a!=-1 && b!=-1){
            result = a*10 + b + 700;
            return true;
        }
        return false;
    }

    static Boolean four(char crr[], int arr[]){
        for(int i=0; i<4; i++){
            if(crr[i] != crr[i+1]) return false;
        }
        result = sort[4] + 600;
        return true;
    }
    static Boolean five(char crr[], int arr[]){
        for(int i=0; i<4; i++){
            if(sort[i+1] - sort[i] !=1 ) return false;
        }
        result = sort[4] + 500;
        return true;
    }
    static Boolean six(char crr[], int arr[]){
        int a = -1;
        for(int i=1; i<=9; i++){
            if(tmp[i] >= 3) a= i;
        }
        if(a==-1) return false;
        result = 400 + a;
        return true;
    }
    static Boolean seven(char crr[], int arr[]){
        int a = -1, b = -1;
        for(int i=1; i<=9; i++){
            if(a==-1 && tmp[i]>=2){
                a= i;
            }
            else if(a!=-1 && tmp[i]>=2){
                b= i;
            }
        }
        if(a!=-1 && b!=-1){
            result = b*10 + a + 300;
            return true;
        }
        return false;
    }
    static Boolean eight(char crr[], int arr[]){
        for(int i=1; i<=9; i++){
            if(tmp[i]>=2){
                result = i + 200;
                return true;
            }
        }
        return false;
    }
}