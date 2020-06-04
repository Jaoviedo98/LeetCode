import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class threeSum {
    public static void main (String[] args) {
        System.out.println(threeSum(new int[] {-1,0,1,2,-1,-4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> main = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1;
                int right = nums.length - 1;
                int sum = 0 - nums[i];
                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        main.add(temp);
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;

                    } else if (nums[left] + nums[right] > sum) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return main;
    }
}
