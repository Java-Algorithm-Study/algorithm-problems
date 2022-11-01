import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [43163] 단어 변환
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 *
 * -아이디어
 * 1. target이 words에 없으면 return 0
 * 2. 타켓 찾기는 BFS
 * 3. 첫 시작: begin과 words를 한 글자씩 비교해서 위치 같은 단어가 length() - 1개 있으면 변환 가능 -> 큐에 넣고, visited 처리
 * 4. 큐 돌면서 큐에 있는 단어랑 변환 가능한 단어 있는지 한 글자씩 비교
 * 5. 있다면 count + 1 하고 큐에 넣는다
 * 6. 큐에서 나온 단어가 target과 같다면 Math.min으로 비교
 *
 */
 
public class Pro43163 {
    public static void main(String[] args) {
    }

    static class Word{
        String word;
        int count;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    private static int min = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        // 1. target이 words에 없으면 return 0
        if (!Arrays.asList(words).contains(target)) {
            return answer;
        }

        // 2. target 찾기
        bfs(begin, target, words);

        return min;
    }

    private static void bfs(String begin, String target, String[] arr) {
        Queue<Word> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];

        char[] be = begin.toCharArray();

        // 1. arr에서 한 글자 바꿀 단어 있는지 찾고
        for (int i = 0; i < arr.length; i++) {
            // 1-1. 한 글자씩 비교해서 변환 가능하면 큐에 넣기
            if (canChange(begin, arr[i])) {
                visited[i] = true;
                q.add(new Word(arr[i], 1));
            }
        }

        // 2. 큐 돌림 
        while (!q.isEmpty()) {
            // 3. 단어를 큐에서 빼고
            Word now = q.poll();

            // 6. target 찾으면 Math.min으로 비교해서 저장.
            if (target.equals(now.word)) {
                min = Math.min(min, now.count);
            }


            // 4. 큐에서 글자 비교
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    continue;
                }

                // 4-1. 그 단어가 arr 단어 중에서 한 글자 바꿀 단어가 있는지 찾음.
                // 4-2. 있으면 큐에 넣고, visited 체크
                if (canChange(now.word, arr[i])) {
                    q.add(new Word(arr[i], now.count + 1));
                    visited[i] = true;
                }
            }
        }
    }

    private static boolean canChange(String origin, String target) {
        int length = origin.length();

        for (int i = 0; i < origin.length(); i++) {
            if (origin.charAt(i) == target.charAt(i)) {
                length--;
            }
        }

        if(length == 1) {
            return true;
        }

        return false;
    }
}
