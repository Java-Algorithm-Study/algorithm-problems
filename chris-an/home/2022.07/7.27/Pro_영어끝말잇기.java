import java.util.*;
public class Pro_영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> wordList = new HashSet<>();
        String previousWord = words[0];
        wordList.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            boolean check = previousWord.charAt(previousWord.length()-1) != words[i].charAt(0);
            if(check || wordList.contains(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            wordList.add(words[i]);
            previousWord = words[i];
        }

        return answer;
    }
}
