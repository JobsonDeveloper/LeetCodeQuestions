package Top_K_Frequent_Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Code {
    public static void main(String[] args) {
        int[] list_one = new int[]{1,1,1,2,2,3};
        int[] list_two = new int[]{1};
        int[] list_three = new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2};

        System.out.println("Test One: " + Arrays.toString(topKFrequent(list_one, 2)));
        System.out.println("Test Two: " + Arrays.toString(topKFrequent(list_two, 1)));
        System.out.println("Test Three: " + Arrays.toString(topKFrequent(list_three, 2)));

        System.out.println("---- Expected ----");

        System.out.println("Test One: [1,2]");
        System.out.println("Test Two: [1]");
        System.out.println("Test Three: [1,2]");
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        int[] result = new int[k];
        int index = 0;

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            buckets[freq].add(num);
        }

        for (int freq = buckets.length - 1; freq >= 0 && index < k; freq--) {
            for (int num : buckets[freq]) {
                result[index++] = num;
                if (index == k) {
                    break;
                }
            }
        }

        return result;
    }
}
