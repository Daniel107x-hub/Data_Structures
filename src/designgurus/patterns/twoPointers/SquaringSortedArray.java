package designgurus.patterns.twoPointers;

/**
 * Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.
 */
public class SquaringSortedArray {
    public static void main(String[] args) {
        int[] input = {-4, -2, -1, 0, 2, 3, 6};
        for(int num : makeSquares(input)){
            System.out.print(num + " ");
        }
    }

    public static int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int left = 0;
        int right = arr.length - 1;
        for(int curr = arr.length - 1 ; curr >= 0 ; curr--){
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if(leftSquare > rightSquare){
                squares[curr] = leftSquare;
                left++;
            }
            else{
                squares[curr] = rightSquare;
                right--;
            }
        }
        return squares;
    }
}
