import java.util.*;

public class prg_주차요금계산 {
    private class ParkingInfo implements Comparable<ParkingInfo> {
        int carNum;
        boolean isIN;
        long totalFee;
        long totalTime;
        int hourOfLastINTime;
        int minuteOfLastINTime;
        ParkingInfo(int carNum, boolean isIN, int hourOfLastINTime, int minuteOfLastINTime, long totalFee) {
            this.carNum = carNum;
            this.isIN = isIN;
            this.hourOfLastINTime = hourOfLastINTime;
            this.minuteOfLastINTime = minuteOfLastINTime;
            this.totalTime = 0;
            this.totalFee = totalFee;
        }
        @Override
        public int compareTo(ParkingInfo p) {
            if (this.carNum < p.carNum) return -1;
            else return 1;
        }
    }
    public int[] solution(int[] fees, String[] records)  {
        Map<Integer, ParkingInfo> parkings = new HashMap<>();
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        // 1. 반복문을 돌며 정보를 넣는다.
        String[] recordsArr;
        for (int i=0; i<records.length; i++) {
            recordsArr = records[i].split(" ");
            int hour = Integer.parseInt(recordsArr[0].substring(0,2));
            int minute = Integer.parseInt(recordsArr[0].substring(3));
            int carNum = Integer.parseInt(recordsArr[1]);
            String inOut = recordsArr[2];
            if (parkings.containsKey(carNum)) {
                ParkingInfo p = parkings.get(carNum);
                checkParkingCarInfo(p, hour, minute, inOut);
            } else {
                parkings.put(carNum, new ParkingInfo(carNum, true, hour, minute, defaultFee));
            }
        }
        for (int car : parkings.keySet()) {
            ParkingInfo p = parkings.get(car);
            if (p.isIN) {
                p.totalTime += calculateTime(p.hourOfLastINTime, p.minuteOfLastINTime, 23, 59);// 마지막 시간 추가 정산
                p.isIN = false;
            }
            // 계산 부과!
            if (p.totalTime > defaultTime) {
                long overTime = p.totalTime - defaultTime;
                System.out.println(p.carNum+ "의 오바시간: "+overTime);
                p.totalFee += calculateOverFee(overTime, unitTime, unitFee);
            }
            System.out.println(p);
        }
        List<ParkingInfo> cars = new ArrayList<>(parkings.values());
        Collections.sort(cars);
        int[] answer = new int[cars.size()];
        for (int i=0; i<cars.size(); i++) {
            answer[i] = (int)cars.get(i).totalFee;
        }
        return answer;
    }

    /**
     * 입차 시간과 출차 시간을 비교하여 주차 시간을 계산합니다.
     * @param h1
     * @param m1
     * @param h2
     * @param m2
     * @return
     */
    private long calculateTime(int h1, int m1, int h2, int m2) {
        int hour = h2-h1;
        int minute = 0;
        if (m2==0 && hour==1) hour = 0;
        if (m1>m2) {
            minute = 60-m1 + m2;
            if (hour!=0) hour--;    // 추가.
        }
        else minute = m2-m1;
        return hour * 60 + minute;
    }

    /**
     * 추가요금을 계산합니다.
     * @param overTime
     * @param unitTime
     * @param unitFee
     * @return
     */
    private long calculateOverFee(long overTime, int unitTime, int unitFee) {
        if ((double)overTime % unitTime != 0) {
            overTime = overTime / unitTime +1;
        } else {
            overTime /= unitTime;
            System.out.println(overTime);
        }
        return overTime * unitFee;
    }

    /**
     * ParkingInfo 클래스의 인스턴스 상태를 변경합니다.
     * @param p
     * @param hour
     * @param minute
     * @param inOut
     */
    private void checkParkingCarInfo(ParkingInfo p, int hour, int minute, String inOut) {
        System.out.println(p.hourOfLastINTime);
        if ("IN".equals(inOut)) {
            p.isIN = true;
            p.hourOfLastINTime = hour;
            p.minuteOfLastINTime = minute;
        } else {
            System.out.println(p.isIN);
            p.isIN = false;
            p.totalTime += calculateTime(p.hourOfLastINTime, p.minuteOfLastINTime, hour, minute);
            System.out.println(p.totalTime);
        }
    }

    public static void main(String[] args)  {
        prg_주차요금계산 t = new prg_주차요금계산();
//        int[] solution = t.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        int[] solution = t.solution(new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:34 5961 OUT", "07:34 5961 IN", "08:34 5961 OUT", "09:34 5961 IN", "10:34 5961 OUT", "11:34 5961 IN", "12:34 5961 OUT"});
        for (int s: solution) System.out.println(s);

    }
}
