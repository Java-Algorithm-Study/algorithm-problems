package yeonsup.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaxDistanceInArrays {
    
    int getMax(List<Integer> minList, List<Integer> maxList) {
        List<Integer> minTemp = minList.stream().map(v -> v).collect(Collectors.toList());
        int max = -10001;
        int index = 0;
        
        for (int i = 0; i < maxList.size(); i++) {
            if(maxList.get(i) > max) {
                max = maxList.get(i);
                index = i;
            }
        }

        minTemp.remove(index);
        
        return max - minTemp.stream().mapToInt(v -> v).min().getAsInt();
    }
    
    int getMin(List<Integer> minList, List<Integer> maxList) {
        List<Integer> maxTemp = maxList.stream().map(v -> v).collect(Collectors.toList());
        int min = 10001;
        int index = 0;
        for (int i = 0; i < minList.size(); i++) {
            if(minList.get(i) < min) {
                min = minList.get(i);
                index = i;
            }
        }

        maxTemp.remove(index);

        return maxTemp.stream().mapToInt(v -> v).max().getAsInt() - min;
    }

    public int maxDistance(List<List<Integer>> arrays) {
        int result = 0;
        
        List<Integer> minList = arrays.stream().map(v -> v.get(0)).collect(Collectors.toList());
        List<Integer> maxList = arrays.stream().map(v -> v.get(v.size() - 1)).collect(Collectors.toList());
        
        int min = getMin(minList, maxList);
        int max = getMax(minList, maxList);


        return Math.max(min, max);
    }
//public int maxDistance(List<List<Integer>> arrays) {
//        int result = 0;
//        for (int i = 0; i < arrays.size() - 1; i++) {
//            int index = i;
//            int a = 10001, b = -10001;
//            int min, max;
//            for (int j = i + 1; j < arrays.size(); j++) {
//                if(arrays.get(j).get(0) < a) {
//                    a = arrays.get(j).get(0);
//                }
//                if(arrays.get(j).get(arrays.get(j).size() - 1) > b) {
//                    b = arrays.get(j).get(arrays.get(j).size() - 1);
//                }
//            }
//
//            min = b - arrays.get(i).get(0);
//            max = arrays.get(i).get(arrays.get(i).size() - 1) - a;
//
//            if(result < Math.max(min, max)) {
//                result =  Math.max(min, max);
//            }
//
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        int result = new MaxDistanceInArrays().maxDistance(new ArrayList<List<Integer>>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(-2)),
                new ArrayList<Integer>(Arrays.asList(-3, -2, 1))
        )));
//        int result = new MaxDistanceInArrays().maxDistance(new ArrayList<List<Integer>>(Arrays.asList(
//                new ArrayList<Integer>(Arrays.asList(1, 4)),
//                new ArrayList<Integer>(Arrays.asList(0, 5))
//        )));

//        int result = new MaxDistanceInArrays().maxDistance(new ArrayList<List<Integer>>(Arrays.asList(
//                new ArrayList<Integer>(Arrays.asList(1)),
//                new ArrayList<Integer>(Arrays.asList(2))
//        )));

        System.out.println(result);
    }
}
