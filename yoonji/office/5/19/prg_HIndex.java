import java.util.Arrays;
/* whiteboard
     h-index를 나타내는 h값을 구한다.
     논문 n편 중, h편 이상이 h번 이상 인용되었고, n편중 나머지 논문은 h번 이하 인용되었다면 그때의 최댓값 h가 H-INDEX임.
     논문 n개의 길이의 배열에 인용된 횟수가 값으로 담긴 citations 배열
     <3 0 6 1 5>
     1. 정렬 -> 0 1 3 5 6
     2. 반복문을 앞에서부터 돌면서 citations.length-i를 h로 함으로써, 해당 idx 값이 h번 이상 인용됐기만 하면
     h편 이상이 h개 이상 있는 것은 무조건임.
     0 1 3 5 6
     i   h  citation[i]
     0 5-0=5    0   => 0번 인용 >= 5 X : 5번 이상 인용
     1 5-1=4    1   => 1번 인용 >= 4 X :
     2 5-2=3    3   => 3번 인용 >= 3 O => 종료
     3 5-3=2    5   => 5번 인용 >= 2 O
 */
public class prg_HIndex {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}