package mentorias.week1;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        merge(nums1, 0, nums2, 1);
        for(int e : nums1) System.out.print(e + " ");
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int max = nums1.length - 1;
        m--;
        n--;
        while(m >= 0 && n >= 0){
            if(nums1[m] > nums2[n]) nums1[max--] = nums1[m--];
            else nums1[max--] = nums2[n--];
        }
        while(m >= 0) nums1[max--] = nums1[m--];
        while(n >= 0) nums1[max--] = nums2[n--];
    }
}
