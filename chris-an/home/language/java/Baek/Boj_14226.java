package language.java.Baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Emoji {
    int sec;
    int copiedClipBoard;
    int currEmojiCnt;

    public Emoji(int sec, int copiedClipBoard, int currEmojiCnt) {
        this.sec = sec;
        this.copiedClipBoard = copiedClipBoard;
        this.currEmojiCnt = currEmojiCnt;
    }
}

public class Boj_14226 {
    static boolean[][] visited = new boolean[1_001][1_001];
    static final int limit = 1_001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        Queue<Emoji> qu = new LinkedList<>();
        qu.offer(new Emoji(0, 0, 1));
        int min = 0;
        visited[0][1] = true;

        while (!qu.isEmpty()) {
            Emoji cur = qu.poll();

            // 1초가 흐르면서, 현재 이모지를 저장!
            qu.offer(new Emoji(cur.sec + 1, cur.currEmojiCnt, cur.currEmojiCnt));

            if (cur.copiedClipBoard > 0 && cur.currEmojiCnt + cur.copiedClipBoard < limit && !visited[cur.copiedClipBoard][cur.currEmojiCnt + cur.copiedClipBoard]) {
                // 1초가 흐르면서, 한 번 저장시킨 클립보드에 있는 이모지 정보를 현재에 붙혀넣기.
                qu.offer(new Emoji(cur.sec + 1, cur.copiedClipBoard, cur.currEmojiCnt + cur.copiedClipBoard));
                visited[cur.copiedClipBoard][cur.currEmojiCnt + cur.copiedClipBoard] = true;
            }

            if (cur.currEmojiCnt > 0 && cur.copiedClipBoard > 0 && !visited[cur.copiedClipBoard][cur.currEmojiCnt - 1] && cur.currEmojiCnt >= cur.sec) {
                // 1초가 흐르면서, 이모티콘 갯수 -1
                qu.offer(new Emoji(cur.sec + 1, cur.copiedClipBoard, cur.currEmojiCnt - 1));
                visited[cur.copiedClipBoard][cur.currEmojiCnt - 1] = true;
            }

            if (cur.copiedClipBoard + cur.currEmojiCnt == input) {
                min = cur.sec + 1;
                break;
            }
        }
        System.out.println(min);
    }
}














