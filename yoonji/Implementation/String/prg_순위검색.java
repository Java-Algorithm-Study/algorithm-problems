package Implementation.String;

import java.util.*;

// 지원자들의 지원 조건 선택 => 해당 조건에 맞는 지원자 인원수
// 조건 + 코테 점수 X점 이상
// 각 문의조건에 해당하는 사람들의 숫자를 순서대로 배열로 리턴
// 배열 길이 50000
// info : 언어 직군 경력 소울푸드 코테점수(1~100000)
// query 길이 100000이하
// query: 조건 and 조건 and 조건 and 조건 점수
// 조건이 -이면 고려X ex) cpp and - and senior and pizza 500
/*
- 기존 아이디어 (10초이상 시간초과)
1. 리스트에 Class로 넣고 코테점수기준으로 정렬
2. 점수 기준 정렬된 클래스에 대해 query 돌면서 조건에 해당(이상의 점수)하는 지원자 인원수 구하기
- 새 아이디어 (dfs)
++ dfs에서 '-'의 경우의 수도 추가하는 이유 : query에서 '-'는 해당 조건은 고려하지 않겠다는 의미이므로, '-'를 포함한 모든 경우의 수를 구해야한다.
쿼리의 조건과 같은 경우를 찾을 base == info 배열 이용해서 dfs로 모든 경우의 수를 구해놓는다. (있거나 없거나(-))
1. dfs로 info 돌면서 경우(4개:lang, pos, career, food)를 구해놓고, 이에 해당하는 코테점수를 value로 가지는 Map에 pt
2. query돌면서 해당하는 게 Map의 key로 있으면 그 key의 value의 코테점수들과 비교한다.
 */
public class prg_순위검색 {
    private static Map<String, ArrayList<Integer>> applicantInfoMap = new HashMap<>();
    private static String[] applicantInfo = new String[5];
    private static String[] emptyArr;
    private static Integer testScore =0;
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        // 1. 모든 info에 대해 dfs로 경우의 수를구한다.
        for(String i: info) {
            emptyArr = new String[4];
            applicantInfo = i.split(" ");
            testScore = Integer.parseInt(applicantInfo[4]);
            getApplicantInfoCase_dfs(0);    // depth는 4개
        }

        for (String str: applicantInfoMap.keySet()) {
//            System.out.println("탐색 키: "+ str);
            Collections.sort(applicantInfoMap.get(str));
        }

        // 2. query 돌면서 해당 info가 key에 있는지 확인
        for (int i=0; i<query.length; i++) {
            String[] infoOfQuery = query[i].split(" and ");
            int limitScore = Integer.parseInt(infoOfQuery[3].split(" ")[1]);
            infoOfQuery[3] = infoOfQuery[3].split(" ")[0];
            String strInfoOfQuery = infoOfQuery[0] + infoOfQuery[1] + infoOfQuery[2] + infoOfQuery[3];

            // TODO: 2022-06-27 왜 전체 map에 대해 value를 먼저 Sorting해야되?? query에 해당하는 것만 sorting하는게 더 적은 수 아닌가?
            if (applicantInfoMap.containsKey(strInfoOfQuery)) {
//                System.out.print("key= "+ strInfoOfQuery+": ");
                ArrayList<Integer> scores = applicantInfoMap.get(strInfoOfQuery);

//                Collections.sort(scores);

                answer[i] = scores.size() - searchScoreEqualOrGreaterThanLimitscore(scores, limitScore);
            }
        }
        return answer;
    }

    private int searchScoreEqualOrGreaterThanLimitscore(ArrayList<Integer> scores, int limit) {
        int left = 0;
        int right = scores.size()-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (scores.get(mid) < limit) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        // 같거나 클 때 right가 왼쪽으로 이동하고, 그 후에 left, right가 교차한거면 left가 정답.
        return left;
    }

    private void getApplicantInfoCase_dfs(int depth) {
        if (depth == 4) {
            String applicantInfoStr = String.join("", emptyArr);
            if (!applicantInfoMap.containsKey(applicantInfoStr)) applicantInfoMap.put(applicantInfoStr, new ArrayList<>());
            applicantInfoMap.get(applicantInfoStr).add(testScore);

            return;
        }
        emptyArr[depth] = applicantInfo[depth];
        getApplicantInfoCase_dfs(depth+1);
        emptyArr[depth] = "-";  // 고려하지 않는 경우도 체크해줘야하므로
        getApplicantInfoCase_dfs(depth+1);
    }

    public static void main(String[] args) {
        prg_순위검색 t = new prg_순위검색();
        int[] solution = t.solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"});
        System.out.println(Arrays.toString(solution));
    }
}