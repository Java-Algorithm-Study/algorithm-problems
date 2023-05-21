package language.java.Programmers;

public class Pro_86491 {
    public int solution(int[][] sizes) {
        int w, h;
        int wMax = Integer.MIN_VALUE;
        int hMax = Integer.MIN_VALUE;
        for (int i = 0; i < sizes.length; i++) {
            w = sizes[i][0];
            h = sizes[i][1];
            if(h > w) {
                int temp = w;
                w = h;
                h = temp;
            }
            wMax = Math.max(w, wMax);
            hMax = Math.max(h, hMax);
        }
        return wMax * hMax;
    }
}
