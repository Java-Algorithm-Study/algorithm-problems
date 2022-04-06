class prg_키패드누르기 {
    // 1. 초기화
    int[][] numPosition = {
            {3,1}, //0
            {0,0}, //1
            {0,1}, //2
            {0,2}, //3
            {1,0}, //4
            {1,1}, //5
            {1,2}, //6
            {2,0}, //7
            {2,1}, //8
            {2,2}  //9
    };
    int[] lPointer = {3,0};
    int[] rPointer = {3,2};
    StringBuilder sb = new StringBuilder();

    public String solution(int[] numbers, String hand) {
        // 2. numbers만큼 돌면서 left, middle, right에 따라 로직 타기
        for (int i=0; i<numbers.length;i++) {
            //2-1. 0인 경우
            if(numbers[i]==0) doMiddleCase(numPosition[0], hand);
            else if (numbers[i]%3 == 1) moveFinger(numPosition[numbers[i]], "L");   // 왼쪽
            else if (numbers[i]%3 == 0) moveFinger(numPosition[numbers[i]], "R");   // 오른쪽
            else doMiddleCase(numPosition[numbers[i]], hand);    // 나머지가 2이면 중앙
        }
        // 3. 반환
        return sb.toString();
    }

    // 중간 키패드 수일 때의 로직을 처리한다.
    public void doMiddleCase(int[] numPosition, String hand) {
        // 1. 거리 구한다.
        int distFromL = Math.abs(numPosition[0] - lPointer[0])+ Math.abs(numPosition[1]-lPointer[1]);
        int disteFromR = Math.abs(numPosition[0] - rPointer[0])+ Math.abs(numPosition[1]-rPointer[1]);
        // 2. 거리에 따른 LR 추가
        if ( distFromL > disteFromR) moveFinger(numPosition, "R");
        else if (distFromL < disteFromR) moveFinger(numPosition, "L");
        else {
            if ("right".equals(hand)) moveFinger(numPosition, "R");
            else moveFinger(numPosition, "L");
        }
    }
    // 손가락의 위치를 이동시키며 답에 추가한다. (수정)
    public void moveFinger(int[] touchedNumPos, String finger) {
        if ("L".equals(finger)) lPointer= touchedNumPos;
        else rPointer = touchedNumPos;
        sb.append(finger);
    }

    public static void main(String[] args) {
        prg_키패드누르기 t = new prg_키패드누르기();
        String ans = t.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
        System.out.println(ans);
        System.out.println("LRLLRRLLLRR".equals(ans));
    }
}