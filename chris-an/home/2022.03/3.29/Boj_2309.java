import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2309 {
    static int ROOF = 9;
    static int HEIGHT = 100;
    static int dwarfMaxCnt = 7;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] arr = new int[ROOF];

        // 먼저 arr 에 싹 담아서 세팅해줍니다.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> list = new LinkedList<>();
        int sum;
        boolean flag = false; // for 문 break 제어장치
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                // 매번 아래의 List 와 sum 은 초기화 해줍니다.
                sum = 0;
                list.clear();
                for (int k = 0; k < arr.length; k++) {
                    if (k == i || k == j) continue;
                    sum += arr[k];
                    list.add(arr[k]);
                    if (sum == HEIGHT && list.size() == dwarfMaxCnt) {
                        flag = true; // 100이 됐을 시, for 문을 싹 빠져나오기 위함.
                        break;
                    }
                }
                if (flag) break;
            }
            if (flag) break;
        }
        // List 정렬
        Collections.sort(list);

        // 값을 하나 씩 출력합니다.
        for (int i : list) {
            System.out.println(i);
        }
    }
}
