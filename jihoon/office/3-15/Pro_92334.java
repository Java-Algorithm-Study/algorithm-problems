import java.util.*;

public class Pro_92334 {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Set<String> reportSet = new HashSet<String>();
        for (String rep : report)
            reportSet.add(rep);
        
        Map<String, ArrayList<String>> notifyListHash = new HashMap<>();
        for (String rep : reportSet) {
            String[] line = rep.split(" ");
            String reporter = line[0];
            String reportee = line[1];
            ArrayList<String> reporterList = notifyListHash.getOrDefault(reportee, null);
            
            if (reporterList == null) reporterList = new ArrayList<>();
            reporterList.add(reporter);
            notifyListHash.put(reportee, reporterList);
        }
        
        HashMap<String, Integer> reporterHash = new HashMap<>();
        for (ArrayList<String> notifyList : notifyListHash.values())
            if (notifyList.size() >= k)
                for (String reporter : notifyList)
                    reporterHash.put(reporter, reporterHash.getOrDefault(reporter, 0) + 1);
        
        for (int i = 0; i < id_list.length; i++)
            answer[i] = reporterHash.getOrDefault(id_list[i], 0);
        
        
        return answer;
    }
    
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        System.out.println(solution(id_list, report, 2));;
    }
}
