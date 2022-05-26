import java.util.*;
public class prg_영어끝말잇기 {
    public int[] solution (int n, String[] words) {
        Set<String> wordSet = new HashSet<>();
        int[] answer = new int[2];
        int endChar = words[0].charAt(words[0].length() - 1);
        wordSet.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (endChar != words[i].charAt(0) || wordSet.contains(words[i])) {
                int personNum = (i % n) + 1;
                int turnCnt = (i / n) +1;
                answer[0] = personNum;
                answer[1] = turnCnt;
                break;
            }
            wordSet.add(words[i]);
            endChar = words[i].charAt(words[i].length() - 1);
        }
        return answer;
    }
    // 검사
    // 이전에 나온 단어인가?
    // 이전 단어의 마지막 문자로 시작하는가?
    // => if 탈락) 자신의 번호와 차례번호 지정.
    // n번째면, 1로 넘겨야함.
    // 1로 다시 리셋하면서, 차례 번호+1
    public int[] myFirstSolution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> talkedWords = new ArrayList<>();
        talkedWords.add(words[0]);
        int currNum = 1;
        int turnCnt = 1;
        char beforeChar = words[0].charAt(words[0].length()-1);
        for (int i=1; i<words.length; i++) {
            currNum++;
            if (currNum > n) {
                currNum=1;
                turnCnt++;
            }
            String currWord = words[i];
            if (talkedWords.contains(currWord) || beforeChar != currWord.charAt(0)) {
                answer[0] = currNum;
                answer[1] = turnCnt;
                break;
            }
            else {
                talkedWords.add(currWord);
                beforeChar = currWord.charAt(currWord.length()-1);
            }
        }
        return answer;
    }
}