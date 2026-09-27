class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];
        int len = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (int i = 0; i < len; i++) {
            int val = map.getOrDefault(nums[i], 0);
            map.put(nums[i], val + 1);
        }

        maxHeap.addAll(map.entrySet());

        for (int i = 0; i < k; i++) {
            answer[i] = (maxHeap.poll().getKey());
        }
        return answer;
    }
}
