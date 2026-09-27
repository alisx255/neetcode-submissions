class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            int threshold = target - numbers[l];
            if (numbers[r] == threshold) {
                int[] ans = {l + 1, r + 1};
                return ans;
            }
            else if (numbers[r] > threshold) {
                r--;
            }
            else {
                l++;
            }

        }
        return numbers;
        
    }
}
