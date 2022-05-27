import java.util.HashSet;
import java.util.Set;

public class Pro_영어끝말잇기 {
    static public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> wordStack = new HashSet<>();
        int idx = 0;
        wordStack.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            //1 반복되서 나왔니?
            if (wordStack.contains(words[i])) {
                idx = i;
                break;
            }
            if (words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
                idx = i;
                break;
            }
            wordStack.add(words[i]);
        }
        if (idx == 0) System.out.println(answer);
        else {
            answer[0] = (idx % n) + 1; // 번호
            answer[1] = (idx / n) + 1; // 차례
        }

        return answer;
    }
    public static void main(String[] args) {
        String[] str1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int n1 = 3;
        String[] str2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        int n2 = 5;
        String[] str3 = {"hello", "one", "even", "never", "now", "world", "draw"};
        int n3 = 2;

        System.out.println(solution(n3 ,str3));
    }
}
