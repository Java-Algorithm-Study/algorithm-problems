import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

// 나이순 정렬
// map 이용 (인덱스, 나이)
/* hashTable : hashMap과 구조가 비슷하지만 용도가 다름.
 - 키와 값이 1:1 형태
 - 동기화가 이루어짐. (멀티 스레드 환경이 아니라면 성능이 더 떨어짐)
 - value에 null입력 불가능
 - 보조해시 함수를 사용하지 않아 상대적으로 해시충돌 발생가능성 높음
 - HashMap에 비해 개선속도 떨어짐 (초기에 나왔던 자료구조)
*/
public class boj_10814_23 {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] names = new String[N];
        for (int i=0; i<N; i++) {
            String line = br.readLine();
            map.put(i, Integer.parseInt(line.split(" ")[0]));
            names[i] = line.split(" ")[1];
        }
        System.out.println(map);
        // Map.Entry : Map 형식의 데이터 (key, value)에 대해 처리가 필요할 때 사용
        List<Entry<Integer, Integer>> entryList = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
        entryList.sort(new Comparator<Entry<Integer, Integer>>() {
            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                if (o1.getValue() > o2.getValue()) return 1;    // 전자가 크면 swap
                else if (o1.getValue() < o2.getValue()) return -1;
                else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });
        // 출력
        StringBuilder sb = new StringBuilder();
        for (Entry<Integer,Integer> entry: entryList) {
            sb.append(entry.getValue()).append(" ").append(names[entry.getKey()]).append("\n");
        }
        System.out.println(sb);
    }
}