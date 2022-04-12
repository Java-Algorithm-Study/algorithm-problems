import java.util.*;

public class prg_뉴스클러스터링 {
    public void makeCouple(String str, List<String> list) {
        for (int i = 0; i < str.length() - 1; i++) {
            if(Character.isAlphabetic(str.charAt(i)) && Character.isAlphabetic(str.charAt(i+1)))
                list.add(str.substring(i, i + 2));
        }
    }

    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        List<String> A = new ArrayList<>();
        List<String> B = new ArrayList<>();

        makeCouple(str1, A);
        makeCouple(str2, B);
        int interAB = 0;
        for (int i = 0; i < A.size(); i++) {
            if (B.contains(A.get(i))) {
                interAB++;
                B.remove(A.get(i));
            }
        }
        // 교집합만 0일때는 0 리턴이므로 아래 코드 X
        //if (interAB == 0) return 65536;
        int unionAB = A.size() + B.size();
        // 교집합,합집합이 모두 0일 때만 1 리턴
        if (unionAB == 0) return 65536;
        return (int) ((double) interAB / unionAB * 65536);
    }
}