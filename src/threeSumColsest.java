import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSumColsest {
    public static void main (String[] args) {
        System.out.println(threeSumClosest(new int[] {-1,0,1,2,-1,-4}, 4));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minimum = Integer.MAX_VALUE;
        int minimumVal = nms[1];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int current = nums[i];
            while (left < right) {
                int sum = nums[left] + nums[right] + current;
                if (sum == target) {
                    return target;
                }
                else if (sum > target) {
                    right--;
                    if (target >= 0 && Math.abs(sum - target) < minimum) {
                        minimumVal = sum;
                    }
                    else if (target < 0 && Math.abs(target - sum) < minimum) {
                        minimumVal = sum;
                    }
                }
                else if (sum < target) {
                    left++;
                    if (target >= 0 && Math.abs(sum - target) < minimum) {
                        minimumVal = sum;
                    }
                    else if (target < 0 && Math.abs(target - sum) < minimum) {
                        minimumVal = sum;
                    }
                }
            }
        }
        return minimumVal;
    }
}
