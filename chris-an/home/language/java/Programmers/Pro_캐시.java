package language.java.Programmers;

import java.util.LinkedList;
import java.util.List;

public class Pro_캐시 {

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize==0) return cities.length * 5;

        int time = 0;
        List<String> caches = new LinkedList<>();

        for (int i=0; i<cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (caches.remove(city)) {
                time+=1;
                caches.add(city);
            } else {
                time+=5;
                if (caches.size() >= cacheSize) caches.remove(0);

                caches.add(city);
            }
        }
        return time;
    }


    public static void main(String[] args) {
        String[] str1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int in1 = 3;
        String[] str2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        int in2 = 3;
        String[] str3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        int in3 = 2;
        String[] str4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        int in4 = 5;
        String[] str5 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int in5 = 0;
        // System.out.println(solution(in2, str2));
    }
}
