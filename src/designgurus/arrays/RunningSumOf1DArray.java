package designgurus.arrays;

public class RunningSumOf1DArray {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 5, 1, 6};
        for(int num : runningSum(numbers)){
            System.out.print(num + ",");
        }
    }

    public static int[] runningSum(int[] numbers){
        int[] result = new int[numbers.length];
        result[0] = numbers[0];
        for(int i = 1 ; i < numbers.length ; i++){
            result[i] = result[i - 1] + numbers[i];
        }
        return result;
    }
}
