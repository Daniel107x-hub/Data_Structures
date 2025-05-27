package mentorias.week1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[][] tests = {
                {2, 7, 11, 15},
                {3, 2, 4},
                {3, 3}
        };
        int[] targets = {
                9,
                6,
                6
        };
        for(int i = 0 ; i < tests.length ; i++){
            int[] result = twoSum(tests[i], targets[i]);
            System.out.println(tests[i][result[0]] + " + " + tests[i][result[1]]);
        }
    }

    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> elements = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0 ; i < nums.length ; i++){
            int search = target - nums[i];
            int index = elements.getOrDefault(search, -1);
            if(index != -1 && index != i) return new int[]{i, index};
            elements.put(nums[i], i);
        }
        return result;
    }
}
