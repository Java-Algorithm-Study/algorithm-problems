package Implementation;

// 노란색&갈색 격자 개수 기억, 전체 카펫 객수 기억 X
// 가로, 세로 크기를 리턴.
// brown (8~5000), yellow (1~2백만)
// 가로는 세로보다 길거나 같다.
// 전체 타일 갯수는 brown+yellow
// 전체타일 갯수에서 나눠떨어지는 값에서 w, h 구하기
//  - 조건 : 세로<=가로, 세로>=3
// 예) 12개
//   h    w
//   3    4
//   2    6   (세로는 3보다 커야 brown이 yellow 감싸)
// h,w 와 brown, yellow 관계
// brown = w*2+(h-2)*2
// yellow = 전체 - brown
public class prg_카펫 {
    public static int[] solution(int brown, int yellow) {
        int tileTotalCnt = brown+yellow;
        int[] array = new int[2];
        for (int h=3; h<= tileTotalCnt/3; h++) {
            int w = tileTotalCnt/h;
            if (tileTotalCnt%h == 0 && w>=h) {
                if (brown == w*2 + (h-2)*2 && yellow == tileTotalCnt-brown) {
                    array[0] = w;
                    array[1] = h;
                    break;
                }
            }
        }
        return array;
    }
}