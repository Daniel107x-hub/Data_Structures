package leetcode;

public class PartitionArrayIntoTwoEqualProductSubsets {
    public static void main(String[] args) {

    }

    public static boolean checkEqualPartitions(int[] nums, long target){
        long product = 1;
        for (int num : nums) {
            product *= num;
        }
        return product == target * target && subsetWithProductExists(0, 1, nums, target);
    }

    public static boolean subsetWithProductExists(int position, long product, int[] nums, long target){
        if(product == target) return true;
        if(position >= nums.length) return false;
        return subsetWithProductExists(position + 1, product * nums[position], nums, target)
                || subsetWithProductExists(position + 1, product, nums, target);
    }
}
