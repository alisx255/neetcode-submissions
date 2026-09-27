class Solution:
    def maxArea(self, heights: List[int]) -> int:
        n = len(heights)
        maxVol = 0
        left = 0
        right = n - 1
        width = right - left
        height = min(heights[left], heights[right])
        maxArea = width * height
        while left < right:
            if heights[left] <= heights[right]:
                left = left + 1
            else:
                right = right - 1
            testMaxArea = (right - left) * min(heights[left], heights[right])
            if testMaxArea > maxArea:
                maxArea = testMaxArea
        return maxArea

        