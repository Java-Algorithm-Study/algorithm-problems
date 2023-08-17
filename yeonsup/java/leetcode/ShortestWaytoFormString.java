package leetcode;

import java.util.Arrays;

public class ShortestWaytoFormString {

//    boolean[] check;
//    int K;
//    int n;
//    String[] num;
//    String getStr(String[] arr, int size, String target) {
//        int result = 0;
//        K = size < arr.length ? size : arr.length;
//        n = arr.length;
//        check = new boolean[n];
//        num = arr;
//
//        return back(0, 0, target);
//    }
//
//    String back(int dp, int start, String target) {
//        if (dp == K) {
//            String s = "";
//            for (int i = 0 ; i < n; i++){
//                if(check[i]){
//                    s += num[i];
//                }
//            }
//            if (target.contains(s)) {
//                return s;
//            } else {
//                return "";
//            }
//        }
//
//        for(int i = start; i < n; i++) {
//            check[i] = true;
//            String s = back(dp + 1,i + 1, target);
//            if (s.length() > 0) {
//                return s;
//            } else {
//                check[i] = false;
//            }
//        }
//        return "";
//    }//f()
//
//    public int shortestWay(String source, String target) {
//        int cnt = 0;
//        int i = source.length();
//
//        String[] validStr = target.split("");
//        for (int j = 0; j < validStr.length; j++) {
//            if(!source.contains(validStr[j])) {
//                return -1;
//            }
//        }
//
//        while (target.length() > 0) {
//            String s = getStr(source.split(""), i, target);
//            System.out.println("s = " + s);
//            if (s.length() > 0) {
//                int length = target.length();
//                target = target.replace(s, "");
//                cnt += (length - target.length()) / s.length();
//                i = target.length();
//            } else {
//                i--;
//            }
//
//        }
//
//        return cnt;
//    }
    public int shortestWay(String source, String target) {
        int t = 0;
        int ans = 0;
        while (t < target.length()) {
            int pt = t;

            for (int s = 0; s < source.length(); s++) {

                if (t < target.length() && source.charAt(s) == target.charAt(t)) {
                    System.out.print(source.charAt(s) + " ");
                    System.out.print(target.charAt(t) + ", ");
                    t++;
                }
            }

            if (t == pt) {
                return -1;
            }
            System.out.println();
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new ShortestWaytoFormString().shortestWay("xyz", "xzyxz"));
//        System.out.println(new ShortestWaytoFormString().shortestWay("abc", "abcbc"));
        System.out.println(new ShortestWaytoFormString().shortestWay("adbsc", "addddddddddddsbc"));
        // addddddddddddsbc -> dddddddddddsbc -> ddddddddddbc -> ddddddddd
        //  ad              -> ds              -> dbc           -> ddddddddd
        //  adddddddddd
        // addddddddddddsbc -> dddddddddddsbc -> sbc ->
//        System.out.println(new ShortestWaytoFormString().shortestWay("abc", "acdbc"));
    }
}
