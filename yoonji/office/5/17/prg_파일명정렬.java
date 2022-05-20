import java.util.*;
public class prg_파일명정렬 {
    static public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                boolean isFindHead = false;
                // 초기화
                String[] headNumOfStr1 = new String[2];
                String[] headNumOfStr2 = new String[2];
                headNumOfStr1 = getHeadAndNum(s1);
                headNumOfStr2 = getHeadAndNum(s2);
                int num1 = Integer.parseInt(headNumOfStr1[1]);
                int num2 = Integer.parseInt(headNumOfStr2[1]);
                // 비교
                int headCompareResult = headNumOfStr1[0].compareToIgnoreCase(headNumOfStr2[0]);
                if (headCompareResult == 0) {
                    // number
                    if (num1 == num2) {
                        return 0;
                    } else {
                        return num1 - num2;
                    }
                } else {
                    return headCompareResult;
                }
            }
        });
        System.out.println(Arrays.toString(files));
        return files;
    }

    private static String[] getHeadAndNum(String str) {
        boolean isFindHead = false;
        String head = "";
        String num = null;
        int startNum = 0;

        for (int i = 0; i < str.length(); i++) {
            if (!isFindHead) {
                if (Character.isDigit(str.charAt(i))) {
                    head = str.substring(0, i);
                    isFindHead = true;
                    startNum = i;
                }
            } else {
                if (!Character.isDigit(str.charAt(i))) {
                    num = str.substring(startNum, i);
                    break;
                }
            }
        }
        if (num == null) {
            num = str.substring(startNum);
        }
        return new String[]{head, num};
    }
}