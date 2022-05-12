import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * [92431] 주차 요금 계산
 * https://programmers.co.kr/learn/courses/30/lessons/92341
 *
 * -아이디어
 * 1. 시간이 나오면 문제에서 나오는 최소 단위로 변환하고 시작.
 * 2. 정답은 TreeMap, 시간은 HashMap에 저장한다.
 * 3. 차 번호를 HashMap에 넣는데, 차 번호가 map에 있다면 누적 시간 = 출차 시간 - 입차 시간을 구하고 TreeMap에 저장한다.
 * 4. 출차를 했으니 HashMap에서 제거한다.
 * 5. records 배열을 다 돌았는데 HashMap에 남아 있다면 출차 시간을 23:59로 하고 누적 시간을 TreeMap에 넣는다.
 * 6. 누적 시간에 대해 단위 시간과 단위 요금, 기본 시간과 기본 요금을 계산해서 TreeMap에 다시 요금을 넣는다.
 * 
 */

public class Pro92341 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(solution(fees, records)));
    }

    public static Object[] solution(int[] fees, String[] records) {
        int[] answer = {};
        HashMap<String, Integer> hashMap = new HashMap<>();
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] input = records[i].split(" ");
            String time = input[0];
            String car = input[1];
            if (hashMap.containsKey(car)) {
                int outTime = convertToMin(time);
                int totalTime = outTime - hashMap.get(car);
                hashMap.remove(car);
                treeMap.put(car, treeMap.getOrDefault(car, 0) + totalTime);
            }
            else {
                int inTime = convertToMin(time);
                hashMap.put(car, inTime);
            }
        }

        if (!hashMap.isEmpty()) {
            int endTime = convertToMin("23:59");
            for (String car : hashMap.keySet()) {
                int inTime = hashMap.get(car);
                int totalTime = endTime - inTime;
                treeMap.put(car, treeMap.getOrDefault(car, 0) + totalTime);
            }
        }

        for (String key : treeMap.keySet()) {
            treeMap.put(key, calculate(fees, treeMap.get(key)));
        }

        System.out.println(treeMap.values());

        return treeMap.values().toArray();
    }

    private static int convertToMin(String time) {
        String[] input = time.split(":");
        int hour = Integer.parseInt(input[0]) * 60;
        return hour + Integer.parseInt(input[1]);
    }

    private static int calculate(int[] fees, int totalTime) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (totalTime > baseTime) {
            int overTime =  (int) Math.ceil((totalTime - baseTime) / (double) unitTime);
            return baseFee + overTime * unitFee;
        }
        else {
            return baseFee;
        }
    }
}
