class Solution {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        int max = 0;
        HashMap<Integer, int[]> prefixFreq = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int n = nums[i];
            int[] pmax = {n, n};
            int[] less = {n, n};
            int[] more = {n, n};
            if (prefixFreq.containsKey(n+1)) {
                more = prefixFreq.get(n+1);
                System.out.println("more: " + (n+1));
            }
            if (prefixFreq.containsKey(n-1)) {
                less = prefixFreq.get(n-1);
                System.out.println("less: " + (n-1));

            }
            pmax[0] = less[0];
            pmax[1] = more[1];
            

            prefixFreq.put(n, pmax);
            prefixFreq.put(less[0], pmax);
            prefixFreq.put(more[1], pmax);

            int amax = pmax[1] - pmax[0] + 1;
            if (amax > max) {
                max = amax;
            }
            System.out.println(less[0] + "," + more[1]);
            System.out.println(pmax[0] + " " + pmax[1]);
        }
        return max;
    }
}
