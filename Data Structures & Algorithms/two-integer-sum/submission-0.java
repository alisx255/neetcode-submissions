class Solution {
    public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> numsMap = new HashMap<>();
    int length = nums.length;
    int[] answer = new int[2];
    for (int i = 0; i < length; i++) {
        numsMap.put(nums[i], i);
    }
    for (int i = 0; i < length; i++) {
        int c = target - nums[i];
        if (numsMap.containsKey(c)){
            int g = (numsMap.get(c));
            if (g == i) {
                continue;
            }
            if (g < i){
                answer[0] = g;
                answer[1] = i;
                break;
                
            }
            else {
                answer[1] = g;
                answer[0] = i;
                break;
                
            }
            
        }
        
    }
    return answer;
    }
}
