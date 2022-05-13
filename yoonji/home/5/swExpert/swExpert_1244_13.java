package swExpert;

import java.io.*;
import java.util.Arrays;

//최대 상금
public class swExpert_1244_13 {
    static int changeLimit;
    static int maxMoney;
    static int[] nums;
//    static String str="";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t<=T; t++) {
            String[] line = br.readLine().split(" ");
            changeLimit = Integer.parseInt(line[1]);
            String num = line[0];
            nums = new int[num.length()];
            for (int i=0; i<num.length(); i++) {
                nums[i] = Integer.parseInt(num.substring(i,i+1));
            }
            // dfs로 모든 경우의 수 구해서 max값 얻기
            maxMoney = 0;
            dfs(0, 0);
            bw.write("#" + t + " " + maxMoney); bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

            /* 처음 시도한 코드 : 한 값과 그 뒤의 값들 중 max값을 바꿔나가기 -> 32888 같은 경우의 최댓값을 구하지 못함.. 일단 모든 경우의 수를 구해야함. => dfs
            // changeCnt만큼 숫자 교환하기
            for (int i=0; i<nums.length-1; i++) {
                if (changeCnt>=changeLimit) {
                    String str = Arrays.toString(nums).replaceAll("[^0-9]","");
                    System.out.println("#" + t + " " + str);
                    break;
                }
                int max = nums[i];
                int maxIdx = 0;
                for (int target = i+1; target<nums.length; target++) {
                    if (max <= nums[target]) {
                        max = nums[target];
                        maxIdx = target;
                    }
                }
                if (nums[i] <= max && i != maxIdx) {
                    int tmp = nums[i];
                    nums[i] = max;
                    nums[maxIdx] = tmp;
                    changeCnt++;
                }
            }*/
    }

    private static void dfs(int idx, int changeCnt) {
        if (changeCnt == changeLimit) {
            // max 비교
//            str = "";
//            Arrays.stream(nums).forEach(n -> str += String.valueOf(n));
            String str = Arrays.toString(nums).replaceAll("[^0-9]",""); // int[] -> String

            maxMoney = Math.max(maxMoney, Integer.parseInt(str));
            return;
        }
        // 해당 index 뒤의 값들과 모두 비교
        for (int i=idx; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] <= nums[j]) {
                    swap(i, j);
                    dfs(i, changeCnt+1);    // swap된 배열에서 다시 i부터 교환해서 모든 경우를 봄..
                    swap(i, j);
                }
            }
        }
    }
    private static void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
