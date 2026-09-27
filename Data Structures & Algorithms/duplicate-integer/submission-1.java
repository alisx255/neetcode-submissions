class Solution {
    public boolean hasDuplicate(int[] nums) {
        boolean isNotDupe = true;
        Set<Integer> newSet = new HashSet<>();
        for (int i : nums) {
            isNotDupe = newSet.add(i);
            if (!isNotDupe) {
                return true;
            }

        }
        return false;
        
    }
}