package designgurus.patterns.warmup.twoPointers;
import java.util.*;

public class TripletSumZero {
    public static void main(String[] args) {
        int[] arr = {-5, 2, -1, -2, 3};
        for(List<Integer> triplet : searchTriplets(arr)){
            for(int num: triplet) System.out.print(num + " ");
            System.out.println();
        }
    }

    public static List<List<Integer>> searchTriplets(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        if(arr.length < 3) return result;
        int i = 0;
        while(i < arr.length){
            int current = arr[i];
            int left = i + 1;
            int right = arr.length - 1;
            int target = -current;
            while(left < right){
                int sum = arr[left] + arr[right];
                if(sum == target){
                    result.add(Arrays.asList(current, arr[left++], arr[right--]));
                    while(arr[left] == arr[left - 1] && left < right) left++;
                    while(arr[right] == arr[right + 1] && right > left) right--;
                }
                else if(sum < target) left++;
                else right--;
            }
            i++;
            while(i < arr.length && arr[i] == arr[i - 1]) i++;
        }
        return result;
    }
}
