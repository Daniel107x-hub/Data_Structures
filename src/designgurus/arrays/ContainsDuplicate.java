package designgurus.arrays;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums){
        // We first validate if the array has elements and more than 1 element
        if (nums == null || nums.length <= 1 ) return false;
        // If it has more than one, we compare one by one

        // We initialize 2 pointers, one for the first element and another one at the second
        int left = 0;
        int right = left + 1;
        // We will move the first pointer on a cycle, and the right pointer on a nested cycle
        // As the right pointer will be used to compare each element to the current item in the
        // left pointer
        while(left < nums.length - 1){
            while(right < nums.length){
                // If at any point, left and right point to a number with the same value, we found a duplicate
                if(nums[left] == nums[right]) return true;
                // If not, we move to the next element with the right pointer until we have
                // covered all remaining items
                right++;
            }
            // After we cover all items after the left pointer with the right pointer, we move
            // the left pointer and initialize the right again in the next element to the left
            // pointer
            left++;
            right = left + 1;
        }
        // If at the end, the function has not returned yet, it means there are no duplicates
        return false;
    }
}
