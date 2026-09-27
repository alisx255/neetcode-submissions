class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        length = len(nums)
        triplets = []
        nums.sort()
        left = 0
        p = 1
        right = length - 1
        for i in range(length - 2):
            if nums[i] > 0:
                break
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            left, right = i + 1, length - 1
            while left < right:
                tsum = nums[i] + nums[left] + nums[right]
                if tsum < 0:
                    left = left + 1
                if tsum > 0:
                    right = right - 1
                if tsum == 0:
                    triplets.append([nums[left], nums[i], nums[right]])
                    left = left + 1
                    right = right - 1
                    while left < right and nums[left] == nums[left - 1]:
                        left += 1
                    while left < right and nums[right] == nums[right + 1]:
                        right -= 1
        return triplets

              