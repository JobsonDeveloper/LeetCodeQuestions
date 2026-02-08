package Sum_Of_Two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.youtube.com/watch?v=1G5oHL1jvRc

public class Code {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        System.out.println("List: " + Arrays.toString(nums));
        System.out.println("Objective: " + target);
        System.out.println("Numbers of index: " + Arrays.toString(result) + " = " + target);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] output = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                output[0] = map.get(nums[i]);
                output[1] = i;
                return  output;
            }

            map.put(target - nums[i], i);
        }

        return null;
    }
}
