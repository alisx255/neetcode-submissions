class Solution:
    def minWindow(self, s: str, t: str) -> str:
        ns = len(s)
        nt = len(t)
        freq = {}
        freqC = {}
        if nt > ns:
            return ""
        left = 0
        for i in range(nt):
            c = t[i]
            freq[c] = freq.get(c, 0) + 1
            freqC[c] = 0
        
        minLen = ns + 1
        currLen = 0
        matches = 0
        rang = [0, -1]
        #print(freq)
        for right in range(ns):

            c = s[right]
            #print(left); print(right)
            while left <= right and s[left] not in freq:
                left += 1
                currLen -= 1
            if c in freq:
                freqC[c] += 1
                if freqC[c] == freq[c]:
            #        print('???')

                    matches += 1                    
                notFirst = False
                while left <= right:
                    if s[left] in freq:
                        if freqC[s[left]] - 1 < freq[s[left]]:
                            break
                        else:
                            freqC[s[left]] -= 1
                            left += 1
                            currLen -= 1
                    else:
                        left += 1
                        currLen -= 1
                        
                currLen += 1
            #print(left); print(right)

            while left <= right and s[left] not in freq:
                left += 1
                currLen -= 1
            #print(left); print(right) ; print('.')
            #print(matches)
            currLen = right - left + 1

            if matches == len(freq):
                #print(True)

                if currLen < minLen:
                    print(left); print(right)
                    print(s[left]); print(s[right])
                    print(minLen)
                    minLen = currLen
                    rang[0] = left
                    rang[1] = right

        return s[rang[0]:rang[1] + 1]

                
                

