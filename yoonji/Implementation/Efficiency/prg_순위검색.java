package Implementation.Efficiency;
import java.util.*;

// info배열 크기 <=50,000
// 개발언어 직군(front,back) 경력 소울푸드 점수(십만 이하)
// query배열 크기 <=십만
public class prg_순위검색 {
    Map<String, ArrayList<Integer>> infoMap = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // 1. info dfs로 돌면서 나오는 경우의 수들을 map에 넣는다. (key는 하나의 String, value는 해당하는 코테 점수)
        for (String i: info) {
            String[] aInfo = i.split(" ");
            int testScore = Integer.parseInt(aInfo[4]);
            makeCase_dfs(0, aInfo, testScore, "");
        }

        // 1-1. 코테 점수들 정렬
        for (String key: infoMap.keySet()) Collections.sort(infoMap.get(key));

        // 2. query 돌면서 key에 해당하는 value들을 돌면서 코테점수 이상인 갯수 구한다.
        for (int i=0; i<query.length; i++) {
            String line = query[i].replace(" and ", "");
            int limitScore = Integer.parseInt(line.split(" ")[1]);
            String q = line.split(" ")[0];
            if (infoMap.containsKey(q)) {
                ArrayList<Integer> scores = infoMap.get(q);
                answer[i] = searchCnt_binary(scores, limitScore);

                /* 효율성 TC3,4 불통
                for (int j=0; j<scores.size(); j++) {
                     if (scores.get(j) >= limitScore) {
                         // System.out.println(limitScore+"이상인: "+ scores.size()+"중에서 "+ (scores.size() - j));
                         answer[i] = scores.size() - j;
                         break;
                     }
                 }*/
            }
        }
        return answer;
    }
    private void makeCase_dfs(int depth, String[] info, int score, String str) {
        if (depth == 4) {
            if (!infoMap.containsKey(str)) {
                infoMap.put(str, new ArrayList<>());
            }
            infoMap.get(str).add(score);
            return;
        }
        makeCase_dfs(depth+1, info, score, str+info[depth]);
        makeCase_dfs(depth+1, info, score, str+"-");
    }

    private int searchCnt_binary(List<Integer> scores, int limitScore) {
        int left = 0;
        int right = scores.size()-1;
        int mid;
        while (left <= right) {
            mid = (left+right)/2;
            if (scores.get(mid) < limitScore) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        // 같거나 커서 left를 mid+1로 옮기고 cross가 됐다면 그 값이 정답.
        return scores.size() - left;
    }
}