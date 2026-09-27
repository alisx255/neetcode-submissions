class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        prefixMin = [0] * n
        prefixMax = [0] * n
        amin = prices[0]
        amax = prices[n - 1]
        maxDiff = 0

        for i in range(n):
            if prices[i] < amin:
                amin = prices[i]
            prefixMin[i] = amin

            if prices[n - 1 - i] > amax:
                amax = prices[n - 1 - i]
            prefixMax[n - 1 - i] = amax
        
        for i in range(n):
            if prefixMax[i] - prefixMin[i] > maxDiff:
                maxDiff = prefixMax[i] - prefixMin[i]

        return maxDiff

        