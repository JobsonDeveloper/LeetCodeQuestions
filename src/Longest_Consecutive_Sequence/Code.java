package Longest_Consecutive_Sequence;

import java.util.*;
import java.util.stream.Collectors;

public class Code {
    public static void main(String[] args) {
        int[] list_one = new int[]{100,4,200,1,3,2};
        int[] list_two = new int[]{0,3,7,2,5,8,4,6,0,1};
        int[] list_three = new int[]{1,0,1,2};

        System.out.println("Test One result: " + longestConsecutive(list_one));
        System.out.println("Test Two result: " + longestConsecutive(list_two));
        System.out.println("Test Three result: " + longestConsecutive(list_three));

        System.out.println("---- Spected ----");

        System.out.println("Test One: 4");
        System.out.println("Test Two: 9");
        System.out.println("Test Three: 3");
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> num_set = Arrays.stream(nums)
                .boxed().collect(Collectors.toSet());
        Integer longest_streck = 0;
        Integer current_num;
        Integer current_streak;

        for (int num : num_set) {
            if(!num_set.contains(num - 1)) {
                current_num = num;
                current_streak = 1;

                while(num_set.contains(current_num + 1)) {
                    current_num++;
                    current_streak++;
                }

                longest_streck = longest_streck > current_streak ? longest_streck : current_streak;
            }
        }

        return longest_streck;
    }
}
