class WaterLevel {
    public int maxArea(int[] height) {
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
}