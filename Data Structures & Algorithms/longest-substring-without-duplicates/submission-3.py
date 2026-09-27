class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        alph = {}
        start = 0
        end = 0
        maxLen = 0
        currLen = 0
        for i in range(n):
            c = s[i]
            if c in alph:
                lastSaw = alph[c]
            else:
                lastSaw = -1
            alph[c] = i
            if lastSaw < start:
                currLen += 1
            else:
                start = lastSaw + 1
                currLen = i - start + 1
            if currLen > maxLen:
                maxLen = currLen
        return maxLen

