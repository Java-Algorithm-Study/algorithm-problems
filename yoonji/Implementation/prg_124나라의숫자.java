package Implementation;
// 손으로 적어본 결과, 규칙
// 1. 0으로 나누어 떨어질 때는 '4'가 나타나야하므로, 순서를 {4,1,2}로 정한다.
// 2. 124로 변환할 때 중간에 나머지가 0이 되면, n을 1개 줄여야한다.
public class prg_124나라의숫자 {
    public String solution(int n) {
        int[] nums = {4, 1, 2};
//        if (n==1) return "1";
        StringBuilder sb = new StringBuilder();
        while (n!=0) {
            int remain = n%3;
            n/=3;
            sb.append(nums[remain]);
            if (remain==0) {
                n--;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        prg_124나라의숫자 k = new prg_124나라의숫자();
        System.out.println(k.solution(6));  // 14
    }
}