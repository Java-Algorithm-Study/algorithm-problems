public class prg_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n]; // 0으로 초기화
        int arrLength = arr.length;
        int answer = 0;
        // lost배열의 값 위치에 -1, reserve배열의 값 위치에 +1
        for (int i=0; i<lost.length; i++) {
            arr[lost[i]-1] -=1;
        }
        for (int i=0; i<reserve.length; i++)
            arr[reserve[i]-1] +=1;

        // arr 돌면서 0인 자리를 앞뒤 확인
        for (int i=0; i<arrLength; i++) {
            if (arr[i] == -1) {
                if (i != 0 && arr[i-1] == 1) {    //앞확인
                    arr[i] +=1;
                    arr[i-1] -=1;
                    answer++;
                } else if (i!= arrLength-1 && arr[i+1] == 1) { // 뒤확인 (맨 뒤 숫자일 인경우 제외)
                    arr[i] +=1;
                    arr[i+1] -=1;
                    answer++;
                }
            }
            else answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        prg_체육복 t = new prg_체육복();
        System.out.println(t.solution(5, new int[]{2,4}, new int[]{1,3,5}));
    }
}
