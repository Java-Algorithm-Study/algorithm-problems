public class Pro_84512 {
    /*
        두 가지 방법에 대해서 고민
        1. 미리 알파벳 모음을 초기화해놓는다.
        2. 입력 값이 나올 때까지만 재귀 돌고 breakpoint 부분을 구현하여 빠져나온다.

        재귀 루프를 돌면서, 사전순으로 인풋값 조합을 만든 뒤,
        입력값(word)랑 일치할 시에 count에 값을 담아 놓는다.
    */

    private static String[] vowels = {"A","E","I","O","U"};
    private static int count;
    private static boolean flag;

    public static void dfs(String target, String word) {
        // 입력값을 찾을 경우, break 가동
        if (word.equals(target)) {
            flag = true;
            return;
        }
        // 모음 갯수 5개까지
        if (target.length() == 5) return;

        for (int i = 0; i < vowels.length; i++) {
            count++;
            dfs(target + vowels[i], word);

            if(flag) break;
        }
    }

    public int solution(String word) {
        dfs("", word);

        return count;
    }
}
