class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefixFor = new int[len];
        int acc = 1;
        int[] ans = new int[len];
        int[] prefixRev = new int[len];

        for (int i = 0; i < len; i++) {
            acc = acc * nums[i];
            prefixFor[i] = acc;
        }
        acc = 1;

        for (int i = len - 1; i >= 0; i--) {
            acc = acc * nums[i];
            prefixRev[i] = acc; 
        }

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                ans[i] = prefixRev[1];
            } else if (i == (len - 1)) {
                ans[i] = prefixFor[len - 2];
            } else {
                ans[i] = prefixRev[i + 1] * prefixFor[i - 1];
            }
        }
        return ans;
    }
}  
