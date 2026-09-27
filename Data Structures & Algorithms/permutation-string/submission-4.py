class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        n1 = len(s1)
        n2 = len(s2)
        if n1 > n2:
            return False
        count1 = [0] * 26
        count2 = [0] * 26

        for i in range(n1):
            c = s1[i]
            c2 = s2[i]
            enc = ord(c) - ord('a')
            enc2 = ord(c2) - ord('a')
            count1[enc] += 1
            count2[enc2] += 1

        matches = 0
        for i in range(26):
            if count1[i] == count2[i]:
                matches += 1

        start = 0
        for end in range(n1, n2):
            if matches == 26:
                return True
            
            index = ord(s2[end]) - ord('a')
            count2[index] += 1
            if count2[index] == count1[index]:
                matches += 1
            elif count1[index] + 1 == count2[index]:
                matches -= 1
            
            index = ord(s2[start]) - ord('a')
            count2[index] -= 1
            if count2[index] == count1[index]:
                matches += 1
            elif count1[index] - 1 == count2[index]:
                matches -= 1
            start += 1
        return matches == 26




        