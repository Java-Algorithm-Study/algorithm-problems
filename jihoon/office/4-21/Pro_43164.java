import java.util.*;

public class Pro_43164 {
    private static Map<String, ArrayList<String>> list = new HashMap<>();
    private static Set<String> visited = new HashSet<>();
    
    public static void dfs(String root) {
        visited.add(root);
//        else visited.remove(root);
        
        System.out.println(root);
        for (String child : list.get(root)) {
            if (list.get(child).contains(root)) {
                dfs(child);
                return;
            }
            if (visited.contains(child)) continue;
            dfs(child);
        }
    }
    
    public static String[] solution(String[][] tickets) {
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            ArrayList<String> child = list.getOrDefault(from, new ArrayList<>());
            child.add(to);
            
            list.put(from, child);
        }
    
        for (var node : list.keySet()) {
            Collections.sort(list.get(node));
        }
        
//        System.out.println(list);
        dfs("ICN");
        String[] answer = {};
        return answer;
    }
    
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(solution(tickets));
    }
}
