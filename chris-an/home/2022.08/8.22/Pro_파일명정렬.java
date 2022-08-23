import java.util.*;

public class Pro_파일명정렬 {
    public String[] detachFileName (String s) {
        String head = "", number = "", tail = "";
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(Character.isDigit(c)) {
                number += c;
                flag = true;
            }else if (!Character.isDigit(c)){
                if(flag) {
                    idx = i;
                    break;
                }
                head += c;
            }
        }

        for (int i = idx; i < s.length(); i++) {
            sb.append(i);
        }

        tail = sb.toString();
        String[] files = {head.toLowerCase(), number, tail};

        return files;
    }

    public String[] solution(String[] files) {
        String[] answer = {};

        Arrays.sort(files, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String[] files1 = detachFileName(o1);
                String[] files2 = detachFileName(o2);

                if(files1[0].compareTo(files2[0]) == 0) {
                    int num1 = Integer.parseInt(files1[1]);
                    int num2 = Integer.parseInt(files2[1]);

                    return num1 - num2;
                }else {
                    return files1[0].compareTo(files2[0]);
                }
            }
        });

        return files;
    }
}