package geek.problem.diameterbinarytree;

import java.util.Arrays;

public class SumTwo {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{3, 15, 2, 6, 7}, 10);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    // Low Memory complexity
    public static int[] twoSum(int[] nums, int targetSum) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while (start != end) {
            int sum = nums[start] + nums[end];
            if (sum == targetSum)
                return new int[]{nums[start], nums[end]};
            else if (sum > targetSum)
                end--;
            else
                start++;
        }

        return new int[0];
    }
}
