package designgurus.arrays;

public class HighestAltitude {
    public static void main(String[] args) {
        int[] gain = {-5, 1, 5, 0, -7};
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int maxAltitude = 0; // To store the maximum altitude encountered
        int sum = 0;
        for(int num : gain){
            sum += num;
            maxAltitude = Math.max(sum, maxAltitude);
        }
        return maxAltitude;
    }
}
