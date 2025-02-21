package designgurus.patterns.twoPointers;

import java.util.ArrayList;
import java.util.List;

public class SubarraysWithProductLessThanTargetGeneration {
    public static void main(String[] args) {
        int[] arr = {8, 2, 6, 5};
        for(List<Integer> subarray : findSubarrays(arr, 50)){
            for(Integer element: subarray) System.out.print(element + " ");
            System.out.println();
        }
    }


    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int product = 1;
        int left = 0;
        for(int right = 0 ; right < arr.length ; right++){
            product *= arr[right];
            while(product >= target && left <= right){
                product /= arr[left];
                left++;
            }
            List<Integer> subarray = new ArrayList<>();
            for(int i = right ; i >= left ; i--){
                subarray.add(0, arr[i]);
                result.add(List.copyOf(subarray));
            }
        }
        return result;
    }

}
