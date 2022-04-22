import java.util.ArrayList;
import java.util.Collections;

public class Pro_여행경로 {

    private static String[][] ticket;
    private static ArrayList<String> list = new ArrayList<>();
    private static boolean[] visited;

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

    public static String[] solution(String[][] tickets) {
        ticket = tickets;
        visited = new boolean[tickets.length];
        dfs("ICN",  "ICN", 0);

        Collections.sort(list);

        return list.get(0).split(" ");
    }

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(solution(tickets));
    }
}