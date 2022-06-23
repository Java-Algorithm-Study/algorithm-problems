import java.util.ArrayList;
import java.util.Collections;

/**
 * [43164] 여행 경로
 * https://programmers.co.kr/learn/courses/30/lessons/43164
 *
 */

public class Pro43164 {
    private static String[][] ticket;
    private static boolean[] visited;
    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        solution(tickets);
    }

    public static String[] solution(String[][] tickets) {
        ticket = tickets;
        visited = new boolean[tickets.length];

        dfs("ICN", "ICN", 0);
        Collections.sort(list);
        String[] answer = list.get(0).split(" ");    //가장 빠른 배열을 뽑아서 String형 배열로 만듬
        return answer;
    }
    
    public static void dfs(String start, String route, int depth) {
        if (depth == ticket.length) {
            list.add(route);
            return;
        }

        for (int i = 0; i < ticket.length; i++) {
            if (!visited[i] && ticket[i][0].equals(start)) {
                visited[i] = true;
                dfs(ticket[i][1], route + " " + ticket[i][1], depth + 1);
                visited[i] = false;
            }
        }
    }
}
