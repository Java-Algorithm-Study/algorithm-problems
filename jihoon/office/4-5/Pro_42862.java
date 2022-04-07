import java.util.Arrays;

public class Pro_42862 {
    
    public static int solution(int n, int[] lost, int[] reserve) {
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int answer = n - lost.length;
    
        // 여벌 체육복을 가져온 학생이 도난 당한 경우, 자기 체육복을 입히고 0으로 만들어 제거한다
        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if (reserve[i] == lost[j]) {
                    answer++;
                    reserve[i] = 0;
                    lost[j] = 0;
                }
            }
        }
        
        // 여분 체육복을 가져온 학생들이 얼마나 많은 학생들에게 빌려줄 수 있는지 조사한다
        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if (lost[j] == 0 || reserve[i] == 0) continue;
                if (reserve[i] == lost[j] - 1 || reserve[i] == lost[j] || reserve[i] == lost[j] + 1) {
                    answer++;
                    reserve[i] = 0;
                    lost[j] = 0;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
    
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {3}; // 정답 5

        System.out.println(solution(n, lost, reserve));
    }
}
