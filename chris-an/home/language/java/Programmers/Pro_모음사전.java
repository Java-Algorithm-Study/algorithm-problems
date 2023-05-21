package language.java.Programmers;

public class Pro_모음사전 {
    String[] alphaDict = {"A", "E", "I", "O", "U"};
    int answer = 0;
    int count = 0;

    public int solution(String word) {
        dfs(new StringBuilder(), word);
        return answer;
    }

    public void dfs(StringBuilder cur, String word){
        // base case 1
        if(word.equals(cur.toString())) {
            answer = count;
            return;
        }
        // base case 2
        if(cur.length() == 5) return;

        // recur case
        for(int i = 0; i < 5; i++) {
            count++;
            cur.append(alphaDict[i]);
            dfs(cur, word);
            cur.setLength(cur.length() - 1);
        }
    }
}