class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        left = 0
        right = n - 1
        hLeft = height[left]
        hRight = height[right]
        h = min(hLeft, hRight)
        vol = 0
        while left < right:
            h = min(hLeft, hRight)
            if hLeft >= hRight:
                right = right - 1
                if right > left and height[right] < h:
                    vol = vol + h - height[right]
                if right > left and height[right] > h:
                    hRight = height[right]
            else:
                left = left + 1
                if left < right and height[left] < h:
                    vol = vol + h - height[left]
                if left < right and height[left] > h:
                    hLeft = height[left]
        return vol
            


