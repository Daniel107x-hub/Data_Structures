package designgurus.patterns.twoPointers;

public class DutchNationalFlagProblem {
    public static void main(String[] args) {
        int[] arr = {2, 2, 0, 1, 2, 0};
        for(int e : sort(arr)) System.out.print(e + " ");
    }

    public static int[] sort(int[] arr) {
        int left = 0;
        int right =  arr.length - 1;
        int curr = 0;
        while(curr <= right){
            if(arr[curr] == 1) curr++;
            else if(arr[curr] == 0) swap(arr, curr++, left++);
            else swap(arr, curr, right--);
            if(curr < left) curr = left;
        }
        return arr;
    }

    public static void swap(int[] arr, int p1, int p2){
        int tmp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = tmp;
    }
}
