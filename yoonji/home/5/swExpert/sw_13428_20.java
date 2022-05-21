package swExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 숫자조작
/* whiteboard
 0~99999999까지의 정수 N (long)
 숫자 한쌍을 골라서 자리를 0번,1번 바꾼 새 수 M (맨 앞은 0이 되면 안된다.)
 최솟값, 최댓값을 구해라.
 최댓값은 가장 큰값이 0번째가 아니면 바꾸면 끝.
     이미 가장 큰값이 0번 째이면 두번째 큰 값을 찾는다. 두번째 큰값도 이미 두번째 자리면 세번째.. ex) 52431 -> 54231
 최솟값은 가장 작은 값이 0번째이면, (작은 값을 찾을 때 0은 제외한다.)
     그다음 작은 값을 두번째 자리와 바꾼다.

 조건1. 0은 바꿀 수 없다.
 조건2. 큰값과 작은 값을
 199 -> 991 최댓값이 같다면, 가장 뒤에 있는 최댓값으로
 919 -> 첫번째가 이미 최댓값이면, 두번째 값과 최댓값을 바꾼다.
 */
public class sw_13428_20 {
    static char[] charArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int t=1; t<=T; t++) {
            String N = br.readLine();
            int num = Integer.parseInt(N);
            charArr = N.toCharArray();
            int min = num, max = num;
            for (int i=0; i<charArr.length-1; i++) {
                for (int j=i+1;j< charArr.length; j++) {
                    // 교환
                    swap(i, j);
                    // min, max 구하기
                    if (charArr[0]== '0') {
                        swap(i, j);
                        continue;
                    }
                    int currNum = Integer.parseInt(String.valueOf(charArr));
                    min = Math.min(min, currNum);
                    max = Math.max(max, currNum);
                    swap(i, j);
                }
            }
            /*
            for (int i=0; i<N.length(); i++) {
                nArr[i] = strToInt(N.substring(i, i+1));
            }
            String min = findMinimum(nArr);  // String을 넘겨서 조작하면, 그 값이 원본에 영향을 미친다..
            String max = findMaximum(nArr);*/
            answer.append("#" + t + " ").append(min).append(" ").append(max).append("\n");
        }
        System.out.println(answer);
    }
    private static void swap(int i, int j) {
        char tmp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = tmp;
    }
    // my first try
    private static String findMinimum(int[] arr) {
        int min = 9;
        int minIdx = -1;
        // min을 찾는다. 뒤에있을 수록 바꿨을 시 min이 됨
        // 20001 -> 10002
        for (int i=0; i< arr.length; i++) {
            if (arr[i]<= min && arr[i] != 0) {  // 919
                min = arr[i];
                minIdx = i;
            }
        }
        System.out.println(minIdx+"의 "+min);

        // 교환
        // 첫번째 값보다 작은 min이 없으면 교환X
        // 12142 -> 11242
        // 12324 -> 13224 -> 12234
        for (int i=0; i<arr.length; i++) {
            if (arr[i]  > min && minIdx != i) {    //11000 -> 12000
                int tmp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = tmp;
                break;
            }
        }
        return Arrays.toString(arr).replaceAll("[^0-9]","");
    }
    private static String findMaximum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        // max를 찾는다.// 2009
        for (int i=0; i< arr.length; i++) {
            if (arr[i] >= max) {  // 919
                max = arr[i];
                maxIdx = i;
            }
        }
        System.out.println(maxIdx+"의 "+max);
        // 교환
        // 최댓값은 앞에서부터 가다가 최댓값보다 작은 값과 교환.  54912  -> 94512,  1000-> 0100 (X)
        // 52345
        for (int i=0; i<arr.length; i++) {
            if (arr[i] < max && maxIdx != i && arr[i]!=0) {
                int tmp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = tmp;
                break;
            }
        }
        return Arrays.toString(arr).replaceAll("[^0-9]","");
    }

    private static int strToInt(String str) { return Integer.parseInt(str); }
}
