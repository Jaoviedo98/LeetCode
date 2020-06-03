/**
 * Calculates the max water level given an array of integers, each integer is a wall
 * Max water level is the maximum area between two walls
 */
class WaterLevel {

    /**
     * Used to test both methods
     * @param args arguments for when using command line
     */
    public static void main (String[] args) {
        System.out.println(maxArea(new int[] {1, 2, 3, 4, 5, 6, 8}));
        System.out.println(maxArea2(new int[] {1, 2, 3, 4, 5, 6, 8}));
    }

    /**
     * First attempt brute force O(n2)
     * @param height an array of integers to calculate max area on
     * @return the max area an Integer
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        for ( int i = left; i < right; i++) {
            for (int j = right; j > i; j--) {
                int min = Integer.min(height[i], height[j]);
                int difference = j - i;
                int tempMax = min * difference;
                if (maxWater < tempMax ) {
                    maxWater = tempMax;
                }
            }
        }
        return maxWater;
    }

    /**
     * Second attempt, double pointer O(n)
     * @param height an array of integers to calculate max area on
     * @return the max area, an Integer
     */
    public static int maxArea2 (int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLevel = 0;
        while (left < right) {
            int min = Integer.min(height[left], height[right]);
            int difference = right - left;
            maxLevel = Integer.max(maxLevel, difference * min);
            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return maxLevel;
    }
}