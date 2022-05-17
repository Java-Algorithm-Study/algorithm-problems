import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * [64065] 튜플
 * https://programmers.co.kr/learn/courses/30/lessons/64065
 *
 * -아이디어
 * 1. 입력이 "{{4,2,3},{3},{2,3,4,1},{2,3}}"인 경우에 사이즈 순서대로 정렬하면 "{{3},{2,3},{4,2,3},{2,3,4,1}}"이 된다.
 * 2. 정렬한 스트링을 기준으로 봤을 때, 사이즈가 작은 순서대로 새로 나온 값을 뽑아 보면 3 -> 2 -> 4 -> 1이라는 튜플임을 알 수 있다.
 * 3. String으로 들어온 입력을 { , }을 파싱하여 ArrayList<ArrayList<Integer>>에 넣어 준다.
 * 4. ArrayList<ArrayList<Integer>>에서 int[][]에 다시 넣어 준다.
 * 5. int[][]을 사이즈 순서로 정렬한다.
 * 6. 정렬한 2차원 배열을 HashMap에 key(배열의 인덱스) : value(해당 인덱스에서 새로 나온 숫자)로 넣는다.
 * 7. HashMap을 Key 순서로 출력한다.
 *
 */

public class Pro64065 {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        System.out.println(Arrays.toString(solution(s)));
    }

    public static int[] solution(String s) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

        int cnt = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '{') {
                cnt++;
            }
        }

        // 초기화
        for (int i = 0; i < cnt; i++) {
            arrayList.add(new ArrayList<>());
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '{') {
                continue;
            }
            else if (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
            else if (s.charAt(i) == ',') {
                if (sb.length() != 0) {
                    arrayList.get(idx).add(Integer.parseInt(String.valueOf(sb)));
                }
                sb = new StringBuilder();
            }
            else if (s.charAt(i) == '}') {
                arrayList.get(idx).add(Integer.parseInt(String.valueOf(sb)));
                sb = new StringBuilder();
                idx++;
            }
        }

        int[][] arr = new int[arrayList.size()][];

        for (int i = 0; i < arrayList.size(); i++) {
            arr[i] = new int[arrayList.get(i).size()];
            for (int j = 0; j < arrayList.get(i).size(); j++) {
                arr[i][j] = arrayList.get(i).get(j);
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                return arr1.length - arr2.length;
            }
        });

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (hashMap.containsValue(arr[i][j])) {
                    continue;
                }
                hashMap.put(i, arr[i][j]);
            }
        }

        int[] ans = new int[hashMap.size()];
        for (Integer k : hashMap.keySet()) {
            ans[k] = hashMap.get(k);
        }

        return ans;
    }
}

