import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
class prg_실패율 {
    class Failure {
        int stage;
        float failureRate;
        Failure(int stage, float failureRate) {
            this.stage = stage;
            this.failureRate = failureRate;
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] arr = new int[N + 1];  // from 1
        for (int i = 0; i < stages.length; i++) {
            if (stages[i] > N) continue;
            arr[stages[i]] += 1;    //arr[stages[i]]++ 가능
        }
        int length = stages.length;
        List<Failure> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            Failure f = new Failure(i, (float)arr[i] / length);
            list.add(f);
            length -= arr[i];
        }
        Comparator<Failure> cp = new Comparator<Failure>() {    // 람다로도 가능
            @Override
            public int compare(Failure f1, Failure f2) {
                if(f1.failureRate > f2.failureRate) {
                    return -1;
                }else if (f1.failureRate < f2.failureRate){
                    return 1;
                }else {
                    return 0;
                }
                // return (int)(f1.failureRate - f2.failureRate); // 음수,양수가 리턴인데 0.xx이므로 int변환 시 0을 리턴
            }
        };
        Collections.sort(list, cp);
        int [] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i).stage;
        }
        return ans;
    }
}