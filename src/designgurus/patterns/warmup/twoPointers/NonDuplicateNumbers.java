package designgurus.patterns.warmup.twoPointers;

public class NonDuplicateNumbers {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 11};
        System.out.println(moveElements(nums));
    }

    public static int moveElements(int[] arr) {
        if(arr.length < 2) return arr.length;
        int left = 0;
        int right = 1;
        while(right < arr.length){
            if(arr[left] != arr[right]) arr[++left] = arr[right];
            right++;
        }
        return left + 1;
    }
}
