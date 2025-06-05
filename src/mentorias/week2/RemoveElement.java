package mentorias.week2;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        System.out.println(removeElement(nums, 3));
        System.out.println("Bye!");
    }

    public static int removeElement(int[] nums, int val){
        if(nums.length < 1) return 0;
        int lastDistinct = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != val) nums[lastDistinct++] = nums[i];
        }
        return lastDistinct;
    }
}
