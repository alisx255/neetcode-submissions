class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        n = len(s)
        start = 0
        maxLen = 0
        currLen = 0
        alph = {}
        maxC = 0
        first = 0
        end = 0
        maxFreq = 0
        for end in range(n):
            c = s[end]
            alph[c] = alph.get(c, 0) + 1
            maxFreq = max(maxFreq, alph[c])

            if (end - start + 1 - maxFreq) > k:
                alph[s[start]] -= 1
                start += 1
            maxLen = max(maxLen, end - start + 1)

        return maxLen