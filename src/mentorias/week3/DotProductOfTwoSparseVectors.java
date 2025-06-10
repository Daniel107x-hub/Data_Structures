package mentorias.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DotProductOfTwoSparseVectors {
    public static void main(String[] args) {

    }

    static class SparseVector {
        int size;
        Map<Integer, Integer> values = new HashMap<>();
        SparseVector(int[] nums) {
            this.size = nums.length;
            for(int i = 0 ; i < size ; i++){
                if(nums[i] == 0) continue;
                values.put(i, nums[i]);
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            if(this.size != vec.size) return Integer.MIN_VALUE;
            int result = 0;
            for(int key : values.keySet()){
                if(!vec.values.containsKey(key)) continue;
                result += this.values.get(key) * vec.values.get(key);
            }
            return result;
        }
    }
}


